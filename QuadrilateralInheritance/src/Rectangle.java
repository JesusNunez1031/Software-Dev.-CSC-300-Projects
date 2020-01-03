
public class Rectangle extends Quadrilateral {

	
	public Rectangle(double a, double b, double c, double d, double e, double f, double g, double h) {
		super(a, b, c, d, e, f, g, h);
	}
	
	public double getArea(){
		double d1 = Math.sqrt(Math.pow((point1.getX()-point2.getX()),2) + Math.pow((point1.getY()-point2.getY()),2));
		double d2 = Math.sqrt(Math.pow((point1.getX()-point4.getX()),2) + Math.pow((point1.getY()-point4.getY()),2));
		
		return d1 * d2;
	}
	
	private double getHeight() {
		return Math.abs(point1.getY()-point3.getY());
	}

	private double getWidth() {
		return Math.abs(point1.getX()-point2.getX());
	}
	
	@Override
	public String toString() {
		return "Coordinates of Rectangle are " + point1.toString() + ", " + point2.toString() + ", "
				+ point3.toString() + ", " + point4.toString() + "\nWidth is: " + format.format(getWidth()) + " Height is: " + format.format(getHeight()) + " Area is: " + format.format(getArea()) + "\n";
	}

}
