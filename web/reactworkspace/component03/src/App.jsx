import "./App.css";
import Header from "./component/Header";
import Main from "./component/Main";
import Footer from "./component/Footer";

// 스프레드 연산자로 여러개의 값 전달하기
// 데이터가 많을수록 스프레드 자주 씀

function App() {
  const mainProps = {
    name: "홍길동",
    location: "서울시",
    // Main컴포넌트에 Props로 전달할 값을 mainProps객체 생성
    favorList: ["파스타", "빵", "떡볶이"],
  };

  return (
    <div className="App">
      <Header />
      <Main {...mainProps} /> { /* ... : 스프레드 연산자 */ }
      <Footer />
    </div>
  );
}

export default App;
