import React, {useState} from "react";

// 평균을 구해주는 함수
const getAverage = (numbers) => {
  // main.jsx의 StrictMode때문에 콘솔이 2개씩 찍히는데 개발 모드에서만 그렇다고 함
  console.log("평균값 계산중..");

  if (numbers.length === 0) return 0;

  // reduce() : numbers 배열 원소들의 합을 구해주는 자바스크립트 배열 내장 메소드
  // 1+2=3 → 3+3=6 → 6+4=10 → 10+5=15처럼 a = 누적값, b = 현재값이 됨
  const sum = numbers.reduce((a, b) => a + b);
  return sum / numbers.length;
};

// Average 함수 컴포넌트
const Average = () => {
  const [list, setList] = useState([]); // 배열로 초기화
  const [number, setNumber] = useState("");

  // 입력되는 숫자 값을 계속 저장해두는 용도(입력 양식에 값 입력 시 호출되는 함수)
  const onChange = (e) => {
    setNumber(e.target.value);
  };

  const onReset = () => {
    setList([]);
    setNumber("");
  };

  // 등록 버튼 클릭 시 호출되는 함수
  const onInsert = (e) => {
    // concat(): 배열을 결합하여 새로운 배열을 생성하는 함수
    // 자바의 Integer.parseInt와 같은 역할. input으로 받으면 기본 text니까 정수 변환 필요
    const nextList = list.concat(parseInt(number));
    setList(nextList);
    setNumber("");
  };

  return (
    <div>
      <input value={number} onChange={onChange} />
      <button onClick={onInsert}>등록</button>
      <button onClick={onReset}>초기화</button>
      <ul>
        {list.map((value, index) => (
          <li key={index}>{value}</li>
        ))}
      </ul>
      <div>
        <b>평균값:</b> {getAverage(list)}
      </div>
    </div>
  );
};

export default Average;
