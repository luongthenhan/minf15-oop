package shape;

public class Rectangle {
	private int height;
	private int width;

	public Rectangle(int height, int width) {
		this.height = height;
		this.width = width;
	}

	public int height() {
		return height;
	}

	public int width() {
		return width;
	}

	public void setHeight(int h) {
		height = h;
	}

	public void setWidth(int w) {
		width = w;
	}

	public int perimeter() {
		return 2 * (height + width);
	}

	public int surface() {
		return height * width;
	}
}
