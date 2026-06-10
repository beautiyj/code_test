import React, {useState} from "react";
import {useNavigate} from "react-router-dom";
import axios from "axios";
import {saveToken} from "../utils/TokenUtils";      // jwt토큰 위치로 임포트


const Login = () => {
  const navigate = useNavigate();
  const [username, setUsername] = useState("");
  const [password, setPassword] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();                     // 폼이 실제로 제출되는 것을 막음

    axios
      .post("http://172.30.1.76:80/api/login", {
        username: username,
        password: password
      })
      .then((response) => {
        alert("로그인 성공");
        console.log(response.data);         // 이건 token :{'eyJhbGciOiJIUz...'} 형태로 출력 
        console.log(response.data.token);   // 이건 eyJhbGciOiJIUz... 토큰만 출력
        saveToken(response.data.token);     // 로그인 성공 시 토큰 저장
        navigate("/mypage");                // 로그인 후 마이 페이지로 이동
      })
      .catch((error) => {
        alert("로그인 실패");
        console.error("로그인 실패:", error);
      });
  };

  return (
    <form onSubmit={handleSubmit}>
      <h2>로그인</h2>
      ID :{" "}
      <input
      type="text"
      name="username"
      placeholder="아이디"
      required
      onChange={(e) => setUsername(e.target.value)}
      /><br />
      비밀번호 :{" "}
      <input
        type="password"
        name="password"
        placeholder="비밀번호"
        required
        onChange={(e) => setPassword(e.target.value)}
      /><br />
      <button type="submit">로그인</button>
    </form>
  );
};

export default Login;