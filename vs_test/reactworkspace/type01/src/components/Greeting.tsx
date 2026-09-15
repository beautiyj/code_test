import UserInfo from "./UserInfo";

// 넘어올 Props의 타입을 정의
interface GreetingProps {
  name: string;
  age: number;
  email: string;
}

const Greeting = ({name, age, email}: GreetingProps) => {
  return (
    <div
      style={{
        border: "1px solid gray",
        marginBottom: "10px",
        padding: "10px",
      }}
    >
      <h2>안녕하세요, {name}님!</h2>
      {/* UserInfo에 나머지 데이터 전달 */}
      <UserInfo age={age} email={email} />
    </div>
  );
};

export default Greeting;
