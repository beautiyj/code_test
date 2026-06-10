import React from "react";

function AttendanceBook(props) {
  const students = [
    {id: 1, name: "홍길동"},
    {id: 2, name: "홍길순"},
    {id: 3, name: "김길동"},
    {id: 4, name: "안화수"},
    {id: 5, name: "김이름"},
  ];

  return (
    <ul>
      {students.map((student, index) => {
        return (
          <li key={student.id}>
            인덱스 student.id {student.id}: 이름 student.name {student.name}
          </li>
        );
      })}
    </ul>
    
  );
}

export default AttendanceBook;
