import React, {useState, useEffect} from "react";
import axios from "axios";

// Spring boot로 생성한 서버에 요청하기
// 실제 만들어진 서버에 요청함
// 서버 부분의 코드는 리액트 ajax 파일 9번 21p~28p 참고

const Main3 = () => {
  const [review, setReview] = useState([]);
  useEffect(() => {
    axios
      .get("http://172.30.1.76:80/sample")    // 실제 만들어진 서버 주소(사설ip)를 기입하기
    //   .get("http://172.30.1.71:80/sample")    // 노트북용 주소는 영역대가 달라서 ip주소도 변경됨
      .then((response) => {
        console.log(response);
        console.log(response.data);
        setReview(response.data);
      })
      .catch((error) => {
        console.error("Error fetching data: ", error);
      });
  }, []); // 빈 배열을 전달하여 컴포넌트가 마운트될 때만 한 번 실행되도록 함

  return (
    <div>
      <h1>react ajax 연습</h1>
      <h5>스프링부트로 만들어진 서버에 요청하기(실제 서버 주소를 기입하기)</h5>
      mno : {review.mno}
      <br />
      First Name: {review.firstName}
      <br />
      Last Name: {review.lastName}
      <br />
    </div>
  );
}

export default Main3;

/* 출력은 각각 23, 홍, 길동 이렇게 출력됨
mno : 23
First Name: 홍
Last Name: 길동

코드는 이렇게 되어있음
// HomeController.java

@RestController
public class HomeController {

    @RequestMapping("/sample")
    public SampleVo sample() {
        SampleVo sv = new SampleVo();
        sv.setMno(23);
        sv.setFirstName("홍");
        sv.setLastName("길동");
        return sv;
    }

    @RequestMapping("/list")
    public List<SampleVo> list() {
        List<SampleVo> list = new ArrayList<>();
        for (int i = 1; i <= 10; i++) {
            SampleVo sv = new SampleVo();
            sv.setMno(i);
            sv.setFirstName("홍");
            sv.setLastName("길동" + i);
            list.add(sv);
        }
        return list;
    }
}

// ============================================================================

// SampleVo.java

@Data
public class SampleVo {
    private Integer mno;
    private String firstName;
    private String lastName;
}

*/
