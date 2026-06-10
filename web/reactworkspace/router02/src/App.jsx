import React from "react";
import Header from "./Header";
import Home from "./Home";
import Product from "./Product";
import NotFound from "./NotFound";
import Footer from "./Footer";
import {BrowserRouter, Routes, Route} from "react-router-dom";

const App = () => {

  return (
    <div className="App">
      <BrowserRouter>
        <Header />
        <hr></hr>

        <Routes>
          {/* 슬래시(/)로 요청하면 Home.js 컴포넌트를 실행 */}
          <Route path="/" element={<Home />}></Route>
        
          {/* /product/1로 요청하면 Product.js 컴포넌트를 실행 */}
          <Route path="/product/*" element={<Product />}></Route>
        
          {/* 일치하는 라우트가 없는경우 NotFound.js 컴포넌트를 실행 */}
          {/* 위에 있는 홈, 프로덕트 임포트까지 주석 처리하고 실행하면 낫파운드 페이지 뜸 */}
          <Route path="*" element={<NotFound />}></Route>
        </Routes>
        <Footer />

        <hr></hr>
      </BrowserRouter>
    </div>
  );
};

export default App;
