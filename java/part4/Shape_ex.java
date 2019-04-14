public class Shape_ex
{
    public static void main(String args[])
    {
        Rectangle rc = new Rectangle(6,12);
        System.out.println("The area of Rectangle: "+rc.area());
    }
}

abstract class Shape454
{
    abstract protected double area();
    abstract protected void girth();
}

class Rectangle extends Shape454
{
    float width, length;
    Rectangle(float w, float i)
    {
        width = w;
        length = i;
    }
    public double area()
    {
        return width*length;
    }
    public void girth(){};
}
