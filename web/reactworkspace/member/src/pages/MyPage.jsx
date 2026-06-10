import React, {useState, useEffect} from "react";
import {useLocation, Link} from "react-router-dom";
import axios from "axios";
import {getToken} from "../utils/TokenUtils";    // jwt토큰

const MyPage = () => {
  const location = useLocation();

  const [user, setUser] = useState(null);

  useEffect(() => {
    const token = getToken();

    if (!token) {                               // 토큰이 없는 경우 = 로그인 성공을 하지 않아서 발급이 안된 거
      alert("로그인이 필요합니다.");
      window.location.href = "/login";          // 로그인 페이지로 이동
      return;
    }

    /* 발급받은 토큰이 정확한지 헤더에 코드 써서 서버로 검증 요청 보내기
    Authorization: 공식 헤더 이름.
        HTTP 프로토콜 규격에서 "이 요청은 신원 인증이 필요한 요청이다"라고 선언하는 공식 헤더 이름
    Bearer: 토큰의 종류(타입).
        "내가 지금 보내는 신분증은 JWT(또는 OAuth) 토큰 형태야"라고 서버에게 힌트를 주는 실무 표준 약속(Protocol)
    ${token}: 로그인 성공 시 로컬 스토리지 등에서 꺼내온 실제 암호화된 토큰 문자열 데이터
    
    그리고 주소 브라우저로 들어가도 403 오류뜸
    토큰 받고 리턴하는 형태라서 비정상적 경로로 인지하기땜시 로그인을 해야 마이페이지 오류가 안남
    */
    axios
      .get("http://172.30.1.76:80/api/profile", {
        headers: {
          Authorization: `Bearer ${token}`,     // 토큰을 Authorization 헤더에 Bearer 방식으로 포함하여 서버로 전송
        },
      })
      .then((response) => {
        setUser(response.data);                 // 사용자 정보를 user 상태에 저장
      })
      .catch((error) => {
        alert("사용자 정보 가져오기 실패");
        window.location.href = "/login";
      });
  }, []);

  if (!user) {
    return <div>로딩 중...</div>;
  }

  return (
    <div>
      <h2>마이 페이지</h2>
      <p>ID : {user.username}</p>
      <p>이름 : {user.name}</p>
      <p>이메일 : {user.email}</p>
      <p>가입일 : {user.reg_date}</p>
      <p>권한 : {user.role}</p>

      <Link to="/">홈으로</Link>
    </div>
  );
};

export default MyPage;

/* 출력 결과는 이렇게 나옴 회원가입하면서 적은 아이디 이름 이메일 그대로 출력됨
마이 페이지
ID : dkdlel
이름 : dlfma
이메일 : dlapdlf@email.com
가입일 : 2026-06-02
권한 : USER

홈으로      // 이건 링크

*/