-- hr 활성화 및 비번 설정

/*
hr 계정 활성화하는 방법은
콘솔이나 sql에서
1. conn system/____(관리자계정 사용자 정의 비번) 관리자 계정으로 로그인 (혹은 현재 여기, 디벨로퍼에서 sys계정 이동도 가능)
2. alter user hr account unlock;        계정 활성화
3. alter user hr identified by ____(비번 적으면 됨);    비번 사용자 정의로 설정
4. conn hr/____(사용자 정의 비번) 으로 로그인 
*/