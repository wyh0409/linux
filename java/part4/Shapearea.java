public class Shapearea
{
    public double area(float r)
    {
        return Math.PI*r*r;
    }
    public double area(float a, float b)
    {
        return a*b;
    }
    public double area(float a, float b,float c)
    {
        float d;
        d = (a+b+c)/2;
        return Math.sqrt(d*(d-a)*(d-b)*(d-c));
    }

    public static void main(String args[])
    {
        Shapearea sh = new Shapearea();

        System.out.println("The area of circle: "+sh.area(3));
        System.out.println("The area of rectangle: "+sh.area(7,4));
        System.out.println("The area of triangle: "+sh.area(3,4,5));
    }
}
