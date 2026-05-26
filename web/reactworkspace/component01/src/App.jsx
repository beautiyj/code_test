import {useState} from "react";
import reactLogo from "./assets/react.svg";
import viteLogo from "./assets/vite.svg";
import heroImg from "./assets/hero.png";
import "./App.css";
// import MyComponent from './MyComponent'
// import MyComponent2 from './MyComponent2'
// import MyComponent3 from "./Mycomponent3";
// import MyComponent4 from './MyComponent4'
// import MyComponent5 from './MyComponent5'
import MyComponent6 from './MyComponent6'

// 화면 출력되는 코드들
function App() {
  // return <MyComponent />
  // return <MyComponent2 name="name변수의 값: 홍길동" />
  // return <MyComponent3 name="홍길동">리액트</MyComponent3>;
  // return <MyComponent4 name="React">리액트</MyComponent4>;
  // return (
  //   <MyComponent5 name="React" favoriteNumber={3}>
  //     리액트 {/* ← 이게 children 값. 태그 사이의 텍스트*/}
  //   </MyComponent5>
  // );
  return (
    <MyComponent6 name="React" favoriteNumber={7}>
      리액트
    </MyComponent6>
  );
  // const [count, setCount] = useState(0)

  // // <> 이건 xml문법이고 시작할 때 루트 태그를 남기는 거임
  // // return (
  // //   <>
  // //     <section id="center">
  // //       <div className="hero">
  // //         <img src={heroImg} className="base" width="170" height="179" alt="" />
  // //         <img src={reactLogo} className="framework" alt="React logo" />
  // //         <img src={viteLogo} className="vite" alt="Vite logo" />
  // //       </div>
  // //       <div>
  // //         <h1>Get started</h1>
  // //         <p>
  // //           Edit <code>src/App.jsx</code> and save to test <code>HMR</code>
  // //         </p>
  // //       </div>
  // //       <button
  // //         type="button"
  // //         className="counter"
  // //         onClick={() => setCount((count) => count + 1)}
  // //       >
  // //         Count is {count}
  // //       </button>
  // //     </section>

  // //     <div className="ticks"></div>

  // //     <section id="next-steps">
  // //       <div id="docs">
  // //         <svg className="icon" role="presentation" aria-hidden="true">
  // //           <use href="/icons.svg#documentation-icon"></use>
  // //         </svg>
  // //         <h2>Documentation</h2>
  // //         <p>Your questions, answered</p>
  // //         <ul>
  // //           <li>
  // //             <a href="https://vite.dev/" target="_blank">
  // //               <img className="logo" src={viteLogo} alt="" />
  // //               Explore Vite
  // //             </a>
  // //           </li>
  // //           <li>
  // //             <a href="https://react.dev/" target="_blank">
  // //               <img className="button-icon" src={reactLogo} alt="" />
  // //               Learn more
  // //             </a>
  // //           </li>
  // //         </ul>
  // //       </div>
  // //       <div id="social">
  // //         <svg className="icon" role="presentation" aria-hidden="true">
  // //           <use href="/icons.svg#social-icon"></use>
  // //         </svg>
  // //         <h2>Connect with us</h2>
  // //         <p>Join the Vite community</p>
  // //         <ul>
  // //           <li>
  // //             <a href="https://github.com/vitejs/vite" target="_blank">
  // //               <svg
  // //                 className="button-icon"
  // //                 role="presentation"
  // //                 aria-hidden="true"
  // //               >
  // //                 <use href="/icons.svg#github-icon"></use>
  // //               </svg>
  // //               GitHub
  // //             </a>
  // //           </li>
  // //           <li>
  // //             <a href="https://chat.vite.dev/" target="_blank">
  // //               <svg
  // //                 className="button-icon"
  // //                 role="presentation"
  // //                 aria-hidden="true"
  // //               >
  // //                 <use href="/icons.svg#discord-icon"></use>
  // //               </svg>
  // //               Discord
  // //             </a>
  // //           </li>
  // //           <li>
  // //             <a href="https://x.com/vite_js" target="_blank">
  // //               <svg
  // //                 className="button-icon"
  // //                 role="presentation"
  // //                 aria-hidden="true"
  // //               >
  // //                 <use href="/icons.svg#x-icon"></use>
  // //               </svg>
  // //               X.com
  // //             </a>
  // //           </li>
  // //           <li>
  // //             <a href="https://bsky.app/profile/vite.dev" target="_blank">
  // //               <svg
  // //                 className="button-icon"
  // //                 role="presentation"
  // //                 aria-hidden="true"
  // //               >
  // //                 <use href="/icons.svg#bluesky-icon"></use>
  // //               </svg>
  // //               Bluesky
  // //             </a>
  // //           </li>
  // //         </ul>
  // //       </div>
  // //     </section>

  // //     <div className="ticks"></div>
  // //     <section id="spacer"></section>
  // //   </>
  // // )

  // return (
  //   <div>
  //     <h1>함수형 컴포넌트</h1>
  //   </div>
  // )
}

export default App;

/*

index.html          ← 브라우저가 제일 먼저 읽음
    └── main.jsx    ← index.html 이 main.jsx 를 불러옴
         └── App.jsx ← main.jsx 가 App.jsx 를 불러옴
              └── App2.jsx, App3.jsx... ← App.jsx 가 자식들 불러옴
              
              */
