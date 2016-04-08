package shape;

import java.awt.geom.Point2D;

public class Rectangle implements Shape {
	private Point2D position;

	private double height;

	private double width;

	public Rectangle(Point2D p0, double height, double width) {
		this.position = (Point2D) p0.clone();
		this.height = height;
		this.width = width;
	}

	public Point2D position() {
		return (Point2D) position.clone();
	}

	public double height() {
		return height;
	}

	public double width() {
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

	public String toString() {
		return "Rectangle " + position + ", height = " + height + ", width = "
				+ width;
	}
}
