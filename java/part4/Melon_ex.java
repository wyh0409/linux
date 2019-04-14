class Melon {
	float weight;
	static float total_weight=0;
	static int total_number=0;
	public Melon(float w) {
		weight = w;
		total_number=total_number+1;
		total_weight=total_weight+weight;
	}
	public void reduce() {
		total_number=total_number-1;
		total_weight=total_weight-weight;
	}
}
public class Melon_ex{
	public static void main(String args[]) {
		Melon m1,m2;
		m1=new Melon(10);
		m2=new Melon(12);
		System.out.println("Total weight:"+Melon.total_weight);
		System.out.println("Total number:"+Melon.total_number);
		m1.reduce();
		System.out.println("Total weight:"+Melon.total_weight);
		System.out.println("Total number:"+Melon.total_number);
		m2.reduce();
		System.out.println("Total weight:"+Melon.total_weight);
		System.out.println("Total number:"+Melon.total_number);
	}
}