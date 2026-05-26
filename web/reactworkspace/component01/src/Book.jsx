import React from "react";

// 자식 컴포넌트 Book 부모 컴포넌트는 Library

const Book = (props) => {
  return (
    <div>
      <h1>이 책의 이름은 {props.name}입니다.</h1>
      <h2>이 책은 총 {props.numOfPages}페이지로 이뤄져 있습니다.</h2>
      <br />
    </div>
  );
};
22;
export default Book;
