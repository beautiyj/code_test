import React from "react";
import Counter2 from "./Counter2";
import Info2 from "./Info2";


/* useEffect: 리액트 컴포넌트가 렌더링될 때마다 특정 작업이 수행하도록 설정할 수 있는 훅
  컴포넌트가 마운트 됐을 때 (처음 나타났을 때)
            언마운트 됐을 때 (사라질 때)   
            업데이트 될 때 (특정 props가 바뀔 때) 처리할 수 있는 훅

  useEffect ( 이펙트 함수, 의존성 배열 )

  useEffect ( () => {

    1. 컴포넌트가 마운트 된 이후
      의존성 배열에 있는 변수들 중 하나라도 값이 변경 되었을 때 실행됨
    
    2. 의존성 배열에 빈 배열([])을 넣을 경우
      마운트와 언마운트 시 단 한 번씩만 실행됨

    3. 의존성 배열 생략 시 컴포넌트 업데이트 될 때마다 실행됨

  } ,  [의존성 변수1, 변수2, …] ) ;


*/
const App = () => {
  return (
    <div>
      <h3>useEffect 예제</h3>
      {/* <Counter2 /> */}
      <Info2 />
    </div>
  );
};

export default App;
