# 파이썬은 오버로딩이 안 되므로, 하나의 함수에서 타입을 체크하거나 가변 인자를 씁니다.

def check(a=None, d=None):
    if a is None and d is None:
        print("메소드 호출 성공\n")
    elif d is not None:
        result = a + d
        print(result)
        print()
    else:
        print(a)
        print()

def check1():
    print("return\n")
    return 50

def check2(a, d):
    result = a + d
    print()
    return result

def main():
    check()

    # 값 전달 호출 (파이썬은 타입이 자유로워서 하나의 check로 다 돌어감)
    check(30)
    check(10, 20.5)
    check('A')
    check(True)
    check("java")
    check("python")

    # 리턴값 처리
    check1() # 화면엔 return만 찍힘
    result = check1()
    print(result) # 50 출력

    result2 = check2(50, 3.14)
    print(result2) # 53.14 출력

if __name__ == "__main__":
    main()



    """
    파이썬 형태로 진행할 경우
    
    def check(data=None, second_data=None):
        if data is None:
            print("메소드 호출 성공")
        elif second_data is not None:
            print(data + second_data)
        else:
            print(data)
        print()
    
    def get_result(a=None, b=None):
        if b is not None:
            print(f"계산 중... (입력: {a}, {b})")
            return a + b
        else:
            print("기본값 리턴 중...")
            return 50
    
    if __name__ == "__main__":
        check()
        check(30)
        check(10, 20.5)
        check("java")
    
        res1 = get_result() 
        print(f"결과값 1: {res1}\n") # 50 출력
    
        res2 = get_result(50, 3.14)
        print(f"결과값 2: {res2}")   # 53.14 출력
    
    """