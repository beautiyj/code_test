import React, {useState, useEffect } from "react";
import { useParams, useLocation } from "react-router-dom";
import { Link } from "react-router-dom";
import axios from "axios";

export const BoardList = () => {

    // 상세페이지, 수정폼에서 목록 페이지로 돌아올 때 현재 페이지 유지
    const query = new URLSearchParams(useLocation().search);
    const page1 = query.get("page");
    const pageNum = page1 ? parseInt(page1, 10) : 1;  // page1이 있으면 10진수 정수로 변환

    // const [boards, setBoards] = useState([]);
    const [boardlist, setBoardlist] = useState([]);
    const [page, setPage] = useState(pageNum);       // 현재 페이지
    const [listcount, setListcount] = useState(0);   // 전체 글 개수 추가
    const [pagecount, setPagecount] = useState(1);   // 전체 페이지 수
    const [startpage, setStartpage] = useState(1);   // 블록 시작 페이지
    const [endpage, setEndpage] = useState(1);       // 블록 끝 페이지 
    const limit = 10;                                // 한 페이지 글갯수 

    // page가 변경될 때마다 데이터 불러오기
    useEffect(() => {
        // axios를 이용하여 GET 방식으로 데이터 가져오기(데이터는 map으로 날아옴)
        axios.get('http://localhost:9999/boardlist?page='+page)
            .then((res) => {
                console.log(res.data.boardlist);
                setBoardlist(res.data.boardlist || []);// 가져온 데이터를 boardlist 배열에 저장
    //          setPage(res.data.page);                // 현재 페이지 정보 저장
                setListcount(res.data.listcount);      // 전체 글 개수 저장
                setPagecount(res.data.pagecount);
                setStartpage(res.data.startpage);
                setEndpage(res.data.endpage);
            })
            .catch((error) => {
                console.error('Error:', error);
                alert('데이터를 가져오는 중 오류가 발생하였습니다.');
            });
    }, [page]);      // page 변경될 때마다 다시 실행
    

    // 페이지 클릭 시 page 변경하기
    const movePage = (pageNum) => {
        if (pageNum < 1 || pageNum > pagecount) return;
        setPage(pageNum);
    };


    return (
        <div style={{ textAlign: 'center', padding: '20px' }}>
            <h2>글 목록</h2>
            <table border='1' cellPadding={5} cellSpacing={0}
                   style={{ margin: '0 auto', width: '80%' }}>
                 <tr>
                    <th>번호</th>
                    <th>제목</th>
                    <th>작성자</th>
                    <th>등록일</th>
                 </tr>

                {Array.isArray(boardlist) && boardlist.length > 0 ? ( /* 조건부 연산자 */       

                    boardlist.map((board, index) => {

                        // 화면 표시 번호 
                        const displayNo = listcount - ((page - 1) * limit) - index;
                        return (
                        <tr key={board.no}>  
                            <td>{displayNo}</td>
                            <td>
                                <Link to={`/boardcontent/${board.no}?page=${page}`}>
                                {/* <Link to={`/boardcontent/${board.no}`}> */}
                                    {board.title}
                                </Link>
                            </td>
                            <td>{board.writer}</td>
                            <td>{board.register}</td>
                        </tr>
                        )  
                    })

                ) : (
                    <tr>
                        <td colSpan={4} style={{ textAlign: 'center' }}>등록된 글이 없습니다.</td>
                    </tr>
                )}
            </table><br/><br/>
          

            {/* ---------------- 페이징 버튼 ---------------- */}
            <div>
                {/* 1. 첫 페이지 */}
                <button onClick={() => movePage(1)} disabled={page === 1}>
                    &laquo; 처음
                </button>

                {/* 2. 이전 블럭 */}
                <button
                    onClick={() => movePage(startpage - 1)}
                    disabled={startpage === 1}
                >
                    &lt; 이전
                </button>

                {/* 3. 현재 블럭(10개 페이지) */}
                 {/* Array.from({ 배열의 길이 }, map함수의 인자 */}
                {Array.from({ length: endpage - startpage + 1 }, (_, i) => {
                    const p = startpage + i;
                    return (
                        <button
                            key={p}
                            onClick={() => movePage(p)}
                            style={{
                                margin: "0 5px",
                                fontWeight: p === page ? "bold" : "normal",
                                color: p === page ? "red" : "black"
                            }}
                        >
                            {p}
                        </button>
                    );
                })}

                {/* 4. 다음 블럭 */}
                <button
                    onClick={() => movePage(endpage + 1)}
                    disabled={endpage >= pagecount}
                >
                    다음 &gt;
                </button>

                {/* 5. 마지막 페이지 */}
                <button
                    onClick={() => movePage(pagecount)}
                    disabled={page === pagecount}
                >
                    마지막 &raquo;
                </button>
            </div>

        </div>
    );

};

//export default BoardList;