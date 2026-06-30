import axios from "axios";
import React, {useState} from "react";

// Spring boot로 생성한 서버에 post 요청하기2 - input.ver
// 실제 만들어진 서버에 요청함
// 스프링부트 서버는 "C:\Users\admin\Downloads\restapi01"
// http://localhost:3000/ 로 켜지는데 실제 데이터는 포트 9999/sample의 데이터를 불러옴
// 스프링부트 서버 켜진 상태에서, 리액트 PS D:\vs_test\reactworkspace\ajaxtest01> npm run dev 실행하면 데이터 받아온 거 확인 가능함


const Main6 = () => {
  const [mno, setMno] = useState("");
  const [firstName, setFirstName] = useState("");
  const [lastName, setLastName] = useState("");

  const loginaxios = (e) => {
    e.preventDefault();
    axios
      // .post("http://172.30.1.76:80/register2", {
      .post("http://localhost:9999/register2", {
        mno: mno,
        firstName: firstName,
        lastName: lastName,
      })
      .then((res) => {
        console.log(res.data);
        alert(res.data);
        if (res.status === 200) {
          alert("회원가입 성공");
        }
        setMno("");         // 입력값 초기화
        setFirstName("");
        setLastName("");
      })
      .catch((err) => {
        console.log(err);
      });
  }; // loginaxios() end

  return (
    <div>
    mno : <input type="text" onChange={(e) => {
        setMno(e.target.value);
    }} /> <br/><br/>
    firstName : <input type="text" onChange={(e) => {
        setFirstName(e.target.value);
    }} /> <br/><br/>
    lastName : <input type="text" onChange={(e) => {
        setLastName(e.target.value);
    }} /> <br/><br/>
    <button onClick={loginaxios}>회원가입</button>
    </div>
  );
} // Main6 end
export default Main6;

/*
메인5처럼 값 전달되는데 이제 사용자 입력한 데이터대로 들어감

// HomeController.java

@RestController
@CrossOrigin("*")
public class HomeController {
    @RequestMapping("/register2")
    public Integer register2(@RequestBody SampleVo sv) {
        System.out.println("mno:"+ sv.getMno());
        System.out.println("firstName:"+ sv.getFirstName());
        System.out.println("lastName:"+ sv.getLastName());
        int result = 1;
    return result;
    }
}

*/