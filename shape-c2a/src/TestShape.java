import java.awt.geom.Point2D;

import shape.Rectangle;
import shape.Square;

public class TestShape {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Rectangle r = new Rectangle(new Point2D.Double(10., 10.), 10, 5);
		r.move(30., 30.);
		System.out.println(r);
		Square s = new Square(new Point2D.Double(10., 10.), 10);
		s.move(30., 30.);
		System.out.println(s);
	}

}
