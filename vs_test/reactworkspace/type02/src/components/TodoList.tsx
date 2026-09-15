import {useState} from "react";

// Todo 아이템 하나에 대한 타입 정의
interface TodoItem {
  id: number;
  text: string;
}
const TodoList = () => {
  // TodoItem 구조를 가진 배열 상태 정의
  const [todos, setTodos] = useState<TodoItem[]>([
    {id: 1, text: "Vite 환경 구축하기"},
    {id: 2, text: "TypeScript 예제 실습하기"},
  ]);

  // inputText가 문자열임을 명시
  const [inputText, setInputText] = useState<string>("");
  
  // inputText가 비어있거나 공백만 있는 경우 추가하지 않음
  const addTodo = () => {
    if (!inputText.trim()) return;    // 빈 입력 방지
  
    // TodoItem 타입을 가진 newTodo 객체 생성
    // newTodo 객체가 TodoItem 인터페이스를 준수하도록 타입을 명시
    const newTodo: TodoItem = {
      id: Date.now(),                 // Date.now()를 사용하여 고유한 ID 생성
      text: inputText,
    };

    // 스프레드 연산자를 사용하여 기존 배열과 새로운 아이템을 합침
    setTodos([...todos, newTodo]);
    setInputText("");

  };

  return (
    <div style={{border: "1px solid #ccc", padding: "20px", margin: "10px"}}>
      <h3>예제 4: 할 일 목록 (배열 타입)</h3>
      <input value={inputText} placeholder="할 일 추가" onChange={(e) => setInputText(e.target.value)} />
      <button onClick={addTodo} style={{marginLeft: "5px"}}>
        추가
      </button>
      <ul>
        {todos.map((todo) => (
          <li key={todo.id}>{todo.text}</li>
        ))}
      </ul>
    </div>
  );
};

export default TodoList;
