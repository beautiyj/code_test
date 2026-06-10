import {useState} from "react";

const Login = () => {
  const [id, setId] = useState("");
  const [pw, setPw] = useState("");

  const login = () => {
    alert(`아이디 : ${id}\n비밀번호 : ${pw}`);
  };

  return (
    <div className="bg-blue-100 h-screen flex justify-center items-center">
      <div className="bg-white p-8 rounded-xl shadow-md w-80">
        <h2 className="text-2xl font-bold mb-6 text-center">로그인</h2>
        <input
          type="text"
          placeholder="아이디"
          value={id}
          onChange={(e) => setId(e.target.value)}
          className="w-full border border-gray-300 p-3 rounded mb-4"
        />
        <input
          type="password"
          placeholder="비밀번호"
          value={pw}
          onChange={(e) => setPw(e.target.value)}
          className="w-full border border-gray-300 p-3 rounded mb-4"
        />
        <button onClick={login} className="w-full bg-blue-500 text-white py-3 rounded hover:bg-blue-700">
          로그인{" "}
        </button>
      </div>
    </div>
  );
};

export default Login;
