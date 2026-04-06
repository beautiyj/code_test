# task/python2/python_task_54.py

class PythonTask54:
    def __init__(self):
        self.__a = 10    # [1] Private (Name Mangling)
        self.b = 20      # [2] Public (자바의 default 대응이 없으므로 Public 취급)
        self._c = 30     # [3] Protected (관례상 '_' 하나)
        self.d = 40      # [4] Public

    def print_all(self):
        print("AccessTest의 print")
        print(self.__a)
        print(self.b)
        print(self._c)
        print(self.d)