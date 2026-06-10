import React from "react";
import {BrowserRouter, Routes, Route, Link} from "react-router-dom";
import { BoardWrite } from "./pages/BoardWrite";
import { BoardList } from "./pages/BoardList";

const App = () => {
  return (
    <BrowserRouter>
      <h1 style={{textAlign: "center"}}>간단한 게시판</h1>
     
      <nav style={{padding: "10px", background: "#f0f0f0"}}>
        <Link to="/boardlist" style={{marginRight: "10px"}}>
          글목록
        </Link>
        <Link to="/boardwrite">글쓰기</Link>
      </nav>
      
      <Routes>
        <Route path="/boardwrite" element={<BoardWrite />} />
        <Route path="/boardlist" element={<BoardList />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
