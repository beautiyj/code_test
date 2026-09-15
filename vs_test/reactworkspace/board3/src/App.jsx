import React from "react";
import { BrowserRouter, Routes, Route, Link } from "react-router-dom";
import { BoardWrite } from "./pages/BoardWrite";
import { BoardList } from "./pages/BoardList";
import { BoardContent } from "./pages/BoardContent";
import  { BoardUpdateForm } from "./pages/BoardUpdateForm";
import { BoardDeleteForm } from "./pages/BoardDeleteForm";

function App() {
  return (
    <BrowserRouter>
      <h1 style={{ textAlign: "center" }}>간단한 게시판</h1>
      <nav style={{ padding: "10px", background: "#f0f0f0" }}>
        <Link to="/boardlist" style={{ marginRight: "10px" }}>글목록</Link>
        <Link to="/boardwrite">글쓰기</Link>
      </nav>
      <Routes>
        <Route path="/boardlist" element={<BoardList />} />
        <Route path="/boardwrite" element={<BoardWrite />} />
        <Route path="/boardcontent/:no" element={<BoardContent />} />
        <Route path="/boardupdateform/:no" element={<BoardUpdateForm />} />
        <Route path="/boarddeleteform/:no" element={<BoardDeleteForm />} />
      </Routes>
    </BrowserRouter>
  );
}

export default App;
