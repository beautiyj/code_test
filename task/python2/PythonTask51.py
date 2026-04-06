# 상속에서의 메소드
# 1. 부모 클래스의 메소드는 자식 클래스로 상속된다.
# 2. 부모 클래스에서 자식 클래스의 메소드는 접근 할 수 없다.

# 파이썬 기준 클래스 선언 시 괄호 안에 부모 클래스 이름을 넣어 상속을 구현

class Parent51:                   # 부모 클래스
    def parent_prn(self):
        print("슈퍼 클래스 메서드는 상속된다.")

class Child51(Parent51):          # 자식 클래스 (Parent51 상속)
    def child_prn(self):
        print("서브 클래스 메서드는 슈퍼가 사용 못한다.")

def main():
    c = Child51()
    c.parent_prn()      # 상속 받은 메소드 사용
    c.child_prn()       # 자식 클래스의 메소드 사용

    print("-------------------------------------->> ")
    p = Parent51()
    p.parent_prn()     # 자기 클래스(부모 클래스)의 메소드 사용
    # p.child_prn()    # [AttributeError] 자식 클래스의 메소드는 접근 할 수 없다.

if __name__ == "__main__":
    main()