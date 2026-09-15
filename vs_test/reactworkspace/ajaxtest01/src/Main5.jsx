import axios from "axios";

// Spring boot로 생성한 서버에 post 요청하기
// 실제 만들어진 서버에 요청함
// 스프링부트 서버는 "C:\Users\admin\Downloads\restapi01"
// http://localhost:3000/ 로 켜지는데 실제 데이터는 포트 9999/sample의 데이터를 불러옴
// 스프링부트 서버 켜진 상태에서, 리액트 PS D:\vs_test\reactworkspace\ajaxtest01> npm run dev 실행하면 데이터 받아온 거 확인 가능함


const Main5 = () => {
    const loginaxios = (e) => {
        e.preventDefault();                      // 창이 새로고침 되는 것을 막아준다.

        axios
            // .post("http://172.30.1.76:80/register", {
            .post("http://localhost:9999/register", {
                mno: 30,
                firstName: "김",
                lastName: "길동",
            })
            .then((res) => {
                console.log(res.data);
                alert(res.data);
                if (res.status === 200) {       // 응답 성공 시 status 200 반환
                    alert("회원가입 성공");
                }
            })
            .catch((err) => {
                console.log(err);
            });
    };
    return (
        <div>
        <button onClick={loginaxios}>회원가입</button>
        </div>
    );
}

export default Main5;


/*
회원가입 버튼 누르면 백엔드엔 요청 전송되는 거 확인 가능,
브라우저에선 팝업 알림으로 1 뜬 다음 회원가입 성공 팝업 alert 총 2개 뜸
status 200 안뜨면 에러로 넘어가겠지만

// HomeController.java

@RestController
@CrossOrigin("*")
public class HomeController {

    @RequestMapping("/register")
    public Integer register(@RequestBody SampleVo sv) {
        System.out.println("mno:"+ sv.getMno());
        System.out.println("firstName:"+ sv.getFirstName());
        System.out.println("lastName:"+ sv.getLastName());
        int result = 1;

    return result;
    }
}


*/