import Average from "./Average";
import Counter from "./Counter";
import Info from "./Info";
import Say from "./Say";

// useState 예제 1: 함수 컴포넌트에서 가변적인 상태를 처리해주는 훅 (하단 주석에 기존 코드 별첨)
// useState 예제 2 : useState를 여러 번 사용하기
// useState 예제 3 : 다중 useState & 버튼 이벤트 처리
// useState 예제 4 : 평균을 구해주는 함수 & 배열 활용


const App = () => {
  return (
    <div>
      <h1>훅 연습</h1>
      {/* <Counter /> */}
      {/* <Info /> */}
      {/* <Say /> */}
      <Average />
    </div>
  );
};
export default App;

/*
import Counter from "./Counter";

// useState 예제 1 : 함수 컴포넌트에서 가변적인 상태를 처리해주는 훅

// 서식은 const [ 변수명, set함수명 ] = useState( 초기값 )

    useState()에 초기값을 넣어서 호출하면 배열이 리턴됨
    리턴되는 배열의 첫 번째 항목은 state로 선언된 변수, 두 번째 항목은 해당 state의 set함수


const App = () => {
  return <Counter />
};
export default App;


++
리턴에 자식 컴포넌트 2개 이상 쓰려면 div 태그로 묶거나
// 이렇게 Fragment로 감싸기 (실무 많이 씀, div 없이)
return (
  <>
    <Counter />
    <Info />
  </>
)
*/


/*
import Info from "./Info";

// useState 예제 2 : useState를 여러 번 사용하기

const App = () => {
  return (
    <div>
      <h1>훅 연습</h1>
      <Info />
    </div>
  );
};
export default App;

*/
