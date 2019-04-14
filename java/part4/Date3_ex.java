class Date3{
	private int year,month,day;
	public void setdate(int y,int m,int d) {
		year=y;
		month=m;
		day=d;
	}
	void today() {
		System.out.println("the date of today is "+year+"/"+month+"/"+day);
		
	}
	int getyear(){
		return year;
	}
	boolean isleap(int y) {
		return (y%4==0&&y%100!=0)||(y%400==0);
		}
}
public class Date3_ex{
	public static void main(String args[]) {
		Date3 de =new Date3();
		int year;
		de.setdate(2000,2,29);
		year=de.getyear();
		if (de.isleap(year)) {
			System.out.println(year+"is a leap year");
		}	
		de.today();
		}
	}
