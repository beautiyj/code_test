import React, {useState, useEffect} from "react";
import axios from "axios";

const Item = () => {
  const [review, setReview] = useState([]);

  // 화면이 실행 될때 한 번만 실행하기
  useEffect(() => {
    axios
    //   .get("http://localhost:3000/item.json") 이렇게 서버 브라우저로 연결해서 부르는 것도 가능
      axios.get("/item.json")
      .then((result) => {
        console.log(result);
        setReview(result.data);
      })
      .catch((err) => {
        console.log(err);
      });
  }, []);

  return (
    <div>
      <h1>react ajax연습</h1>
      {review.map((item, index) => (
        <div key={index}>
          <h3>id: {item.id}</h3>
          <p>name: {item.name}</p>
          <p>price: {item.price}</p>
          <p>description: {item.description}</p>
          <br /><hr />
        </div>
      ))}
    </div>
  );
}

export default Item;
