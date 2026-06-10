// import MainList from "./MainList";
// import AttendanceBook from "./AttendanceBook";
// import IterationSample from "./IterationSample";
import IterationSample2 from "./IterationSample2";

const App = () => {
  return (
    <div>
      {/* <MainList /> */}
      {/* <AttendanceBook /> */}
      {/* <IterationSample /> */}
      <IterationSample2 />
    </div>
  );
};

export default App;


/*
    map함수 : 배열에 저장된 원소값을 반복적으로 구해오는 함수

    const subject = ["자바","오라클","JSP","Spring","파이썬"]
    
    subject.map((name, index) = > {             
      <li key={index}> {name} </li>
    })
*/