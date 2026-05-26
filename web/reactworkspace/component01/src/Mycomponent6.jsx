import React from "react";

// ES6의 비구조화 할당 문법을 사용하여 내부의 값 추출하기
//function MyComponent6(props){

const MyComponent6 = (props) => {
  const {name, children, favoriteNumber} = props;
  return (
    <div>
      <h1>안녕 하세요?</h1>
      <h1>제 이름은 {name}입니다. </h1>
      <h1>children 값은 {children} 입니다. </h1>
      <h1>제가 좋아하는 숫자는 {favoriteNumber}입니다.</h1>
    </div>
  );
};
export default MyComponent6;
