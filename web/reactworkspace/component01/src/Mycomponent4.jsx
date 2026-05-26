const MyComponent4 = (props) => {
  const {name, children} = props;
  return (
    <div>
      <h1>안녕 하세요?</h1>
      <h4>ES6의 비구조화 할당 문법을 통해 props 내부 값 추출하기</h4>
      <h4>props로 받은 값을 name과 children 변수에 할당함</h4>
      <h1>제 이름은 {name}입니다. </h1>
      <h1>children 값은 {children} 입니다. </h1>
    </div>
  );
};
export default MyComponent4;
