package java_ex_test;

public class GuGuDan2 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub

		for(int i=0; i<=9; i++){			
			for(int j=2; j<=9;j++){	// 각 단 출력  
				if(i==0) {
					System.out.print("[" + j + "단]" + "\t");
				}else {
					System.out.print(j + "*" + i + "=" + (j*i) + "\t");
				}
			}
			System.out.println();			
		}
		
	}
}
