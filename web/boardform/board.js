function check() {
    let writer = document.getElementById("writer");
    let password = document.getElementById("password");
    let title = document.getElementById("title");
    let content = document.getElementById("content");
    let myfile = document.getElementById("myfile");

    if (writer.value == "") {
      alert("작성자명 입력");
      writer.focus();
      return false;
    }
    if (password.value == "") {
      alert("비번 입력");
      password.focus();
      return false;
    }
    if (password .value.length < 2 || password .value.length > 8) {
      alert("비밀번호는 2~8자 이내로 입력");
      password .value = "";
      password .focus();
      return false;
    }
    if (title.value == "") {
      alert("제목 입력");
      title.focus();
      return false;
    }
    if (title.value.length > 50) {
      alert("제목을 50자 이내로 입력");
      title.value = ""; // 입력된 제목 삭제
      title.focus();
      return false;
    }
    if (content.value == "") {
        alert("내용 입력");
        content.focus();
        return false;
    }
    if (content.value.length > 200) {
        alert("내용을 200자 이내로 입력");
        content.focus();
        return false;
    }
    if (myfile.value == "") {
      alert("첨부파일 선택");
      myfile.focus();
      return false;
    }
    return true;
  }

/* 제이쿼리 방식
$(document).ready(function(){
    $("form").submit(function(){
        if($.trim($("#writer").val()) == ""){
            alert("작성자명을 입력 하세요.");
            $("#writer").focus();
            return false;
        }

        if($("#passwd").val() == ""){
            alert("비밀번호를 입력 하세요.");
            $("#passwd").focus();
            return false;
        }
        if($("#passwd").val().length < 2 ||
                $("#passwd").val().length > 8 ){
            alert("비밀번호는 2~8자 이내로 입력 하세요.");
            $("#passwd").val("").focus();
            return false;
        }

        if($("#subject").val() == ""){
            alert("제목을 입력 하세요.");
            $("#subject").focus();
            return false;
        }
        if($("#subject").val().length > 50){
            alert("제목을 50자 이내로 입력 하세요.");
            $("#subject").val("").focus();
            return false;
        }

        if($("#content").val() == ""){
            alert("내용을 입력 하세요.");
            $("#content").focus();
            return false;
        }
        if($("#content").val().length > 200){
            alert("내용을 200자 이내로 입력 하세요.");
            $("#content").focus();
            return false;
        }

        if($("#myfile").val() == ""){
            alert("첨부파일을 선택하세요.");
            return false;
        }

    }); // submit() end
});
*/