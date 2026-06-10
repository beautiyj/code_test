// jwt토큰
// 회원관리실행 화면: 웹브라우저(F12) – Application – Storage – jwtToken 확인해보면 토큰 발행된 거 확인 가능함
// 서버쪽은 따로 만들어진 거 연결해둔거라 코드는 참고만 하면 됨

export const saveToken = (token) => {
  localStorage.setItem("jwtToken", token);
};

export const getToken = () => {
  return localStorage.getItem("jwtToken");
};

export const removeToken = () => {
  localStorage.removeItem("jwtToken");
};

// 함수 여러 개 있으면 export default 사용 불가함
// 객체 하나로 묶어서 export default로 내보내거나 그냥 각각 export
// export const로 내보내는 방법 더 많이 씀

/* jwt토큰은 크게 3가지 저장소가 존재함
1. localStorage   →  브라우저 로컬스토리지 (PC에 영구 저장)
                     자동로그인 구현 시
2. sessionStorage →  브라우저 세션스토리지 (탭 닫으면 삭제)
                     탭 닫으면 로그아웃 되어야 할 때
3. Cookie         →  쿠키 (만료기간 설정 가능)
                     보안상 가장 권장 (httpOnly 옵션)


*/