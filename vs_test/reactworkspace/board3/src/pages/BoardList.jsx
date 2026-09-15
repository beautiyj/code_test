import React, { useState, useEffect } from "react";
import { useLocation, Link } from "react-router-dom";
import axios from "axios";

export const BoardList = () => {

    // 현재 페이지 유지 처리
    const query = new URLSearchParams(useLocation().search);
    const page1 = query.get("page");
    const pageNum = page1 ? parseInt(page1, 10) : 1;

    const [boardlist, setBoardlist] = useState([]);   // 글 목록
    const [page, setPage] = useState(pageNum);        // 현재 페이지
    const [listcount, setListcount] = useState(0);    // 전체 글 수
    const [pagecount, setPagecount] = useState(1);    // 전체 페이지 수
    const [startpage, setStartpage] = useState(1);    // 블록 시작
    const [endpage, setEndpage] = useState(1);        // 블록 끝
    const limit = 10;                                 // 한 페이지 글 수

    // 페이지 번호가 변경될 때마다 데이터 다시 로드
    useEffect(() => {
        axios.get(`http://localhost:9999/boardlist?page=${page}`)
            .then((res) => {
                console.log("서버 응답:", res.data);

                // undefined 방지 처리
                setBoardlist(res.data.boardlist || []);
                setListcount(res.data.listcount || 0);
                setPagecount(res.data.pagecount || 1);
                setStartpage(res.data.startpage || 1);
                setEndpage(res.data.endpage || 1);
            })
            .catch((error) => {
                console.error("Error:", error);
                alert("데이터를 가져오는 중 오류가 발생했습니다.");
            });
    }, [page]);


    // 페이지 이동 함수
    const movePage = (pageNum) => {
        if (pageNum < 1 || pageNum > pagecount) return;
        setPage(pageNum);
    };


    return (
        <div style={{ textAlign: "center", padding: "20px" }}>
            <h2>글 목록</h2>

            <table
                border="1"
                cellPadding={5}
                cellSpacing={0}
                style={{ margin: "0 auto", width: "80%" }}
            >
                <thead>
                    <tr>
                        <th>번호</th>
                        <th>제목</th>
                        <th>작성자</th>
                        <th>등록일</th>
                    </tr>
                </thead>

                <tbody>
                    {Array.isArray(boardlist) && boardlist.length > 0 ? (
                        boardlist.map((board, index) => {
                            const displayNo = listcount - (page - 1) * limit - index;

                            return (
                                <tr key={board.no}>
                                    <td>{displayNo}</td>
                                    <td>
                                        <Link to={`/boardcontent/${board.no}?page=${page}`}>
                                            {board.title}
                                        </Link>
                                    </td>
                                    <td>{board.writer}</td>
                                    <td>{board.register}</td>
                                </tr>
                            );
                        })
                    ) : (
                        <tr>
                            <td colSpan={4} style={{ textAlign: "center" }}>
                                등록된 글이 없습니다.
                            </td>
                        </tr>
                    )}
                </tbody>
            </table>

            <br /><br />

            {/* ----- 페이징 ----- */}
            <div>
                {/* 처음 */}
                <button onClick={() => movePage(1)} disabled={page === 1}>
                    &laquo; 처음
                </button>

                {/* 이전 블럭 */}
                <button
                    onClick={() => movePage(startpage - 1)}
                    disabled={startpage === 1}
                >
                    &lt; 이전
                </button>

                {/* 페이지 번호 */}
                {Array.from({ length: endpage - startpage + 1 }, (_, i) => {
                    const p = startpage + i;
                    return (
                        <button
                            key={p}
                            onClick={() => movePage(p)}
                            style={{
                                margin: "0 5px",
                                fontWeight: p === page ? "bold" : "normal",
                                color: p === page ? "red" : "black",
                            }}
                        >
                            {p}
                        </button>
                    );
                })}

                {/* 다음 블럭 */}
                <button
                    onClick={() => movePage(endpage + 1)}
                    disabled={endpage >= pagecount}
                >
                    다음 &gt;
                </button>

                {/* 마지막 */}
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
