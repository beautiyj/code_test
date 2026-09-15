
// jsx안에서는 조건부 연산자(조건 연산자)를 사용할 수 있다.
function App3(){

    const name = '리액트1';

    return(
        <div>

{name == '리액트' ? <h1>안녕하세요?{name}</h1> : <h1>Hello {name}</h1>}

        </div>
    );

}

export default App3;
