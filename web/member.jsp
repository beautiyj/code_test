<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%
    // 1. 한글 설정 (POST 방식 데이터 수신 시 필수)
    request.setCharacterEncoding("UTF-8");

    // 2. 단일 항목 데이터 가져오기
    String id = request.getParameter("id");
    String password = request.getParameter("password");
    String name = request.getParameter("name");

    // 이메일 조합
    String mailId = request.getParameter("mailid");
    String domain = request.getParameter("domain");
    String fullEmail = (mailId != null && domain != null) ? mailId + "@" + domain : "입력 없음";

    // 전화번호 및 휴대폰 조합
    String phone = request.getParameter("phone1") + "-" + request.getParameter("phone2") + "-" + request.getParameter("phone3");

    // 주소 및 성별
    String address = request.getParameter("address");
    String gender = request.getParameter("gender");

    // 3. 다중 선택 항목 (Checkbox) 처리
    // name="hobby"인 모든 값을 배열로 가져옵니다.
    String[] hobbies = request.getParameterValues("hobby");
    String hobbyList = (hobbies != null) ? String.join(", ", hobbies) : "취미 없음";

    // 4. 자기소개 (textarea 줄바꿈 처리)
    String content = request.getParameter("content");
    String formattedContent = (content != null) ? content.replace("\n", "<br>") : "";

    // 5. 이미지 버튼 좌표 수신 (name="submitBtn"인 경우)
    // 클릭한 지점의 X, Y 좌표가 자동으로 .x, .y로 붙어서 넘어옵니다.
    String imgX = request.getParameter("submitBtn.x");
    String imgY = request.getParameter("submitBtn.y");
    String submitType = (imgX != null) ? "이미지 버튼 (좌표: " + imgX + ", " + imgY + ")" : "일반 전송 버튼";
%>

<!DOCTYPE html>
<html lang="ko">
<head>
    <meta charset="UTF-8">
    <title>회원가입 결과 확인</title>
    <style>
        body { font-family: sans-serif; line-height: 1.6; padding: 20px; }
        table { border-collapse: collapse; width: 500px; margin-top: 20px; }
        th, td { border: 1px solid #ccc; padding: 10px; text-align: left; }
        th { background-color: #f9f9f9; width: 150px; }
        .highlight { color: blue; font-weight: bold; }
    </style>
</head>
<body>
    <h2>회원가입 정보 수신 결과</h2>
    <p>전송 방식: <span class="highlight"><%= submitType %></span></p>

    <table>
        <tr>
            <th>아이디</th>
            <td><%= id %></td>
        </tr>
        <tr>
            <th>비밀번호</th>
            <td><%= password %></td>
        </tr>
        <tr>
            <th>성명</th>
            <td><%= name %></td>
        </tr>
        <tr>
            <th>이메일</th>
            <td><%= fullEmail %></td>
        </tr>
        <tr>
            <th>휴대폰</th>
            <td><%= phone %></td>
        </tr>
        <tr>
            <th>성별</th>
            <td><%= gender %></td>
        </tr>
        <tr>
            <th>취미</th>
            <td><%= hobbyList %></td>
        </tr>
        <tr>
            <th>자기소개</th>
            <td><%= formattedContent %></td>
        </tr>
    </table>

    <br>
    <a href="javascript:history.back()">뒤로 가기</a>
</body>
</html>