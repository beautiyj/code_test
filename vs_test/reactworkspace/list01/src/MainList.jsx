import React from "react";

const MainList = (props) => {
  const subject = ["자바", "오라클", "JSP", "Spring", "파이썬"];

  return (
    <ul>
      {subject.map(function (item) {
        return <li>{item}</li>;
      })}
      <br></br>
      {subject.map((item) => {
        return <li>{item}</li>;
      })}
      <br></br>
      {subject.map((item, index) => {
        return <li key={index}>인덱스 {index} : 값 {item}</li>;
      })}
      <br></br>
      {/* 가장 많이 쓰는 방식은 암묵적 방식(리턴 명시 없이)
          return + {} 대신 () 로 바로 반환 (암묵적 반환) */}
      {subject.map((item, index) => (
        <li key={index}>인덱스 {index} : 값 {item}</li>
      ))}
    </ul>
  );
};

export default MainList;
