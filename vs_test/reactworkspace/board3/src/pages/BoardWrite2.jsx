import React,{ useState} from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

export const BoardWrite = () => {

    // const [writer, setWriter] = useState('');
    // const [title, setTitle] = useState('');
    // const [content, setContent] = useState('');

    const [form, setForm] = useState({
        writer: '',
        title: '',
        content: '',
    });
    const navigate = useNavigate();

    // 입력 양식에 값 입력처리 이벤트
    const handleChange = (e) => {
       setForm({
          ...form,      //  기존 form 내용 복사   
          [e.target.name]: e.target.value // name 속성에 따라 값 설정
       });
    };

    // 글작성 버튼 클릭 이벤트
    const handleSubmit = (e) => {
       e.preventDefault();  // 새로고침 방지    
       if(form.writer.trim() === '' || form.title.trim() === '' || 
          form.content.trim() === ''){
          alert('모든 항목은 필수 입력입니다.');
          return;
       }        
         // axios를 이용하여 POST 방식으로 데이터 전송          
        axios.post('http://localhost:9999/boardwrite', 
                {writer: form.writer, title: form.title, content: form.content})   
            .then((res) => {
                console.log(res.data);        // 서버 응답 데이터 출력
                if(res.data === 1){           // 성공시
                   alert('글 작성이 완료되었습니다.');
                   navigate('/boardlist');    // 글목록 페이지로 이동
                } else {
                   alert('글 작성에 실패하였습니다.');
                }
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('글 작성 중 오류가 발생하였습니다.');
            });
    }   
   
    return(
          <div style={{ textAlign: 'center', padding:'20px'}}>
            <h2>글 작성</h2>
            <form onSubmit={handleSubmit}>
                <div>
                    <label>작성자:</label>
                    <input
                        type="text"
                        name="writer"
                        value={form.writer}
                        onChange={handleChange}
                        // onChange={(e)=>setWriter(e.target.value)}
                        required
                        placeholder="작성자명 입력"
                    />
                </div>
                <div>
                    <label>제목:</label>
                    <input
                        type="text"
                        name="title"
                        value={form.title}
                        onChange={handleChange}
                        required
                        placeholder="제목 입력"
                    />
                </div>
                <div>
                    <label>내용:</label>
                    <textarea
                        name="content"
                        value={form.content}
                        onChange={handleChange}
                        required
                        placeholder="내용 입력"
                        style={{ width: '300px', height: '150px' }}
                    />
                </div>
                <button type="submit" style={{ marginTop: '10px' }}>작성</button>
            </form>
         </div>);
};

// export default BoardWrite;