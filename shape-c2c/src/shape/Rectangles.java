package shape;

public class Rectangles {

	/* Problem with square !!! */
	public static void resize(Rectangle r, int factor) {
		r.setHeight(factor * r.height());
		r.setWidth(factor * r.width());
	}
}
