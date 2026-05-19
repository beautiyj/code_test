let isIdChecked = false; // 중복검사 확인 후 회원가입 가능하도록 변수 설정
// 2. 아이디 중복검사 넣기(jsp없어서 코드만 작성해보기)
function idCheck() {
  let id = document.getElementById("id");
  if (id.value == "") {
    alert("아이디를 입력하세요");
    id.focus();
    return false;
  }
  // 빈칸 아니면 바로 팝업
  let ref = "idCheck.jsp?ip=" + id.value;
  window.open(ref, "idCheck", "width=300, height=200");

  isIdChecked = true; // 전역변수 변경
}

// 3. 자릿수 채워지면 자동으로 다음 칸 넘어가기 - 재사용가능한 코드
function autoTab(current, next) {
  if (current.value.length == current.maxLength) {
    next.focus();
  }
}
/* 이렇게 하고 키업 적용도 가능하나 재사용성을 위해 오토랩()으로 적용함.
function move() {
  let rrn1 = document.getElementById("rrn1");
  let rrn2 = document.getElementById("rrn2");
  if (rrn1.value.length == 6) {
      rrn2.focus()
  }
}
*/

// 4. 도메인 채우기
function domain1() {
  let domain1 = document.getElementById("domain");
  let email = document.getElementById("email");

  if (email.value == "") {
    // 직접입력
    domain1.value = "";
    domain1.focus();
    domain1.readOnly = false;
    return false;
  } else {
    // 도메인선택
    domain1.value = email.value;
    domain1.readOnly = true; // 읽기 전용 설정
  }
}

// 5. 유효성 검사
function check() {
  let id = document.getElementById("id");
  let password = document.getElementById("password");
  let name = document.getElementById("name");
  let rrn1 = document.getElementById("rrn1");
  let rrn2 = document.getElementById("rrn2");
  let mailid = document.getElementById("mailid");
  let domain = document.getElementById("domain");
  let phone1 = document.getElementById("phone1");
  let phone2 = document.getElementById("phone2");
  let phone3 = document.getElementById("phone3");
  let address = document.getElementById("address");
  // radio, checkbox 라디오 체크박스 타입 유효성검사는 querySelector(':checked') == null로!
  // id가 여러개라 getElementById 못씀. name="gender" 로 묶여있으니까 name으로 찾는 것
  let genderChecked = document.querySelector('input[name="gender"]:checked');
  // 취미는 여러 개 체크하는 걸로 설정할 거라 querySelectorAll로 지정
  let hobbyChecked = document.querySelectorAll('input[name="hobby"]:checked');
  let content = document.getElementById("content");

  if (id.value == "") {
    alert("아이디를 입력하세요");
    id.focus();
    return false;
  }
  if (!isIdChecked) {
    alert("아이디 중복검사를 해주세요");
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

  if (phone1.value == "") {
    alert("휴대폰 앞자리를 선택하세요");
    phone1.focus();
    return false;
  }
  if (phone2.value == "") {
    alert("휴대폰 번호를 입력하세요");
    phone2.focus();
    return false;
  }
  /* JS isNaN으로 숫자만 넣기 처리는 가능한데, 이것보단 HTML 정규식인 pattern 속성 위주로 사용함.
    [0-9]    → 0~9 숫자 한 글자
    [0-9]*   → 숫자 0개 이상
    [0-9]{4} → 숫자 딱 4자리
    [a-z]    → 소문자 영문

    숫자만 4자리
    <input type="text" pattern="[0-9]{4}" title="숫자 4자리만 입력" />
    숫자만 (자릿수 상관없이)
    <input type="text" pattern="[0-9]*" title="숫자만 입력" />

  if (isNaN(phone2.value)) {
    alert("휴대폰 번호는 숫자만 입력하세요");
    phone2.value = "";
    phone2.focus();
    return false;
  }
  */

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

  if (genderChecked == null) {
    alert("성별을 선택하세요");
    return false;
  }

  if (hobbyChecked.length == 0) {
    alert("취미를 선택하세요");
    return false;
  }
  if (hobbyChecked.length < 2) {
    alert("취미를 2개 이상 선택하세요");
    return false;
  }

  // 취미를 2개 이상 선택하도록 설정하기
  // let hobbyCount = 0;
  // if (hobby1.checked) count++
  // if (hobby2.checked) count++
  // if (hobby3.checked) count++
  // if (hobby4.checked) count++
  // if (hobby5.checked) count++

  // if (hobbyCount <2) {
  //   alert("취미 2개 이상 선택");
  //   return false;
  // }

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