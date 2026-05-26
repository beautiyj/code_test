const MyComponent3 = (props) => {
  return (
    <div>
      <h1>안녕 하세요?</h1>
      <h1>제 이름은 {props.name}입니다.</h1>
      <h4>부모 컴포넌트 태그 사이의 값을 받을 때는 props.children으로 받는다</h4>
      <h1>children 값은 {props.children} 입니다.</h1>
    </div>
  );
};

export default MyComponent3;
