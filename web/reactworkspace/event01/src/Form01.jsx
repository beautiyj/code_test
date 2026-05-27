import React, {useState} from "react";

const Form01 = (props) => {
  const [value, setValue] = useState("");
  
  const handleChange = (e) => {
    setValue(e.target.value);
    // setValue(e.target.value.toUpperCase());
  };

  const handleSubmit = (e) => {
    alert("입력한 이름: " + value);
    e.preventDefault();     // preventDefault: submit 이벤트 발생 시 새로고침 방지 역할
    // 새로고침 발생해도 칸에 입력한 데이터가 지워지지 않음 그러나 수동으로 새로고침하면 새고 적용됨
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        이름: <input type="text" value={value} onChange={handleChange} />
      </label>
      <button type="submit">제출</button>
    </form>
  );
};

export default Form01;
