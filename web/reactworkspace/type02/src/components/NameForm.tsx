import {useState, type ChangeEvent, type FormEvent} from "react";

const NameForm = () => {
  // name이 문자열임을 명시
  const [name, setName] = useState<string>("");

  // ChangeEvent: 이벤트 객체의 타입을 정의하는 제네릭 타입
  // HTMLInputElement: 이벤트가 발생한 요소의 타입을 나타내는 HTML 태그 타입
  // ChangeEvent<HTMLInputElement>를 통해 input 엘리먼트의 이벤트임을 명시
  // 풀어쓰자면 HTML의 Input Element에서 일어난 ChangeEvent다 (타입스크립트에서는 필수로 명시해야함)
  const handleChange = (e: ChangeEvent<HTMLInputElement>) => {
    setName(e.target.value);
  };

    // 최신스타일은 함수 자체를 FormEventHandler로 선언하거나 아예 인라인함수로 넣거나.
    // const handleSubmit = (e: FormEvent<HTMLFormElement>) => {
    const handleSubmit: React.FormEventHandler = (e) => {
    e.preventDefault()
    alert(`제출된 이름 ${name}`)
  }
  return (
    <form onSubmit={handleSubmit} style={{border: "1px solid #ccc", padding: "20px", margin: "10px"}}>
      <h3>예제 3: 입력 폼 (이벤트 타입)</h3>
      <input
        type="text"
        placeholder="이름을 입력하세요"
        value={name}
        onChange={handleChange}
      />
      <p>입력하신 이름: {name ? <strong>{name}</strong> : "없음"}</p>
      <button type="submit">제출</button>
    </form>
  );
};

export default NameForm;
