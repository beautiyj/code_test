import React from "react";

const Main = ({name, location, favorList}) => {
  return (
    <div>
      스프레드 연산자 ... 를 사용한 예제
      <br />
      {name}은 {location}에 삽니다. <br />
      {favorList.length}개의 음식을 좋아합니다.
      <hr></hr>

      {favorList} 반복문처럼 뽑아서 출력하려면 Map 활용하기 <br />

      코드는
      <pre>
        {`favorList.map((item, index) => (
        <h3 key={index}>{item}</h3>
      ))`}{" "}
      </pre>

      <br />
      
      <ul>
        {favorList.map((item, index) => (
          <li><h3 key={index}>{item}</h3></li>
        ))}
      </ul>
    </div>
  );
};

export default Main;
