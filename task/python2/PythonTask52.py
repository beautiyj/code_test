# 메소드 오버라이딩(Method Overriding)
# : 부모 클래스로부터 상속받은 메소드를 자식 클래스에서 재정의 해서 사용하는 것.

class Parent05:
    def parent_prn(self):
        print("슈퍼클래싀 parent_prn 메소드")

class Child05(Parent05):
    def parent_prn(self):
        # 부모 클래스의 은닉 메소드를 자식 클래스에서 사용할 때 super() 호출
        super().parent_prn()
        print("서브클래스: parent_prn 메소드")

    def child_prn(self):
        # super().child_prn() # [AttributeError] 부모에게 없는 속성
        print("서브클래스: child_prn 메소드")

class Parent52:
    def parent_prn(self):
        print("부모 클래스 : ParentPrn 메서드")

class Child52(Parent52):
    def parent_prn(self): # 메서드 오버라이딩
        print("자식 클래스 : ParentPrn 메서드")

    def child_prn(self):
        print("자식 클래스 : ChildPrn 메서드")

def main():
    c = Child52()
    c.parent_prn()  # 재정의된 자식 클래스의 메서드 호출
    c.child_prn()

    p = Parent52()
    p.parent_prn()  # 부모 클래스 자기 자신의 메서드 호출

    print("-" * 64)

    print("--- 자식 객체(Child05) 생성 및 호출 ---")
    cc = Child05()

    # 오버라이딩된 메소드 호출
    cc.parent_prn()
    # 자식만의 새로운 메소드 호출
    cc.child_prn()

    print("\n--- 부모 객체(Parent05) 생성 및 호출 ---")
    pp = Parent05()
    # 부모는 오직 자신의 원본 로직만 수행함
    pp.parent_prn()

if __name__ == "__main__":
    main()