package shape;

import java.awt.geom.Point2D;

public interface Shape {

	public abstract Point2D position();

	public abstract double area();

	public abstract double perimeter();

	public abstract void move(double dx, double dy);

	public abstract void moveTo(Point2D newPosition);

}