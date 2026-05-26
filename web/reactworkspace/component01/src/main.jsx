import {StrictMode} from "react";
import {createRoot} from "react-dom/client";
import "./index.css";
// import App from './App.jsx'
// import App2 from './App2.jsx'
import Library from "./Library";

// id="root" 찾아서 App 컴포넌트 렌더링. 연결 역할
createRoot(document.getElementById("root")).render(
  <StrictMode>
    {/* <App /> */}
    {/* <App2 /> */}
    <Library />
  </StrictMode>,
);
