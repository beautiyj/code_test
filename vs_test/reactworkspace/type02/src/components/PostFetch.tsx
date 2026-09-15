import {useState, useEffect} from "react";

// API에서 받아올 데이터의 타입 정의
interface Post {
  id: number;
  title: string;
  body: string;
}

const PostFetch = () => {
  // 처음에는 데이터가 없으므로 <Post | null> 상태로 시작
  const [post, setPost] = useState<Post | null>(null);
  // loading이 boolean 타입임을 명시
  const [loading, setLoading] = useState<boolean>(true);

  // fetch 함수는 JSON 자동변환 안돼서 변환 시켜주는 과정 필요
  useEffect(() => {
    fetch("https://jsonplaceholder.typicode.com/posts/1")
      .then((response) => response.json())
      .then((data: Post) => {
        setPost(data);
        setLoading(false);
      });
  }, []);   // 빈 배열 넣어서 한 번만 렌더링

  if (loading) return <div style={{margin: "10px"}}>로딩 중...</div>;

  return (
    <div style={{border: "1px solid #ccc", padding: "20px", margin: "10px"}}>
      <h3>예제 5: API Fetch (타입 추론 및 Null 처리)</h3>
      {post && (
        <div>
          <h4>제목: {post.title}</h4>
          <p>내용: {post.body}</p>
        </div>
      )}
    </div>
  );
};

export default PostFetch;
