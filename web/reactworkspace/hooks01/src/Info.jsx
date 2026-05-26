import React, {useState} from "react";

const Info = () => {

  const [name, setName] = useState("");
  const [nickname, setNickname] = useState("");
  
  // onChangeName() 함수 정의
  const onChangeName = (e) => {
    setName(e.target.value);
  };

  // onChangeNickname() 함수 정의
  const onChangeNickname = (e) => {
    setNickname(e.target.value);
  };

  return (
    <div>
      <div>
        {/* 이벤트 핸들러(input은 기본 텍스트로 받아오니까 타입 생략) */}
        이름: <input onChange={onChangeName} />
        닉네임: <input onChange={onChangeNickname} />
      </div>
      <div>이름 : onChangeName 함수를 사용함 - {name} </div>
      <div>닉네임 : onChangeNickname 함수를 사용함 - {nickname} </div>
    </div>
  );

};

export default Info;


/*  함수 정의 1개로 합쳐서 사용할 경우

    1. 변수와 초기값은 따로 넣어주고
    const [form, setForm] = useState({ name: "", nickname: "" });

    2. ... 라는 스프레드 연산자를 활용하기
    const onChange = (e) => {
    const { name, value } = e.target;
    setForm({ ...form, [name]: value });  // name 속성으로 자동 구분
    };

    3. name 속성으로 구분해주면 함수 하나로 각기 다른 값 적용됨
    <input name="name" onChange={onChange} />
    <input name="nickname" onChange={onChange} />
*/