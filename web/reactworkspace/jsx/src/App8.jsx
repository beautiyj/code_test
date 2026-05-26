// jsx의 주석문 :  {/* jsx의 주석문 */}
// jsx 주석 단축키 :  Ctrl + /
//                  Ctrl + shift + c
//                  Ctrl + shift + / (블럭잡고)
function App8(){

    const name = '리액트';

    return(
        <div>
            <div>{name} 안녕하세요~!!</div>
            // jsx의 주석문1    <br/>
            /* jsx의 주석문2 */ <br/>

            {/* jsx의 주석문3 */}   
            {/* jsx의 주석문4 */}
            {/* jsx의 주석문5 */}

            // 주석처리 안됨<br/>
            /* 주석처리 안됨 */ <br/>
        </div>
    );

}

export default App8;