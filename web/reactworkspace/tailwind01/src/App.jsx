import "./App.css";
import Button from "./Button";
import Login from "./Login";

function App() {
  return <div className="bg-blue-500 text-white text-3xl p-10">
    Tailwind 설치 성공
    {/* <Button /> */}
    <Login />
    </div>;
}
export default App;

/*
// 4. Tailwind CSS 프레임워크
// 기존의 CSS 작성 방식과 완전히 다른 패러다임을 제안하여
// 현대 웹 개발(특히 React, Vue, Next.js 등 컴포넌트 중심 프레임워크)에서
// 사실상의 표준(De-facto standard)으로 자리 잡은 오픈소스 CSS 프레임워크

/*
  Tailwind CSS v3 및 관련 라이브러리 설치
    npm install -D tailwindcss@3 postcss autoprefixer

  tailwind 초기화
    npx tailwindcss init -p

  생성되는 파일
    tailwind.config.js
    postcss.config.js

  tailwind.config.js 수정
    module.exports = {
      content: [
        "./index.html",
        "./src/** /*.{js,jsx,ts,tsx}",  // 원래 * /*  여기 붙어잇음 주석땜시 띄어쓰기해둠
      ],
      theme: {
        extend: {},
      },
      plugins: [],
    }

  CSS 파일 수정 : src/App.css
  기존 내용 전부 삭제후 아래 내용 추가
  @tailwind base;
  @tailwind components;
  @tailwind utilities;

  서버 재시작하면 잘 적용된 거 확인 가능

*/
