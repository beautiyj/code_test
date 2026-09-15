import "./App.css";
import Button from "./Button";
import Card from "./Card";
import Login from "./Login";

const App = () => {
  return (
    <div className="container mt-5">
      <h1 className="text-primary">Bootstrap 적용 완료</h1>
      <button className="btn btn-success">버튼</button>

      <Button />
      <Card />
      <Login />
    </div>
  );
};
export default App;


// 5. Bootstrap 부트스트랩 프레임워크 사용
// HTML/CSS/JavaScript 기반의 UI 프레임워크

/*  Bootstrap 의 장점
  반응형 웹을 쉽게 구현할 수 있음 + 버튼/카드/폼/모달 기능을 제공
  디자인을 빠르게 개발 할 수 있음 + 모바일 페이지에도 빠르게 적용 할 수 있음

  React에서 Bootstrap 사용 방법
  1. CDN 방식
  2. npm으로 bootstrap 설치
  3. React 전용 bootstrap 사용 ( react-bootstrap )


  1. bootstrap 설치
  npm install  bootstrap
  node_modules/bootstrap 폴더 생성됨

  2.  
  main.jsx 파일에 bootstrap 추가
  import 'bootstrap/dist/css/bootstrap.min.css';

  Bootstrap 추가 : src/main.jsx
  import { StrictMode } from 'react'
  import { createRoot } from 'react-dom/client'
  import './index.css'
  import App from './App.jsx'
  // 여기 부트스트랩 임포트 추가! 
  import 'bootstrap/dist/css/bootstrap.min.css';

  createRoot(document.getElementById('root')).render(
  
  <StrictMode>
    <App />
  </StrictMode>,
  )


*/
