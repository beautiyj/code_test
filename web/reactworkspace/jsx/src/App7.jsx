
// jsx안에서는 열린 태그는 반드시 닫아 주여야 한다.
function App7(){

    const name = 'react';

    return(
        <div>
            <h3>{name} 안녕 하세요~!!</h3>
            <form>
                    이름 : <input></input><br></br>
                    이메일 : <input type="email"/><br/>
                    비밀번호 : <input type="password"/><br/> 
                    제목 : <input type="text"/><br/>
                    내용 : <textarea rows={5} cols={30} /><br/>
                    이미지 : <img src="favicon.svg" title="로고" /><br/>
                    <button>제출</button>                
            </form>

        </div>
    );

}

export default App7;