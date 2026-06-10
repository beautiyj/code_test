import React from "react";
import MainList01 from "./MainList01";
import MainList02 from "./MainList02";
import MainList03 from "./MainList03";

/* 부모 컴포넌트 App
   자식 컴포넌트는 MainList01 02 03

    순서대로
    names1 1차원 배열
    names2 2차원 배열
    names3 2차원 배열(객체, JSON 데이터 형태)
*/

const App = () => {
  const names1 = ["홍길동", "홍길순", "김길동"];
  const names2 = [
    ["홍길동", 19],
    ["홍길순", 29],
    ["김길동", 39],
  ];
  const names3 = [
    {userName: "홍길동", age: 19},
    {userName: "홍길순", age: 29},
    {userName: "김길동", age: 39},
  ];

  // 부모에서 filter/map 처리 후 자식에 전달하는 과정
  // 일반적으로 API호출, 데이터 필터링, 정렬은 부모 컴포넌트에서 진행
  // 선별된 데이터를 출력 혹은 가공하는 건 자식 컴포넌트에서.

  // 배열의 원소를 자식 컴포넌트에 전달하기
  const nameList1 = names1.map((name) => <MainList01 name={name} />);
  const nameList2 = names2.map((v) => <MainList02 name={v[0]} age={v[1]} />);
  const nameList3 = names3.map((v) => <MainList03 name={v.userName} age={v.age} />);

  // filter함수를 이용해서 age가 30보다 큰 데이터만 자식 컴포넌트에 전달하기
  // 재할당 가능한 let 사용했는데 const도 일반적으로 사용하긴 함
  let nameList4 = names3.filter((v) => v.age > 30);
  nameList4 = nameList4.map((v) => <MainList03 name={v.userName} age={v.age} />);

  return (
    <div>
      {nameList1}
      <hr />
      {nameList2}
      <hr />
      {nameList3}
      <hr />
      {nameList4}
      <hr />
    </div>
  );
};

export default App;


/*
출력되는 결과물은

// nameList1 1차원 배열 
안녕 하세요? 홍길동입니다.
안녕 하세요? 홍길순입니다.
안녕 하세요? 김길동입니다.

// nameList2 2차원 배열
안녕 하세요? 홍길동(19세)입니다.
안녕 하세요? 홍길순(29세)입니다.
안녕 하세요? 김길동(39세)입니다.

// nameList3 2차원 배열(객체)
안녕 하세요? 홍길동(19세)입니다.
안녕 하세요? 홍길순(29세)입니다.
안녕 하세요? 김길동(39세)입니다.

// nameList3 2차원 배열(객체) 에서 필터링 처리
안녕 하세요? 김길동(39세)입니다.

*/