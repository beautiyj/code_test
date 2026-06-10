import React, {useState} from "react";

const IterationSample2 = () => {
  const [names, setNames] = useState([ // 배열로 초기화 (기본값 배열 선언)
    {id: 1, text: "눈사람"},
    {id: 2, text: "얼음"},
    {id: 3, text: "눈"},
    {id: 4, text: "바람"},
  ]);
  const [inputText, setInputText] = useState(""); // 입력한 text를 저장하는 변수
  const [nextId, setNextId] = useState(5);        // 새로운 항목을 추가할때 사용할 id

  const onChange = (e) => {
    setInputText(e.target.value);    // 키보드로 입력한 값을 inputText변수에 저장
  };

  const onClick = () => {               // 추가 버튼 클릭
    const nextNames = names.concat({    // concat으로 새로운 배열 생성
      id: nextId,                       // nextId를 id값으로 설정
      text: inputText,
    });
    setNextId(nextId + 1);              // nextId변수를 1증가
    setNames(nextNames);                // names값을 업데이트한다.
    setInputText("");
  };

  const nameList = names.map((name) => <li key={name.id}>{name.text}</li>);

  return (
    <div>
      <input value={inputText} onChange={onChange} />
      <button onClick={onClick}>추가</button>
      <div>{nameList}</div>
    </div>
  );
};

export default IterationSample2;
