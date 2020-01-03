
public class Parallelogram extends Quadrilateral {

	private double height;
	
	public Parallelogram(double a, double b, double c, double d, double e, double f, double g, double h) {
		super(a, b, c, d, e, f, g, h);
		this.height = getHeight();
	}
	
	public double getArea(){
		return Math.sqrt(Math.pow((point1.getX()-point2.getX()),2) + Math.pow((point1.getY()-point2.getY()),2)) * height;
	}
	
	private double getHeight() {
		return Math.abs(point1.getY()-point3.getY());
	}
	
	private double getWidth() {
		return Math.abs(point1.getX()-point2.getX());
	}
	
	@Override
	public String toString() {
		return "Coordinates of Parallelogram are " + point1.toString() + ", " + point2.toString() + ", " + point3.toString() + ", " + point4.toString()
				+ "\nWidth is: " + format.format(getWidth()) + " Height is: " + format.format(this.height) + " Area is: " + format.format(getArea()) + "\n";
	}

}
