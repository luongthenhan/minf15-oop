package shape;

import java.awt.geom.Point2D;

public class Rectangle extends AbstractRectangle {
	public Rectangle(Point2D p0, double height, double width) {
		super(p0, height, width);
	}

	public String toString() {
		return "Rectangle " + position + ", height = " + height + ", width = " + width;
	}

}
