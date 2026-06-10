import React, {useState, useEffect} from "react";
import axios from "axios";

// 글목록페이지

const PostList = () => {
  const [posts, setPosts] = useState([]); // 비어있는 배열로 초기화

  useEffect(() => {
    axios
      .get("http://172.30.1.76:80/boardlist")
      .then((res) => setPosts(res.data)) // 응답데이터를 posts 배열에 저장
      .catch((err) => {
        alert("글 목록 조회 실패");
        console.log(err);
      });
  }, []);

  return (
    <div>
      <h2>게시글 목록</h2>
      {posts.map((post, index) => (
        <li key={index}>
          <h3>
            {post.title}
            <br />
          </h3>
          <h3>{post.content}</h3>
          <hr />
        </li>
      ))}
    </div>
  );
};

export default PostList;
