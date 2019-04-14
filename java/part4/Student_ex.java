import javafx.beans.property.SetProperty;

class Person{
	protected String name;
	protected int age;
	protected String address;
	public void setPerson(String na,int ag,String ad) {
		name=na;age=ag;address=ad;
	}

}
class Student extends Person{
	String address;
	String department;
	public void setStudent(String na,int ag,String ad,String ad1,String de) {
		setPerson(na, ag,ad);
		address=ad1;
		department = de;
	}
}
public class Student_ex {
	public static void main(String args[]) {
		Person pe=new Person();
		Student st=new Student();
		pe.setPerson("Tom", 20,"121 north street");
		st.setStudent("John", 19, "234 south street", "336 west street", "Computer");
		System.out.println("the object of person:"+pe.name+","+pe.age+","+pe.address);
		System.out.println("the object of student:"+st.name+","+st.age+","+st.address+","+st.department);
	}
}
