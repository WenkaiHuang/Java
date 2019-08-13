
/**
 *
 * @author Wenkai Huang
 */
public class Rectangle extends Shape
{
    private final double width;
    private final double height;

    public Rectangle(double width, double height)
    {
        this.width = width;
        this.height = height;
    }
    
    
    @Override
    public double perimeter()
    {
        return 2*(width+height);
    }

    @Override
    public double area()
    {
        return width*height;
    }

    @Override
    public String toString()
    {
        return "Rectangle("+ width+","+height+")";
    }
    
}
