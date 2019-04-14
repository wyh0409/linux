

public class Date2 {
	int year,month,day;
	public void setdate(int y,int m,int d) {
		year=y;
		month=m;
		day=d;
	}
	void today() {
		System.out.println("The date of today is "+year+"/"+month+"/"+day);
	}
	boolean isleap(int y) {
		return (y%4==0&&y%100!=0)||y%400==0;
	}
	void tomorrow() {
		int d,m,y;
		d=day+1;
		m=month;
		y=year;
		if ((d>28)&&month==2) {
			if(!isleap(year)||d>29) {
				d=1;m=m+1;
			}
			else if (d>30&&(month<7&&month%2==0||month>7&&month%2==1)) {
				d=1;m=m+1;
			}
			else if (d>31) {
				d=1;m=m+1;
				if (m==13) {
					y=y+1;m=1;
				}
			}
			System.out.println("The date of today is "+y+"/"+m+"/"+d);
		}
	}
	public static void main(String args[]) {
		Date2 de=new Date2();
		de.setdate(2000, 2, 29);
		if (de.isleap(de.year)) {
			System.out.println(de.year+"is a leap year");
			de.today();
			de.tomorrow();
		}
	}
}
