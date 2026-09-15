import "./App.css";
import "./styles.css";

// 리액트에 css 적용하는 방법

// 1. import 방식(전역방식)
// 2. inline 스타일 방식

const App = () => {
  return (
    <div className="App">
      <h1>CSS 연습</h1>

      <h2>import 방식</h2>
      <div className="nameBox">이름</div>
      <div className="nameBox">Email</div>
      
      <h2>inline 방식</h2>
      <div style={{color: "seagreen", backgroundColor: "thistle"}}>이름</div>
      <div style={{color: "seagreen", backgroundColor: "thistle"}}>Email</div>
      <div style={{color: "plum", backgroundColor: "peru"}}>ddd</div>
    </div>
  );
};

export default App;

/* 1. import 방식(전역방식)
      컴포넌트에서 CSS 파일을 직접 import하여 사용
      className 속성을 사용하여 외부 CSS 파일에 정의된 스타일을 엘리먼트에 적용할 수 있다.

const App = () => {
  return (
    <div className="App">
      <h2>import 방식</h2>
      <div className="nameBox">이름</div>
      <div className="nameBox">Email</div>
    </div>
  );
};
export default App;
*/

/* 2. inline 스타일 방식
      인라인(inline) 형태: style={ { css속성: 값,  css속성: 값 } }
      css속성명의 하이픈 -> 자바스크립트에선 카멜표기법
      HTML태그에 직접 스타일을 적용하는 방식. 객체 형태로 작성하기

const App = () => {
  return (
    <div className="App">
      <h2>inline 방식</h2>
      <div style={{color: "seagreen", backgroundColor: "thistle"}}>이름</div>
      <div style={{color: "seagreen", backgroundColor: "thistle"}}>Email</div>
    </div>
  );
};

*/
