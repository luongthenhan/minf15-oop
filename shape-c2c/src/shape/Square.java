package shape;

public class Square extends Rectangle {
	public Square(int size) {
		super(size, size);
	}

	public int size() {
		return height();
	}

	public void setSize(int s) {
		super.setHeight(s);
		super.setWidth(s);
	}

	public void setHeight(int h) {
		setSize(h);
	}

	public void setWidth(int w) {
		setSize(w);
	}
}
