function check() {
    let id = document.getElementById("id");
    let password = document.getElementById("password");
    let name = document.getElementById("name");
    let rrn1 = document.getElementById("rrn1");
    let rrn2 = document.getElementById("rrn2");
    let mailid = document.getElementById("mailid");
    let domain = document.getElementById("domain");
    let phone2 = document.getElementById("phone2");
    let phone3 = document.getElementById("phone3");
    let address = document.getElementById("address");
    let content = document.getElementById("content");

    if (id.value == "") {
        alert("아이디를 입력하세요");
        id.focus();
        return false;
    }

    if (password.value == "") {
        alert("비밀번호를 입력하세요");
        password.focus();
        return false;
    }
    if (password.value.length < 2 || password.value.length > 8) {
        alert("비밀번호는 2~8자 이내로 입력하세요");
        password.value = "";
        password.focus();
        return false;
    }

    if (name.value == "") {
        alert("성명을 입력하세요");
        name.focus();
        return false;
    }

    if (rrn1.value == "") {
        alert("주민번호 앞자리를 입력하세요");
        rrn1.focus();
        return false;
    }
    if (rrn2.value == "") {
        alert("주민번호 뒷자리를 입력하세요");
        rrn2.focus();
        return false;
    }

    if (mailid.value == "") {
        alert("이메일 아이디를 입력하세요");
        mailid.focus();
        return false;
    }
    if (domain.value == "") {
        alert("이메일 도메인을 입력하세요");
        domain.focus();
        return false;
    }

    if (phone2.value == "") {
        alert("휴대폰 번호를 입력하세요");
        phone2.focus();
        return false;
    }
    if (phone3.value == "") {
        alert("휴대폰 번호를 입력하세요");
        phone3.focus();
        return false;
    }

    if (address.value == "") {
        alert("주소를 입력하세요");
        address.focus();
        return false;
    }

    if (content.value == "") {
        alert("자기소개를 입력하세요");
        content.focus();
        return false;
    }
    if (content.value.length > 100) {
        alert("자기소개는 100자 이내로 입력하세요");
        content.focus();
        return false;
    }

    return true;
}