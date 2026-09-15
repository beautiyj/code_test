import {useState} from "react";

const Login = () => {
  const [id, setId] = useState("");
  const [pw, setPw] = useState("");

  const login = () => {
    alert(`아이디 : ${id}`);
  };

  return (
    <div className="container mt-5" style={{width: "400px"}}>
      <h2 className="mb-4">로그인</h2>
      <input type="text" className="form-control mb-3" placeholder="아이디" onChange={(e) => setId(e.target.value)} />
      <input
        type="password"
        className="form-control mb-3"
        placeholder="비밀번호"
        onChange={(e) => setPw(e.target.value)}
      />
      <button className="btn btn-primary w-100" onClick={login}>
        로그인
      </button>
    </div>
  );
};

export default Login;
