import React,{ useState, useEffect} from "react";
import { useParams, useLocation } from "react-router-dom";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export const BoardContent = () => {

    const { no } = useParams();                              // /boardcontent/:no
    const query = new URLSearchParams(useLocation().search);
    const page = query.get("page");

    const [boards, setBoards] = useState([]);

    const navigate = useNavigate();

    // 컴포넌트가 처음 렌더링될 때 1번만 실행
    useEffect(() => {
        // axios를 이용하여 GET 방식으로 데이터 가져오기
        axios.get('http://localhost:9999/boardcontent/'+no)
            .then((res) => {
                console.log(res.data);
                setBoards(res.data);      // 가져온 데이터를 boards 배열에 저장
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('데이터를 가져오는 중 오류가 발생하였습니다.');
            });
    }, []);


    return (<div style={{ textAlign: 'center', padding: '20px' }}>
            <h2>상세 페이지</h2>
            <table border='1' cellPadding={5} cellSpacing={0} width="500" align="center">  
                    <tr>    
                        <th>제목</th>
                        <td>{boards.title}</td>
                    </tr>
                    <tr>    
                        <th>작성자</th>
                        <td>{boards.writer}</td>
                    </tr>
                    <tr>    
                        <th>내용</th>
                        <td>{boards.content}</td>
                    </tr>
                    <tr>    
                        <th>등록일</th>
                        <td>{boards.register}</td>
                    </tr>
                    <tr>
                        <td colSpan={2} style={{ textAlign: 'center' }}>
                            <button onClick={() => navigate(`/boardlist?page=${page}`)}>목록</button>
                            <button onClick={() => navigate(`/boardupdateform/${boards.no}?page=${page}`)}>수정</button>
                            <button onClick={() => navigate(`/boarddeleteform/${boards.no}?page=${page}`)}>삭제</button>
                        </td>
                    </tr>
            </table>
        </div>
    );

}