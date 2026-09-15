import React, {useState} from "react";

// useState 예제 1 : 함수 컴포넌트에서 가변적인 상태를 처리해주는 훅
const Counter = () => {

  // useState 서식인 변수명, 셋함수명, 초기값
  // const [변수, set함수] = useState(초기값);
  const [count, setCount] = useState(0);


  // 이벤트 핸들러
  return (
    <div>
      <p>총 {count}번 클릭했습니다.</p>
      <button onClick={() => setCount(count + 1)}>증가</button>
      <button onClick={() => setCount(count - 1)}>감소</button>
    </div>
  );

};

export default Counter;

/*
셋함수 방식 1 - 값 직접 넣기
    setCount(count + 1)
    <button onClick={() => setCount(0)}>초기화</button>
    <button onClick={() => setCount(count + 2)}> +2 증가</button>


셋함수방식 2 - 함수로 넣기 (실무 권장)
    setCount(prev => prev + 1)
              ↑ 매개변수    ↑ 이전 count 값에 +1

화살표 함수 축약형은                    이거랑 같은 의미임
    setCount(prev => prev + 1)          setCount(function(prev) {
                                            return prev + 1;
                                        })
*/