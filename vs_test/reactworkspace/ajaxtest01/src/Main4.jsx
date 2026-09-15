import React, {useState, useEffect} from "react";
import axios from "axios";

// Spring boot로 생성한 서버에 요청하기 2 - 리스트 버전
// 실제 만들어진 서버에 요청함
// 서버 부분의 코드는 리액트 ajax 파일 9번 21p~28p 참고

// 스프링부트 서버는 "C:\Users\admin\Downloads\restapi01"
// http://localhost:3000/ 로 켜지는데 실제 데이터는 포트 9999/list 의 데이터를 불러옴
// 스프링부트 서버 켜진 상태에서, 리액트 PS D:\vs_test\reactworkspace\ajaxtest01> npm run dev 실행하면 데이터 받아온 거 확인 가능함


const Main4 = () => {
  const [review, setReview] = useState([]);

  useEffect(() => {
    axios;
    axios
      // .get("http://172.30.1.76:80/list") // 실제 만들어진 서버 주소(사설ip)를 기입하기
      .get("http://localhost:9999/list") // 로컬호스트 스프링부트포트로(나는 9999설정해둠) 기입하기
      //   .get("http://172.30.1.71:80/list")    // 노트북용 주소는 영역대가 달라서 ip주소도 변경됨
      //   .get("http://172.30.1.71:80/list")    // 노트북용 주소는 영역대가 달라서 ip주소도 변경됨
      .then((response) => {
        console.log(response);
        console.log(response.data);
        setReview(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data: ", error);
      });
  }, []);
  // 빈 배열을 전달하여 컴포넌트가 마운트될 때만 한 번 실행되도록 함

  return (
    <div>
      <h1>react ajax 연습</h1>
      <h5>스프링부트로 만들어진 서버에 요청하기 리스트.ver (실제 서버 주소를 기입하기)</h5>

      {review.map((item, index) => (
        <div key={index}>
          <h3>mno: {item.mno}</h3>
          <p>First Name: {item.firstName}</p>
          <p>Last Name: {item.lastName}</p>
        </div>
      ))}
    </div>
  );
};
export default Main4;

/* 출력값은 1~10까지의 리스트
mno: 1
First Name: 홍
Last Name: 길동1

mno: 2
First Name: 홍
Last Name: 길동2

mno: 3
First Name: 홍
Last Name: 길동3

...

mno: 9
First Name: 홍
Last Name: 길동9

mno: 10
First Name: 홍
Last Name: 길동10
*/
