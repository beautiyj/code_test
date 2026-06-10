import React from "react";
import {BrowserRouter, Routes, Route, Link} from "react-router-dom";
import Home from "./Home";
import About from "./About";

// React Router 설치
// npm install  react-router-dom

const App = () => {
  return (
    <BrowserRouter>
      <h1>hi react</h1>
      <ul>
        <li>
          <Link to="/">홈</Link>
        </li>
        <li>
          <Link to="/about">소개</Link>
        </li>
        {/* <li>
          <Link to="/test">test</Link>
        </li>
        링크 추가, 라우트 추가, jsx 파일에 브라우저 출력 화면 작성하면서 계속 추가 가능함*/}
      </ul>{" "}
      <hr />

      <Routes>
        <Route path="/" element={<Home />} />
        <Route path="/about" element={<About />} />
        {/* <Route path="/test" element={<Test />} /> */}
      </Routes>
    </BrowserRouter>
  );
};

export default App;

/* React Router의 태그    리액트 라우터 태그들
import { BrowserRouter, Routes, Route, Link }  from  'react-router-dom'; 임포트 필요

  <BrowserRouter> 브라우저 라우터
     React Router기능을 구현할 때 가장 바깥쪽에 사용하는 태그

  <Routes>
    <Routes>태그는 여러 Route를 감싸고 있고
    그중에서 규칙에 일치하는 Route 하나만을 렌더링 시켜주는 역할

<Route>
    1. Route태그는 path속성에 경로, element속성에는 컴포넌트를 넣어 준다.
    2. 형식 : <Route   path="경로"  element={<컴포넌트 />} />
              <Route   path="/"   element={<Home />} />
              <Route   path="/about"  element={<About />} />

<Link>
    1. 웹 페이지에서는 원래 링크를 보여줄 때 a태그를 사용하지만
    a태그는 클릭 시 페이지를 새로 불러오기때문에 React Router에서는 사용하지 않는다. 
    2. Link 태그는 a태그와 비슷한 기능이지만, History API를 통해 브라우저 주소의 경로만 바꾸는 기능이 내장되어있다. 
    3. 형식 :  <Link to="경로">링크명</Link>
              <Link to="/">홈</Link>
              <Link to="/about">소개</Link></li>
    4. Link 태그를 사용하기 위해서는 import 필요
       import { Link } from 'react-router-dom';

*/