
public class Square extends Quadrilateral {
	
	public Square(double a, double b, double c, double d, double e, double f, double g, double h) {
		super(a, b, c, d, e, f, g, h);
	}
	
	public double getArea() {
		return  Math.pow(Math.sqrt(Math.pow((point1.getX()-point2.getX()),2) + Math.pow((point1.getY()-point2.getY()),2)),2);
	}
	
	public double side() {
		return Math.abs(point1.getX() - point2.getX());
	}
	
	@Override
	public String toString() {
		return "Coordinates of Square are " + point1.toString() + ", " + point2.toString() + ", "
				+ point3.toString() + ", " + point4.toString() + "\nSide is: " + format.format(side()) + " Area is: " + format.format(getArea());
	}
}
