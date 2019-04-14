class Person1{
	protected String name;
	protected int age;
	public Person1(String na,int ag) {
		name=na;age=ag;
	}
	public void print() {
		System.out.println("the object of person:"+name+","+age);
	}
}
class Student1 extends Person1{
	String address;
	String department;
	public Student1(String na,int ag,String ad,String de) {
		super(na, ag);
		address=ad;
		department = de;
	}
	public void print() {
		System.out.println("the object of student:"+name+","+age+","+address+","+department);
	}
}
public class Student1_ex {
	public static void main(String args[]) {
		Person1 pe=new Person1("Tom", 20);
		Student1 st=new Student1("John", 19,"336 west street", "computer");
		pe.print();
		st.print();
	}
}
