function check() {
            let id = document.getElementById("id");
            if (id.value == "") {
                alert("아이디를 입력하세요");
                id.focus();
                return false;
            }
            let passwd = document.getElementById("passwd");
            if (passwd.value == "") {
                alert("비밀번호를 입력하세요");
                passwd.focus();
                return false;
            }
            return true;
        }