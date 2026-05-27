import React, { useState } from 'react';

const EventPractice01 = () => {
  const [username, setUsername] = useState('');
  const [message, setMessage] = useState('');

  // onChangeUsername 메소드
  const onChangeUsername = e => setUsername(e.target.value);

  // onChangeMessage 메소드
  const onChangeMessage = e => setMessage(e.target.value);

  // onClick 메소드
  const onClick = () => {
    alert(username + ': ' + message);
    setUsername('');
    setMessage('');
  };

  return (
    <div>
      <h1>이벤트 연습</h1>
      <input
        type="text"
        name="username"
        placeholder="유저명"
        value={username}
        onChange={onChangeUsername}
      />
      <input
        type="text"
        name="message"
        placeholder="아무거나 입력해보세요"
        value={message}
        onChange={onChangeMessage}
      />
      <button onClick={onClick}>확인</button>
    </div>
  );
};

export default EventPractice01;