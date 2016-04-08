package shape;

import java.awt.geom.Point2D;

public class Square extends AbstractRectangle {

	public Square(Point2D p0, double size) {
		super(p0, size, size);
	}

	public String toString() {
		return "Square " + position + ", size = " + height;
	}
}
