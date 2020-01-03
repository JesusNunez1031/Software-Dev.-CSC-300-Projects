
public class Trapezoid extends Quadrilateral {
	private double height;
	
	public Trapezoid(double a, double b, double c, double d, double e, double f, double g, double h) {
		super(a, b, c, d, e, f, g, h);
		this.height = getHeight();
		
	}
	
	public double getArea(){
		double d1 = Math.sqrt(Math.pow((point1.getX()-point2.getX()),2) + Math.pow((point1.getY()-point2.getY()),2));
		double d2 = Math.sqrt(Math.pow((point3.getX()-point4.getX()),2) + Math.pow((point3.getY()-point4.getY()),2));
		
		return ((d1 + d2) * height)/2;
	}
	
	public double getHeight(){
		return Math.abs(point1.getY()-point3.getY());
	}
	
	@Override
	public String toString() {
		return "Coordinates of trapezoid are " + point1.toString() + ", " + point2.toString() + ", "
				+ point3.toString() + ", " + point4.toString() + "\nHeight is: " + format.format(this.height) + " Area is: " + format.format(getArea()) + "\n";
	}

}
