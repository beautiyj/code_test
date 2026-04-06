import tkinter as tk

# AWT(Abstract Window Toolkit) 예제
# -> 파이썬은 표준 GUI 라이브러리인 tkinter 라이브러리 활용

# 버튼을 클릭하면 창의 배경색이 바뀌는 간단한 이벤트 처리 프로그램
# RED 버튼을 누르면 창이 빨개지고 BLUE 버튼을 누르면 파래지는 GUI(그래픽 사용자 인터페이스) 예제

class ColorEvent:
    def __init__(self):
        # f = Frame("Event Test") 대응
        self.root = tk.Tk()
        self.root.title("Event Test")
        self.root.geometry("300x200") # f.setSize(300, 200) 대응

        # [포인트1] 창 닫기 버튼(X) 클릭 시 프로세스 종료 설정
        self.root.protocol("WM_DELETE_WINDOW", self.root.quit)

        # redBtn = Button("RED") 대응
        # 파이썬은 command 파라미터에 실행할 함수를 직접 연결함
        self.red_btn = tk.Button(self.root, text="RED", command=self.handle_red)
        self.blue_btn = tk.Button(self.root, text="BLUE", command=self.handle_blue)

        # f.setLayout(new FlowLayout()) 대응 (파이썬의 pack은 순서대로 배치함)
        # [포인트2] 컴포넌트를 물 흐르듯 배치
        self.red_btn.pack(side="left", padx=20)
        self.blue_btn.pack(side="right", padx=20)

        # [포인트3] 파이썬은 mainloop()를 실행해야 화면에 보임
        self.root.mainloop()

    # actionPerformed(ActionEvent e) 역할을 하는 메소드들
    def handle_red(self):
        # [포인트4] 클릭된 이벤트를 함수 매핑으로 처리 (자바의 getSource()와 결과적으로 같음)
        self.root.configure(bg='red')

    def handle_blue(self):
        self.root.configure(bg='blue')

if __name__ == "__main__":
    ColorEvent()