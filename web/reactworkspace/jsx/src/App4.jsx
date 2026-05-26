// and 연산자(&&)를 사용한 조건부 렌더링

function App4(){

    const name = 'react';
    const name2 = 'vue.js';

    return(
        <div>
            {name === 'react' && <h1>리액트 입니다.</h1>}
            {name2 !== 'react' && <h1>리액트가 아닙니다.</h1>}
        </div>
    );

}

export default App4;