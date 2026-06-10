import {useState} from "react";

const Counter = () => {
  // useState<number>로 count가 숫자형임을 명시
  const [count, setCount] = useState<number>(0);

  return (
    <div style={{border: "1px solid #ccc", padding: "20px", margin: "0 auto"}}>
      <h3>예제 1: 카운터</h3>
      <p>
        현재 count: <strong>{count}</strong>
      </p>
      <button onClick={() => setCount(count + 1)}>증가</button>
      <button onClick={() => setCount(count - 1)} style={{marginLeft: "5px"}}>
        감소
      </button>
    </div>
  );
}

export default Counter;