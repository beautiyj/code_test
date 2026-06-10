import React, {useState, useEffect} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";

// 글목록 페이지
export const BoardList = () => {
  const [boards, setBoardList] = useState([]);
  const navigate = useNavigate();

  // 컴포넌트가 처음 렌더링될 때 1번만 실행
  useEffect(() => {
    // axios를 이용하여 GET 방식으로 데이터 가져오기
    axios
      .get("http://172.30.1.76:80/boardlist")
      .then((res) => {
        console.log(res.data);
        setBoardList(res.data); // 가져온 데이터를 boards 상태배열에 저장
      })
      .catch((error) => {
        console.error("Error:", error);
        alert("데이터를 가져오는 중 오류가 발생하였습니다.");
      });
  }, []);

  return (
    <div style={{textAlign: "center", padding: "20px"}}>
      <h2>글 목록</h2>
      <table border="1" cellPadding={5} cellSpacing={0} style={{margin: "0 auto", width: "80%"}}>
        <thead>
          <tr>
            <th>번호</th>
            <th>제목</th>
            <th>작성자</th>
            <th>등록일</th>
          </tr>
        </thead>
        <tbody>
          {/* 조건부 연산자 사용하기. 글이 없으면 등록된 글 없음 메시지 띄우기
          테이블에 들어있는 컬럼명들을 순차적으로 출력 */}
          {boards.length > 0 ? (
            boards.map((board) => (
              <tr key={board.no}>
                <td>{board.no}</td>
                <td>{board.title}</td>
                <td>{board.writer}</td>
                <td>{board.register}</td>
              </tr>
            ))
          ) : (
            <tr>
              <td colSpan={4} style={{textAlign: "center"}}>
                등록된 글이 없습니다.
              </td>
            </tr>
          )}
        </tbody>
      </table>
    </div>
  );
}; // BoardList end

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