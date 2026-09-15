import React from 'react';
// 함수의 매개변수로 바로 값 전달하기
// 구조분해 할당 방식을 가장 많이 씀!

const MyComponent5 = ({name, children, favoriteNumber}) => {
  return (
    <div>
      <h1>안녕하세요? </h1>
      <h1>제 이름은 {name}입니다. </h1>
      <h1>children 값은 {children} 입니다. </h1>
      <h1>제가 좋아하는 숫자는 {favoriteNumber}입니다. </h1>
      <h5>매개변수 name, children, favoriteNumber 로 바로 값 전달하기</h5>
    </div>
  );
};
17;
export default MyComponent5;
