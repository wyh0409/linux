public class Shapeccd_ex
{
    public static void main(String args[])
    {
        Circle c1 = new Circle(3);
        Cylinder cd = new Cylinder(2,5);
        System.out.println(c1.area());
        System.out.println(cd.area());
        c1 = cd;
        System.out.println(c1.area());
    }
}
abstract class Shape
{
    abstract protected double area();
}
class Circle extends Shape
{
    float r;
    public Circle(float a)
    {
        r = a;
    }
    
    public double area()
    {
        System.out.print("Calculate the area of cylinder:  ");
        return Math.PI*r*r;
    }
}
class Cylinder extends Circle
{
    float h;
    public Cylinder(float a, float b)
    {
        super(a);
        h = b;
    }
    public double area()
    {
        System.out.print("Calculate the area of Cylinder:  ");
        return 2*Math.PI*r*r+2*Math.PI*r*h;
    }
}
    
