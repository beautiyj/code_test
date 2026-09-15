import React,{ useState, useEffect} from "react";
import { useParams, useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export const BoardUpdateForm = () => {

    const { no } = useParams();                              // /boardcontent/:no
    const query = new URLSearchParams(useLocation().search);
    const page = query.get("page");

    const [boards, setBoards] = useState([]);
    const [writer, setWriter] = useState('');
    const [title, setTitle] = useState('');
    const [content, setContent] = useState('');

    const navigate = useNavigate();

    // 컴포넌트가 처음 렌더링될 때 1번만 실행
    useEffect(() => {
        // axios를 이용하여 GET 방식으로 데이터 가져오기
        axios.get('http://localhost:9999/boardupdateform/'+no)
            .then((res) => {
                console.log(res.data);
                // setBoards(res.data);      // 가져온 데이터를 boards 배열에 저장
                setTitle(res.data.title);
                setWriter(res.data.writer);
                setContent(res.data.content);
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('데이터를 가져오는 중 오류가 발생하였습니다.');
            });
    }, []);

    // 글 수정 버튼 클릭 이벤트
    const handleSubmit = (e) => {
        e.preventDefault();  // 새로고침 방지    
        if(writer.trim() === '' || title.trim() === '' || content.trim() === ''){
            alert('모든 항목은 필수 입력입니다.');
            return;
        }   

        // axios를 이용하여 PUT 방식으로 데이터 전송          
        axios.put('http://localhost:9999/boardupdate', 
                    {no, writer, title, content})   
            .then((res) => {
                console.log(res.data);        // 서버 응답 데이터 출력
                if(res.data === 1){           // 성공시
                   alert('글 수정이 완료되었습니다.');
                   navigate(`/boardlist?page=${page}`);    // 글목록 페이지로 이동
                } else {
                   alert('글 수정에 실패하였습니다.');
                }
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('글 수정 중 오류가 발생하였습니다.');
            });
    }   

    return (<div style={{ textAlign: 'center', padding: '20px' }}>
            <h2>수정 페이지</h2>
            <form onSubmit={handleSubmit}>
                <input type="hidden" value={no} />
            <table border='1' cellPadding={5} cellSpacing={0} width="500" align="center">  
                    <tr>    
                        <th>제목</th>
                        <td>
                            <input type="text" value={title} onChange={(e) => setTitle(e.target.value)} />
                        </td>
                    </tr>
                    <tr>    
                        <th>작성자</th>
                        <td>
                            <input type="text" value={writer} onChange={(e) => setWriter(e.target.value)} />
                        </td>
                    </tr>
                    <tr>    
                        <th>내용</th>
                        <td>
                            <textarea value={content} onChange={(e) => setContent(e.target.value)} />
                        </td>
                    </tr>
                    <tr>
                        <td colSpan={2} style={{ textAlign: 'center' }}>
                            {/* <button onClick={() => navigate(`/boardlist?page=${page}`)}>목록</button> */}
                            <button type="submit">수정</button>
                        </td>
                    </tr>
            </table>
            </form>
        </div>
    );

}