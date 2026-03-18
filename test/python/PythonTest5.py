"""
문자열 my_string과 정수 k가 주어질 때,
my_string을 k번 반복한 문자열을 return 하는 함수를 작성

입출력 예시
my_string	k	    result
-------------------------------
"string"	3	   "stringstringstring"
"love"  	10	   "lovelovelovelove... 아무튼10번"
"""

def test5(my_string, k):
    result = ""
    for i in range(k):
        result += my_string
    return my_string

print(test5("string", 3))