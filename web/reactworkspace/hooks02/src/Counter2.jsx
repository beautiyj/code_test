import React, {useState, useEffect} from "react";

const Counter2 = () => {
  const [count, setCount] = useState(0);

  // 첫 번째 파라미터는 이펙트 함수, 두 번째 파라미터는 의존성 배열이 들어감
  // 의존성 배열에 빈 배열( [ ] )을 넣으면 이펙트 함수를 마운트/언마운트 시 단 1번 실행됨
  // 의존성 배열은 생략할 수도 있는데, 생략하게 되면 컴포넌트가 업데이트 될 때 마다 호출
  useEffect(() => {
    document.title = count + "번 클릭";         // 브라우저의 타이틀 바에 적용됨
    console.log(count + "번 클릭");
  });
  {/*, [] 의존성 배열 위치에 이렇게 빈배열이 있을 경우 마운트 시 1번만 실행됨
    document.title = count + "번 클릭"; 이건 0번으로 유지됨, 하단 텍스트만 n번 적용됨 */} 

  return (
    <div>
      <p>총 {count}번 클릭했습니다.</p>
      <button onClick={() => setCount(count + 1)}>클릭</button>
    </div>
  );
};

export default Counter2;
