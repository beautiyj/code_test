import Greeting from "./components/Greeting";
import UserInfo from "./components/UserInfo";

const App = () => {
  const users = [
    {name: "홍길동", age: 25, email: "hong@test.com"},
    {name: "김철수", age: 30, email: "kim@test.com"},
  ];

  return (
    <div style={{padding: "20px", fontFamily: "Arial"}}>
      <h1>TypeScript 예제</h1>
      {users.map((user, idx) => (
        <>
          <Greeting key={idx} name={user.name} age={user.age} email={user.email} />
          <UserInfo key={idx} age={user.age} email={user.email} />
        </>
      ))}
    </div>
  );
};

export default App;
