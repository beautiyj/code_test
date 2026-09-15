import React from "react";
import {BrowserRouter, Routes, Route} from "react-router-dom";
import Home from "./pages/Home";
import Register from "./pages/Register";
import Login from "./pages/Login";
import MyPage from "./pages/MyPage";

// 기본 메인페이지는 Home
// 회원가입 페이지는 Register
// 로그인 페이지는 Login
// 마이페이지는 MyPage

// "C:\Users\admin\Downloads\securitymember" 백엔드와 연결 - 로컬호스트:9999로 수정

const App = () => {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/register" element={<Register />} />
        <Route path="/login" element={<Login />} />
        <Route path="/mypage" element={<MyPage />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
