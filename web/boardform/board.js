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