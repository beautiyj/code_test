import axios from "axios";
import "./App.css";

const Main1 = () => {
  return (
    <div className="App">
      <h1>react ajax연습 Main1 </h1>
      <h5>F12 콘솔창 보면 데이터 받아오는 거 확인 가능함 </h5>
      <h5>버튼 클릭할 때마다 콘솔창에서 데이터 받아옴 </h5>

      <button
        onClick={() => {
          axios
            .get("https://codingapple1.github.io/shop/data2.json")
            // catch 콘솔을 보려면 아래의 이상한 주소로 진행하기. 혹은 throw던져서 강제 에러 발생
            // .get("https://wqbeiqe[wplqmdihidnksasljd[pkwki]].json")
            .then((result) => {
              console.log("success");
              console.log(result);          // axios 응답 객체 전체
              console.log(result.data);     // 실제 JSON 데이터만
              alert("ok");
            })
            .catch(() => {
              console.log("fail");
            });
        }}
      >
        요청
      </button>
    </div>
  );
};

export default Main1;

/*  result는 axios 응답 객체 전체.
    result는 보통 response나 res 관례상 이런 변수 사용함
data      →  실제 JSON 데이터
status    →  200, 404 등 HTTP 상태코드
headers   →  응답 헤더
config    →  요청 설정 정보
request   →  요청 객체
*/