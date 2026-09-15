// import Greeting from "./components/Greeting";
// import Counter from "./components/Counter";
// import NameForm from "./components/NameForm";
// import TodoList from "./components/TodoList";
import PostFetch from "./components/PostFetch";

// 타입스크립트도 리액트 라우터 돔 설치 가능함
// import 기준: export 함수로 생성했으면 임포트 {함수} 
//             export default로 내보냈으면 임포트 함수


const App = () => {
  return (
    <div style={{maxWidth: "600px", margin: "0 auto", padding: "20px"}}>
      <h2>React + Vite + TypeScript 실습</h2> <hr />
      {/* <Counter /> */}
      {/* <Greeting name="홍길동" age={30} /> */}
      {/* <NameForm /> */}
      {/* <TodoList /> */}
      <PostFetch />
    </div>
  );
};

export default App;
