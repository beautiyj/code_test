import React from "react";
// App.css 에서 불러올 때
import "./App.css";

// 함수형 컴포넌트
// function App2() {
//   const name = "함수형 컴포넌트";
//   return
//   <div className="react">{name}</div>;
// }

// es6형식의 화살표 함수 정의
const App2 = () => {
  const name = "리액트";
  
  // className으로 css 불러오기(임포트 필수)
  return <div className="react">{name} 안녕하세요</div>;
};

// 다른 곳에서 사용 가능하도록 export 부분 추가하기
export default App2;
