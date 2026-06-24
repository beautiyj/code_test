package springboot_test.board1.src.main.java.com.example.demo.service;

/* 사용자 정의로 헬퍼 클래스를 만들어뒀는데 표준 라이브러리로도 존재함
 
도구             		   출처                             특징
-------------------|-------------------------------|------------------------------------------
PagingPgm      	      이 프로젝트가 직접 만든 클래스    	     MyBatis + JSP 조합에서 흔히 쓰는, 직접 만든 페이징 계산기
Pageable, Page<T>     Spring Data JPA 표준            JPA를 쓸 때 자동으로 페이징 처리해주는 인터페이스
PageHelper     		  MyBatis 생태계의 서드파티 라이브러리   SQL에 LIMIT/OFFSET을 자동으로 끼워주는 도구* 도구출처특징PagingPgm이 프로젝트가 직접 만든 클래스MyBatis + JSP 조합에서 흔히 쓰는, 직접 만든 페이징 계산기Pageable, Page<T>Spring Data JPA 표준JPA를 쓸 때 자동으로 페이징 처리해주는 인터페이스PageHelper (오픈소스 라이브러리)MyBatis 생태계의 서드파티 라이브러리SQL에 LIMIT/OFFSET을 자동으로 끼워주는 도구
 
 * */

public class PagingPgm {
	private int total;				// 데이터 갯수
	private int rowPerPage;			// 화면에 출력할 데이터 갯수
	private int pagePerBlk = 10;    // 블럭당 페이지 갯수 (1개의 블럭당 10개의 페이지)
	private int currentPage;		// 현재 페이지 번호
	private int startPage;			// 각 블럭의 시작 페이지
	private int endPage;            // 각 블럭의 끝 페이지
	private int totalPage;			// 총 페이지 수

	public PagingPgm(int total, int rowPerPage, int currentPage) {
		this.total = total;
		this.rowPerPage = rowPerPage;
		this.currentPage = currentPage;
		
		totalPage = (int) Math.ceil((double) total / rowPerPage);
		startPage = currentPage - (currentPage - 1) % pagePerBlk;	// 1,  11, 21...
		endPage = startPage + pagePerBlk - 1;						// 10, 20, 30...
		
		if (endPage > totalPage)
			endPage = totalPage;
	}

	public int getTotal() {
		return total;
	}

	public void setTotal(int total) {
		this.total = total;
	}

	public int getRowPerPage() {
		return rowPerPage;
	}

	public void setRowPerPage(int rowPerPage) {
		this.rowPerPage = rowPerPage;
	}

	public int getPagePerBlk() {
		return pagePerBlk;
	}

	public void setPagePerBlk(int pagePerBlk) {
		this.pagePerBlk = pagePerBlk;
	}

	public int getCurrentPage() {
		return currentPage;
	}

	public void setCurrentPage(int currentPage) {
		this.currentPage = currentPage;
	}

	public int getStartPage() {
		return startPage;
	}

	public void setStartPage(int startPage) {
		this.startPage = startPage;
	}

	public int getEndPage() {
		return endPage;
	}

	public void setEndPage(int endPage) {
		this.endPage = endPage;
	}

	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
}