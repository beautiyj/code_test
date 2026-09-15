import "./App.css";
import Header from "./component/Header";
import Main from "./component/Main";
import Footer from "./component/Footer";


// 부모 컴포넌트 App
// 자식 컴포넌트는 헤더, 메인, 푸터
function App() {
  return (
    <div className="App">
      <Header />
      <Main name="홍길동" color="teal" />
      <Footer />
    </div>
  );
}
export default App;
