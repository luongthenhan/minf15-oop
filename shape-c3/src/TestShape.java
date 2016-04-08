import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.List;

import shape.Rectangle;
import shape.Shape;
import shape.Square;

public class TestShape {
	public static void main(String[] args) {
		List<Shape> lq = new ArrayList<Shape>();
		Shape r = new Rectangle(new Point2D.Double(10., 10.), 10, 5);
		r.move(30., 30.);
		lq.add(r);
		Square s = new Square(new Point2D.Double(10., 10.), 10);
		s.move(30., 30.);
		lq.add(s);

		for (Shape q : lq) {
			System.out.println(q);
		}
	}
}
