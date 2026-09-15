import React, {useState} from "react";
import axios from "axios";

// 글작성페이지

const PostForm = () => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      // .post("http://172.30.1.76:80/boardwrite", {
      .post("http://localhost:9999/boardwrite", {
        title: title,
        content: content,
      })
      .then((response) => {
        alert("글이 등록 되었습니다.");
        setTitle("");
        setContent("");
        console.log(response);
        console.log(response.data);
      })
      .catch((error) => {
    console.error("에러 상세 내용:", error); // 콘솔에 더 자세한 정보 출력
    if (error.response) {
        // 서버가 응답을 보내긴 했는데 에러 상태인 경우 (400, 500 등)
        alert("등록 실패: " + error.response.status); 
    } else {
        // 서버 연결 자체가 아예 안 된 경우
        alert("서버 연결 실패. URL을 확인하세요.");
    }
});
  };

  return (
    <form onSubmit={handleSubmit}>
      <h5>글 작성</h5>
      <input
        type="text"
        placeholder="제목을 입력하세요"
        name="title"
        value={title}
        size="30"
        required
        onChange={(e) => setTitle(e.target.value)}
      />{" "}
      <br />
      <textarea
        placeholder="내용을 입력하세요"
        name="content"
        value={content}
        size="30"
        required
        onChange={(e) => setContent(e.target.value)}
      ></textarea>
      <button type="submit">작성</button>
    </form>
  );
};

export default PostForm;
