# task/python2/t54/t54.py
import os
import sys

from task.python2.PythonTask54 import PythonTask54

# 상위 디렉토리를 path에 추가하여 import 가능하게 설정
sys.path.append(os.path.dirname(os.path.abspath(os.path.dirname(__file__))))

# 자식 클래스
class SubOne(PythonTask54):
    def sub_prn(self):
        # print(self.__a) # [1. Sub] 에러: private 접근 불가
        print(self.b)     # [2. Sub] 가능
        print(self._c)    # [3. Sub] 가능: 상속 관계이므로 관례상 허용
        print(self.d)     # [4. Sub] 가능

# 실행부 (T54)
def main():
    at = PythonTask54()
    at.print_all()

    print("main")
    # print(at.__a)   # [1. main] 에러
    print(at.b)       # [2. main] 가능
    # print(at._c)    # [3. main] 관례상 외부 접근 자제 (에러는 안 나지만 금기)
    print(at.d)       # [4. main] 가능

    print("--- SubOne 객체 실행 ---")
    so = SubOne()
    so.sub_prn()

if __name__ == "__main__":
    main()