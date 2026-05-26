import React from "react";

const Main = ({name, color}) => {
  return (
    <div>
      <main>
        <h2> 메인 </h2>
        <h3 style={{color}}> 이름은 {name} 입니다 </h3>
      </main>
    </div>
  );
};

export default Main;
