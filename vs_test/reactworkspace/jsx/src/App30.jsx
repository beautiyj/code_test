// jsx 외부에서는 기존 자바스크립트 문법을 그대로 사용할 수 있다.(if문, for문 등)
function App30(){

    let state = '';
    const login = 'y';

    if(login == 'y'){
        state = '로그인 성공';
    }else{
        state = '로그인 실패';
    }

    return(
        <div>
            <h1>{state}</h1>
        </div>
    );

}

export default App30;
