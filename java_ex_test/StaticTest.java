package java_ex_test;

import java.text.DecimalFormat;

class StaticTest {
  public static void main(String[] args)  {

    int r=5;
	double l;      //원주(원둘레)
    double s;      //원의 면적
	double s2;     //구의 표면적
	double v;      //구의 체적(부피)

	l=2*r*Math.PI;
    s=r*r*Math.PI;
	s2=4*Math.PI*r*r;
	v=(double)4/3*Math.PI*r*r*r;	// pow(r,3)

	DecimalFormat df = new DecimalFormat("##.00");
		
	System.out.println("원주 : " + l);
    System.out.println("반지름이 "+r+"인 원의 면적 "+ s);
	System.out.println("구의 표면적 : " + s2);
	System.out.println("구의 체적 :" + v);	
	System.out.println();
	
	System.out.println("원주 : " + df.format(l));
    System.out.println("반지름이 "+r+"인 원의 면적 "+ df.format(s));
	System.out.println("구의 표면적 : " + df.format(s2));
	System.out.println("구의 체적 :" + df.format(v));
	System.out.println();
	
//	System.out.printf("%f", l);
	System.out.printf("%.2f\n", l);
	System.out.format("%.2f\n", s);
	System.out.format("%.2f\n", s2);
	System.out.format("%.2f\n", v);
  }
}