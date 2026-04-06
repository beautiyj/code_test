import tkinter as tk

# 파이썬은 표준 라이브러리인 tkinter를 사용하여 GUI를 구현
# 자바의 Frame 역할은 Tk 또는 Toplevel 객체가 수행

class FrameTest:
    def __init__(self):
        # 클래스 내부에서 다른 객체를 직접 생성해서 보관.(인스턴스화) Has-a(포함)방식.
        # 실행부에서는 ft = FrameTest() 만 하면 된다.
        # 왜냐! 객체의 생성과 초기화(화면 출력)가 캡슐화되어있어서
        self.f = tk.Tk()
        self.f.title("Frame Test")
        self.f.geometry("400x300+100+100") # 사이즈와 위치 설정
        self.f.configure(bg='green')
        self.f.resizable(False, False)

        # 윈도우 종료 이벤트 처리 (WindowListener 대응)
        self.f.protocol("WM_DELETE_WINDOW", self.f.destroy)

class FrameTestEx(tk.Toplevel): # tk.Toplevel을 상속받음 (Is-a 상속)
    def __init__(self):
        # super("Frame Test") 부모 클래스의 생성자 호출 대응
        super().__init__()
        self.title("Frame Test")

        self.protocol("WM_DELETE_WINDOW", self.destroy)
        self.geometry("400x300+150+150") # 겹치지 않게 위치 살짝 조정
        self.configure(bg='green')

if __name__ == "__main__":
    # 포함 방식 실행
    ft = FrameTest()

    # 상속 방식 실행 (Tk 메인 창이 있어야 하므로 순서 주의)
    ftex = FrameTestEx()

    # GUI 유지
    tk.mainloop()