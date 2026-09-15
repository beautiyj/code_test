import React from "react";
import {useParams} from "react-router-dom";
// import {useLocation} from "react-router-dom";
// import {useSearchParams} from "react-router-dom";
import {useNavigate} from "react-router-dom";

const Product = (props) => {
  const {productId} = useParams();

  // const location = useLocation();
  // http://localhost:3000/product/1?search=productName&q=demo
  // 들어가면 useLocation 쿼리스트링 적용된 거 확인 가능

  //---------------------------------------------------

  // http://localhost:3000/product/1?search=productName&q=demo
  // useSearchParams는 get()과 set()을 사용할 수 있다.
  // useSearchParams 서식은 const [searchParams, setSearchParams]=useSearchParams();

  // const [searchParams, setSearchParams] = useSearchParams();
  // const search = searchParams.get("search");
  // const q = searchParams.get("q");

  // ----------------------------------------------------

  const navigate = useNavigate();

  return (
    <div>
      <h3>{productId}번 상품 페이지 입니다.</h3>
      {/* <h3>useLocation</h3> */}
      {/* <h3>useSearchParams</h3> */}
      <h3>navigate</h3>

      <ul>
        {/* <li>hash : {location.hash}</li>
        <li>pathname : {location.pathname}</li>
        <li>search : {location.search}</li>
        <li>state : {location.state}</li>
        <li>key : {location.key}</li> */}

        {/* ------------------------------------------------------ */}
       
        {/* <li>search : {search}</li>
        <li>q : {q}</li> */}

        {/* ------------------------------------------------------ */}
        <ul>
          <li>
            <button onClick={() => navigate(-2)}>Go 2 pages back</button>
          </li>
          <li>
            <button onClick={() => navigate(-1)}>Go back</button>
          </li>
          <li>
            <button onClick={() => navigate(1)}>Go forward</button>
          </li>
          <li>
            <button onClick={() => navigate(2)}>Go 2 pages forward</button>
          </li>
          <li>
            <button onClick={() => navigate("/")}>첫 페이지</button>
          </li>
          <li>
            <button onClick={() => navigate("/test")}>테스트 페이지</button>
          </li>
        </ul>
      </ul>
    </div>
  );
};

export default Product;

/*  useLocation 출력값은
      hash :
      pathname : /product/1
      search : ?search=productName&q=demo
      state :
      key : default

    useSearchParams 출력값은
      search : productName
      q : demo

*/

/* URL 파라미터 예제
import React from "react";
import {useParams} from "react-router-dom";

const Product = (props) => {

  //1. const {파라미터명} = useParams();
  const {productId} = useParams();

  //2. const 변수명 = useParams().파라미터명;
  const param = useParams().productId;

  // 2가지 형태 모두 사용 가능하지만
  // 1번 구조분해할당 방식을 더 많이 씀!

  return (
    <div>
      <h3>{productId}번 상품 페이지입니다.(Product.js)</h3>
      <h3>{param}번 상품 페이지입니다.(Product.js)</h3>
    </div>
  );
};

export default Product;


*/
