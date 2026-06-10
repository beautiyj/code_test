import React from "react";
import Header from "./Header";
import Home from "./Home";
import Product from "./Product";
import NotFound from "./NotFound";
import Footer from "./Footer";
import Test from "./Test";
import {BrowserRouter, Routes, Route} from "react-router-dom";

/* URL 파라미터와 쿼리 스트링: 유동적으로 값을 전달할 수 있다.
  
  URL 파라미터  :  /product/1
  쿼리 스트링   :  /product?product=1&searchKeyword=productName
*/
const App = () => {

  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <hr></hr>

        <Routes>
          {/* 슬래시(/)로 요청하면 Home.js 컴포넌트를 실행 */}
          <Route path="/" element={<Home />}></Route>

          {/* /product/1로 요청하면 Product.js 컴포넌트를 실행 */}
          <Route path="/product/:productId" element={<Product />}></Route>
          
          {/* 일치하는 라우트가 없는경우 NotFound.js 컴포넌트를 실행 */}
          <Route path="*" element={<NotFound />}></Route>
          
          <Route path="/test" element={<Test />}></Route>
        </Routes>

        <Footer />
        <hr></hr>
      </BrowserRouter>
    </div>
  );
};

export default App;


/*

URL 파라미터
    페이지의 주소를 정의할때, 유동적인 값을 전달하기 위한 문법
    /product/:productId 와 같이 경로에 콜론(:) 을 사용하여 설정
    URL 파라미터가 여러개인 경우 /product/:productId/:productName 과 같은 형태로 설정
      <Route path="/product/:productId" element={<Product />}></Route>

    productId를 받을 때는 다음과 같이 사용한다. – Product.jsx
      import { useParams } from 'react-router-dom’;

      방법1. const { 파라미터명 } = useParams();
             const { productId } = useParams(); 
      방법2. const 변수명 = useParams().파라미터명;
             const param = useParams().productId;


쿼리 스트링
    쿼리 스트링을 이용해서 유동적으로 값을 전달할 수 있다.
    URL 주소가 아래와 같을때
      http://localhost:3000/product/1?search=productName&q=demo
    물음표(?) 뒤에 search=productName&q=demo가 쿼리스트링

    쿼리스트링을 나누는 방법은 &를 사용해서 구분한다.
    쿼리 스트링 값을 받을때 자주 사용하는 훅(hooks)
      useLocation
      useSearchParams
      useNavigate


    useLocation()은 useParams()와 동일하게 현재 페이지의 쿼리스트링 반환된다.
    useLocation 작성은 const location = useLocation(); 으로 작성한다.
    useLocation에서 지원하는 속성
      pathname : 현재 주소의 경로(쿼리스트링 제외 ?앞의값)
      search : 맨앞에 ? 문자를 포함한 쿼리스트링 값
      state : 페이지로 이동할때 임의로 넣을수 있는 상태값
      key : location의 고유값, 초기에는 default이며 페이지가 변경될 때 마다 고유의 값 생성됨

    useSearchParams :  get()과 set()을 사용할 수 있다
      const [searchParams, setSearchParams]=useSearchParams(); 형식으로 사용

    useNavigate : Link태그를 사용하지 않고 페이지 이동을 할 때 사용하는훅(Hooks)이다. 
                  이전, 다음 페이지로 이동 할 때도 사용할 수 있다.
                  자바스크립트의 history 객체와 유사한 기능을 구현할 수 있다. 
*/