package shape;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.geom.Point2D;

public class Rectangle implements Shape {

	private class InternalPoint extends Point2D.Double {

		InternalPoint(Point2D p) {
			super(p.getX(), p.getY());
		}

		public void setLocation(double x, double y) {
			super.setLocation(x, y);
			movingMessage();
		}
	}

	private Point2D position;

	private double height;

	private double width;

	public Rectangle(Point2D p0, double height, double width) {
		this.position = new InternalPoint(p0);
		this.height = height;
		this.width = width;
	}

	private void movingMessage() {
		System.out.println("moving to " + position.getX() + ", " + position.getY());
	}

	public Point2D position() {
		return (Point2D) position;
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

	// avoid code duplication. May be useful for client, then is public.
	public void moveTo(double x, double y) {
		position.setLocation(x, y);
	}

	public void move(double dx, double dy) {
		moveTo(position.getX() + dx, position.getY() + dy);
	}

	public void moveTo(Point2D newPosition) {
		moveTo(newPosition.getX(), position.getY());
	}

	public String toString() {
		return "Rectangle " + position + ", height = " + height + ", width = " + width;
	}

	@Override
	public void redessiner(Graphics g) {
		g.setColor(Color.RED);
		g.drawRect((int) Math.round(position.getX()), (int) Math.round(position.getY()), (int) Math.round(width),
				(int) Math.round(height));
	}
}
