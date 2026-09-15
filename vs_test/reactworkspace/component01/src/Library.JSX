import React from "react";
import Book from "./Book";

// 부모 컴포넌트 Library 자식 컴포넌트는 Book

const Library = () => {
  return (
    <div>
      <Book name="처음 만난 파이썬" numOfPages={300} />
      <hr></hr>
      <Book name="처음 만난 AWS" numOfPages={400} />
      <hr></hr>
      <Book name="처음 만난 리액트" numOfPages={500} />
    </div>
  );
};
21;
export default Library;
