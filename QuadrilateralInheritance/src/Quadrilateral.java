import java.text.DecimalFormat;

public class Quadrilateral {
	protected double x1;
	protected double x2;
	protected double x3;
	protected double x4;
	
	protected double y1;
	protected double y2;
	protected double y3;
	protected double y4;

	Point point1 = new Point(x1,y1);
	Point point2 = new Point(x2,y2);
	Point point3 = new Point(x3,y3);
	Point point4 = new Point(x4,y4);
	
	DecimalFormat format = new DecimalFormat("0.00");
	
	public Quadrilateral(double a, double b, double c, double d, double e, double f, double g, double h){
		this.x1 = a;
		this.y1 = b;
		point1.setX(x1);
		point1.setY(y1);

		this.x2 = c;
		this.y2 = d;
		point2.setX(x2);
		point2.setY(y2);

		this.x3 = e;
		this.y3 = f;
		point3.setX(x3);
		point3.setY(y3);
		
		this.x4 = g;
		this.y4 = h;
		point4.setX(x4);
		point4.setY(y4);
	}

	@Override
	public String toString() {
		return "Coordinates of quadrilateral are " + point1.toString() + ", " + point2.toString() + ", "
				+ point3.toString() + ", " + point4.toString();
	}
	
	
}
