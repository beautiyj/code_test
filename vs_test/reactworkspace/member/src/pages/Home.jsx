import React from "react";
import {Link} from "react-router-dom";

const Home = () => {
  return (
    <div>
      <h1>Home</h1>
      {/* css로 각 링크들 간격 벌려주기 없으면 다닥다닥 붙어있음 */}
      <Link to="/register" style={{marginRight: "10px"}}>
        회원가입
      </Link>
      <Link to="/login" style={{marginRight: "10px"}}>
        로그인
      </Link>
      <Link to="/mypage">마이페이지</Link>
    </div>
  );
};

export default Home;
