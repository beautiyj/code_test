import PostForm from "./component/PostForm";
import PostList from "./component/PostList";

// 게시판 만들기
// 서버 http://172.30.1.76:80
// 서버 http://localhost:9999   내 컴퓨터 스프링부트 포트와 연결

const App = () => {
  return (
    <div>
      <h5> 게시판 만들기 </h5>
      <h5> 10번 pdf에 코드 나머지 확인 가능함 </h5>
      <PostForm />
      <PostList />
    </div>
  );
}

export default App;
