// css를 설정할때 속성명은 카멜 표기법으로 작성해야 한다.
//  background-color  -->  backgroundColor
//  font-size  -->  fontSize
//  font-weight  -->  fontWeight

function App5(){

    const name = 'react';

    const mystyle = {
        color : 'aqua',
        backgroundColor : 'black',
        fontSize : '48px',
        fontWeight : 'blod',
        padding : 16
    };

    return(
        <div style={mystyle}>
            {name} 안녕하세요!
        </div>
    );

}

export default App5;