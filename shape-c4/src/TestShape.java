import java.awt.geom.Point2D;

import shape.Rectangle;
import shape.Square;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r = new Rectangle(new Point2D.Double(10., 10.), 10, 5);
		Point2D pr = r.position();
		pr.setLocation(20, 20);
		pr.setLocation(new Point2D.Double(40, 40));
		System.out.println(r);

		Square s = new Square(new Point2D.Double(10., 10.), 10);
		Point2D ps = s.position();
		ps.setLocation(30, 30);
		ps.setLocation(new Point2D.Double(40, 40));
		System.out.println(s);
	}

}
