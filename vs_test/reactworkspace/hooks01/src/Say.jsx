import React, {useState} from "react";

const Say = () => {
  const [message, setMessage] = useState("test");

  const onClickEnter = () => {
    setMessage("안녕하세요?");
  };

  const onClickLeave = () => {
    setMessage("안녕히 가세요!");
  };

  const [color, setColor] = useState("MediumSlateBlue");

  return (
    <div>
      {/* 인라인 방식과 onClickEnter 함수 정의 방식 2가지 모두 결과는 동일함 */}
      <button onClick={() => setMessage("안녕하세요?")}>입장1</button>
      <button onClick={onClickEnter}>입장2</button>
      <button onClick={onClickLeave}>퇴장</button>
      <button
        onClick={() => {
          setMessage("test");
          setColor("MediumSlateBlue");
        }}
      >
        초기화
      </button>{" "}
      <h1 style={{color}}>{message}</h1>
      <button style={{color: "PaleVioletRed"}} onClick={() => setColor("PaleVioletRed")}>
        빨간색
      </button>
      <button style={{color: "SeaGreen"}} onClick={() => setColor("SeaGreen")}>
        초록색
      </button>
      <button style={{color: "DarkTurquoise"}} onClick={() => setColor("DarkTurquoise")}>
        파란색
      </button>
    </div>
  );
};
export default Say;
