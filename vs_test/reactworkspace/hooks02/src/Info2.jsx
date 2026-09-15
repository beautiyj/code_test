import React, {useState, useEffect} from "react";

const Info2 = () => {
  const [name, setName] = useState("");
  const [nickname, setNickname] = useState("");

  const onChangeName = (e) => {
    setName(e.target.value);
  };

  const onChangeNickname = (e) => {
    setNickname(e.target.value);
  };

  useEffect(() => {
    console.log("렌더링이 완료 되었습니다.");
    console.log({name, nickname});
  });

  // console.log({name, nickname}); 없이 }, [name, nickname]); 의존성 배열에
  // 이름과 닉네임 넣을 경우 콘솔 로그는 렌더링이 완료 되었습니다.<만 뜨고 앞에 숫자만 늘어남
  // 콘솔 로그에 이름 닉네임을 넣어야 이름 혹은 닉네임 바뀔 때마다 로그 추가 + 콘솔에도 바뀐 이름과 닉네임 같이 찍힘

  // useEffect(()=>{
  //   console.log("마운트될 때만 실행됩니다.");
  // }, []);   <- 이쪽이 의존성 배열 위치! [] 빈 배열이면 마운트/언마운트 시 1번만 실행됨

  return (
    <div>
      <div>
        이름: <input onChange={onChangeName} />
        닉네임: <input onChange={onChangeNickname} />
      </div>
      <div>이름 : {name} </div>
      <div>닉네임 : {nickname} </div>
    </div>
  );
};
export default Info2;
