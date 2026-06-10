import React, { useState } from "react";
import { useNavigate } from "react-router-dom";
import axios from "axios";

// 글작성 페이지

export const BoardWrite = () => {
  const [writer, setWriter] = useState('');
  const [title, setTitle] = useState('');
  const [content, setContent] = useState('');
  const navigate = useNavigate();

  // 글작성 버튼 클릭 이벤트
  const handleSubmit = (e) => {
    e.preventDefault();

    if (writer.trim() === '' || title.trim() === '' || content.trim() === '') {
      alert('모든 항목은 필수 입력입니다.');
      return;
    }

    // axios를 이용하여 POST 방식으로 데이터 전송
    axios.post('http://172.30.1.76:80/boardwrite', {
      writer: writer,
      title: title,
      content: content
    })
      .then((res) => {
        console.log(res.data);
        if (res.data === 1) {
          alert('글 작성이 완료되었습니다.');
          navigate('/boardlist');               // 글작성하면 바로 글목록 페이지로 이동함
        } else {
          alert('글 작성에 실패하였습니다.');
        }
      })
      .catch((error) => {
        console.error('Error:', error);
        alert('글 작성 중 오류가 발생하였습니다.');
      });
  }; // handleSubmit end

  return (
    <div>
      <h2>글 작성</h2>
      <form onSubmit={handleSubmit}>
        <div>
          작성자:
          <input
            type="text"
            value={writer}
            onChange={(e) => setWriter(e.target.value)}
            placeholder="작성자명 입력"
          />
        </div>
        <div>
          제목:
          <input
            type="text"
            value={title}
            onChange={(e) => setTitle(e.target.value)}
            placeholder="제목 입력"
          />
        </div>
        <div>
          내용:
          <textarea
            value={content}
            onChange={(e) => setContent(e.target.value)}
            placeholder="내용 입력"
            style={{ width: '300px', height: '150px' }}
          />
        </div>
        <button type="submit" style={{ marginTop: '10px' }}>작성</button>
      </form>
    </div>
  );
}; // BoardWrite end


/* DataBase 코드

create table reactboard2(
  no number primary key,
  writer  varchar2(30),
  title  varchar2(50),
  content  varchar2(200),     
  register  date);
  
create sequence reactboard2_seq
  start with 1
  increment by 1
  nocache;

*/