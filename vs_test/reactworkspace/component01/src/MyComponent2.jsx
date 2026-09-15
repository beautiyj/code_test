// 매개변수 props로 넣으면 됨
// props를 이용해서 값 전달 하기

const MyComponent2 = (props) => {
  return (
    <div>
      <h2>마이컴포넌트2 내용</h2>
      <h2>매개변수 props 사용함</h2>
      <h3>제 이름은 {props.name}입니다</h3>
    </div>
  );
};

export default MyComponent2;

/*
1. props는 프로퍼티(properties)의 줄임말
2. props는 부모 컴포넌트에서 자식 컴포넌트에게 데이터를 전달할 때 사용한다.
3. props를 전달받은 자식 컴포넌트에서는 데이터를 수정할 수 없다.

*/
/*
// 방식 1 - props 통째로 받기 (관례적 이름)
const Mycomponent2 = (props) => {
    return (
        <div>{props.name} {props.age}</div>
    );
};

// 방식 2 - 구조분해 할당 (실무 많이 씀)
const Mycomponent2 = ({ name, age }) => {
    return (
        <div>{name} {age}</div>
    );
};

*/
