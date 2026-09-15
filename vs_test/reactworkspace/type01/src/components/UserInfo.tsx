// 넘어올 Props의 타입을 정의
interface UserInfoProps {
  age: number;
  email: string;
}

const UserInfo = ({age, email}: UserInfoProps) => {
  return (
    <div style={{marginLeft: "20px"}}>
      <p>나이: {age}세</p>
      <p>이메일: {email}</p>
    </div>
  );
};

export default UserInfo;
