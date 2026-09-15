import React from "react";

// 자식 컴포넌트
const MainList02 = (props) => {
  return (
    <div>
      <h3>
        안녕 하세요? {props.name} ({props.age}세) 입니다.
      </h3>
    </div>
  );
};

export default MainList02;
