import React, {useState, useEffect} from "react";
import axios from "axios";

const Main2 = () => {
const [review, setReview] = useState([]);

  // 화면이 실행될 때(마운트) 한 번만 실행하기(괄호 마지막에 빈 배열(의존성 배열) 넣음)
  // [] 안넣으면 리액트 특성 상 상태 변경되면 계속 재렌더링,
  // 데이터를 받아오는 거 자체가 상태 변경이라 생각해서 무한루프됨
  useEffect(() => {
    axios
      .get("https://codingapple1.github.io/shop/data2.json")
      .then((result) => {
        console.log(result);
        setReview(result.data); // 서버에서 응답 받은 데이터를 review(state 상태)배열 변수에 넣음
        // setReview: 상태 변경 함수 (State Setter) review: 데이터가 저장되는 저장소 (State / 상태 변수)
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <div>
      <h1>react ajax연습</h1>
      <h5>브라우저에 데이터 순차적으로 출력해줌(1번만 실행됨)</h5>
      {review.map((item, index) => (
        <div key={index}>
          <h3>id : {item.id}</h3>
          <p>title : {item.title}</p>
          <p>content : {item.content}</p>
          <p>price : {item.price}</p>
          <br /><hr />
        </div>
      ))}
    </div>
  );
}

export default Main2;
