import React, {useState} from "react";

const TextArea01 = (props) => {
  const [value, setValue] = useState("");

  // handleChange 메소드 - e.target.value: value값 설정
  const handleChange = (e) => {
    setValue(e.target.value);
  };

  // handleSubmit 메소드 - preventDefault: 새로고침 방지
  const handleSubmit = (e) => {
    alert("입력한 요청사항: " + value);
    e.preventDefault();
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        요청사항: <br />
        {/* cols={40} rows={5} 는 숫자로 전달, ""는 문자로 전달 */}
        <textarea cols="40" rows="5" value={value} onChange={handleChange} placeholder="요청사항을 입력 하세요." />
      </label>
      <button type="submit">제출</button>
    </form>
  );
};

export default TextArea01;
