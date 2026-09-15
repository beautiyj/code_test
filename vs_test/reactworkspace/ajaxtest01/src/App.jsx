// import Main1 from "./Main1";
// import Main2 from "./Main2";
// import Main3 from "./Main3";
// import Main4 from "./Main4";
// import Main5 from "./Main5";
import Main6 from "./Main6";
// import Item from "./Item";

const App = () => {
  return (
    <div>
      <h5> axios 예제 </h5>
      {/* <Main1 /> */}
      {/* <Main2 /> */}
      {/* <Main3 /> */}
      {/* <Main4 /> */}
      {/* <Main5 /> */}
      <Main6 />
      {/* <Item /> */}
    </div>
  );
}

export default App;



/* axios 사용법 : npm install axios
  1. axios는 ajax를 구현하기 위한 대표적인 라이브러리이다.
  2. jQuery의 ajax 라이브러리와 비슷한 기능을 지원한다. 
  3. 브라우저, node.js를 위한 Promise API를 활용하는 HTTP 비동기 통신 라이브러리
  4. Promise객체를 리턴하고, 크로스 브라우징 기반으로 브라우저 호환성이 좋다. 
  5. 자동으로 JSON 데이터 형식으로 변환, 요청 취소 및 타임아웃 설정 가능

  GET    : axios.get(url[, config])        - 조회
  POST   : axios.post(url, data[, config]) - 생성
  PUT    : axios.put(url, data[, config])  - 수정
  DELETE : axios.delete(url[, config])     - 삭제

  데이터 요청 성공 시
    형식 : axios.get(데이터 요청할 URL)
                .then( ()=>{ 요청 성공시 실행할 코드 } )
          then() 안에 있는 코드가 실행된다.

  데이터 요청 실패 시
    형식 : axios.get(데이터 요청할 URL)
                .catch( ()=>{ 요청 실패시 실행할 코드 } )
          catch() 안에 있는 코드가 실행된다.
*/
