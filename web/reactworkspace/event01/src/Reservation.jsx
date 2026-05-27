import React, {useState} from "react";

const Reservation = (props) => {
  const [haveBreakfast, setHaveBreakfast] = useState(true);
  const [numberOfGuest, setNumberOfGuest] = useState(2);

  const handleSubmit = (e) => {
    alert("아침식사 여부:" + haveBreakfast + " 방문객 수:" + numberOfGuest);
    e.preventDefault();
  };

  return (
    <form onSubmit={handleSubmit}>
      <label>
        아침식사 여부:
        <input
          type="checkbox"
          checked={haveBreakfast}
          onChange={(e) => {
            setHaveBreakfast(e.target.checked);
          }}
        />
      </label>
      <br />
      <label>
        방문객 수:
        <input
          type="number"
          value={numberOfGuest}
          onChange={(e) => {
            setNumberOfGuest(e.target.value);
          }}
        />
      </label>
      <button type="submit">제출</button>

      {/* 조건부 연산자 활용 시 */}
      <div>아침식사 여부: {haveBreakfast ? "예" : "아니오"}</div>
      <div>방문객 수: {numberOfGuest}명 </div>
    </form>
  );
};

export default Reservation;
