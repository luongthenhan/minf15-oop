package shape;

import java.awt.geom.Point2D;

abstract class AbstractRectangle {
	Point2D position;

	double height;

	double width;

	AbstractRectangle(Point2D p0, double height, double width) {
		this.position = (Point2D) p0.clone();
		this.height = height;
		this.width = width;
	}

	public Point2D position() {
		return (Point2D) position.clone();
	}

	double height() {
		return height;
	}

	double width() {
		return width;
	}

	public double area() {
		return width * height;
	}

	public double perimeter() {
		return 2 * (width + height);
	}

	public void move(double dx, double dy) {
		position.setLocation(position.getX() + dx, position.getY() + dy);
	}

	public void moveTo(Point2D newPosition) {
		position.setLocation(newPosition);
	}
}
