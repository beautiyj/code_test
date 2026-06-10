interface GreetingProps {
  name: string;
  age?: number; // age는 선택적 프로퍼티로 설정
}

const Greeting = ({name, age}: GreetingProps) => {
  return (
    <div style={{border: "1px solid #ccc", padding: "20px", margin: "10px"}}>
      <h3>예제 2: 인사말 (Props)</h3>
      <p>
        안녕하세요, <strong>{name}</strong>님!
      </p>
      {age && <p>나이는 {age}세이시군요!</p>}
    </div>
  );
};

export default Greeting;
