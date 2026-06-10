import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";

const Register = () => {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");
  const [name, setName] = useState("");
  const [email, setEmail] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();

    axios
      .post("http://172.30.1.76:80/api/register", {
        username: username,
        password: password,
        name: name,
        email: email,
      })
      .then((response) => {
        alert("회원가입이 완료되었습니다.");
        console.log(response.data);
        // navigate("/login");                 // 팝업 확인 누르면 자동으로 로그인페이지 이동
      })
      .catch((error) => {
        alert("회원가입에 실패하였습니다. 다시 시도해주세요.");
        console.error(error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h1>회원가입</h1>
      {/* {" "} 이거 안넣으면 띄어쓰기 없이 딱 붙은 상태로 나옴 */}
      ID :{" "}
      <input
        type="text"
        name="username"
        placeholder="아이디"
        onChange={(e) => setUsername(e.target.value)}
      /><br />
      비밀번호 :{" "}
      <input
        type="password"
        name="password"
        placeholder="비밀번호"
        onChange={(e) => setPassword(e.target.value)}
      /><br />
      이름 :{" "}
      <input
        type="text"
        name="name"
        placeholder="이름"
        onChange={(e) => setName(e.target.value)}
      /><br />
      이메일 :{" "}
      <input
        type="email"
        name="email"
        placeholder="이메일"
        onChange={(e) => setEmail(e.target.value)}
      /><br />
      <button type="submit">회원가입</button>
    </form>
  );
};

export default Register;

/*  데이터베이스 코드에 id는 pk 설정되어있어서
jsx의 id 입력 받은 값은 변수 username에 저장

CREATE TABLE users (
  id           NUMBER        PRIMARY KEY,            -- 기본키
  username     VARCHAR2(50)  UNIQUE NOT NULL,        -- 로그인 ID
  password     VARCHAR2(200) NOT NULL,               -- 암호화된 비밀번호
  name         VARCHAR2(100),                        -- 이름
  email        VARCHAR2(100),                        -- 이메일
  role         VARCHAR2(20)  DEFAULT 'USER',         -- 권한: USER / ADMIN
  reg_date     DATE          DEFAULT SYSDATE         -- 가입일
);

CREATE SEQUENCE users_seq
START WITH 1
INCREMENT BY 1
NOCACHE;

*/