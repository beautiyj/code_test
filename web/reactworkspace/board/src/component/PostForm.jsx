import React, {useState} from "react";
import axios from "axios";

// 글작성페이지

const PostForm = () => {
  const [title, setTitle] = useState("");
  const [content, setContent] = useState("");

  const handleSubmit = (e) => {
    e.preventDefault();
    axios
      .post("http://172.30.1.76:80/boardwrite", {
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
        alert("등록 실패");
        console.error(error);
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
