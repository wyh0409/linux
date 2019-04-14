class Melon {
	float weight;
	private static float total_weight=0;
	private static int total_number=0;
	public Melon(float w) {
		weight = w;
		total_number=total_number+1;
		total_weight=total_weight+weight;
	}
	public void reduce() {
		total_number=total_number-1;
		total_weight=total_weight-weight;
	}
	public static float get_total_weight() {
		return total_weight;
	}
	public static int get_total_number() {
		return total_number;
	}
}
public class Melon1_ex{
	public static void main(String args[]) {
		Melon m1,m2;
		float t_weight;
		int t_number;
		m1=new Melon(10);
		m2=new Melon(12);
		t_weight=Melon.get_total_weight();
		t_number=Melon.get_total_number();
		System.out.println("Total weight:"+t_weight);
		System.out.println("Total number:"+t_number);
		m1.reduce();
		t_weight=Melon.get_total_weight();
		t_number=Melon.get_total_number();
		System.out.println("Total weight:"+t_weight);
		System.out.println("Total number:"+t_number);
	}
}