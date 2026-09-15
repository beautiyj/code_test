import React from "react";
import styled from "styled-components";

// 리액트에 css 적용하는 방법

// 1. import 방식(전역방식)
// 2. inline 스타일 방식
// 3. styled-components 라이브러리

const App = () => {
  return (
    <Container>
      <h1>Hello styled-components🎨</h1>
      <StyledButton>기본 버튼</StyledButton>
      <StyledButton>또 다른 버튼</StyledButton>
    </Container>
  );
};

export default App;

/*
import React from "react";
import styled from "styled-components";

// 리액트에 css 적용하는 방법

// 1. import 방식(전역방식)
// 2. inline 스타일 방식

// 3. styled-components 라이브러리
// (npm install --save styled-components 로 설치,
// 최신 방식은 npm i styled-components)
//  CSS문법을 그대로 사용하면서 결과물을 스타일링된 컴포넌트 형태로 만들어 주는 오픈소스 라이브러리

const StyledButton = styled.button`
  background-color: #4caf50;
  color: white;
  padding: 12px 24px;
  margin: 8px;
  border: none;
  border-radius: 8px;
  font-size: 16px;
  cursor: pointer;
  &:hover {                        &는 현재 컴포넌트를 가리킴
    background-color: #45a049;
  }
`;

const Container = styled.div`
  display: flex;
  flex-direction: column;
  align-items: center;
  margin-top: 50px;
`;

const App = () => {
  return (
    <Container>
      <h1>Hello styled-components🎨</h1>
      <StyledButton>기본 버튼</StyledButton>
      <StyledButton>또 다른 버튼</StyledButton>
    </Container>
  );
};

export default App;

*/