package shape.viewer;

import java.awt.Graphics;
import java.util.List;
import javax.swing.JPanel;

import shape.Shape;

public class DessinZone extends JPanel {

	private List<Shape> shapeList;

	/**
	 * Create the panel.
	 */
	public DessinZone() {

	}

	public void setShapeList(List<Shape> l) {
		this.shapeList = l;
	}

	public void addShape(Shape shape) {
		this.shapeList.add(shape);
	}

	@Override
	public void paintComponent(Graphics g) {
		super.paintComponent(g);
		if (shapeList != null) {
			for (int i = 0; i < shapeList.size(); i++) {
				Shape f = (Shape) shapeList.get(i);
				f.redessiner(g);
			}
		}
	}

}
