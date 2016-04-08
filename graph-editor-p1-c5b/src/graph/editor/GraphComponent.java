package graph.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

public class GraphComponent extends JComponent implements MouseInputListener {

	private static final long serialVersionUID = 1L;

	private List<Point> pointList = new ArrayList<>();
	private List<Color> colors = new ArrayList<>();
	private Point currentPoint = null;
	private int dx = 0;
	private int dy = 0;
	private static final int RADIUS = 50;
	private static final Color[] colorList = new Color[] { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW };

	public GraphComponent() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		for (int i = 0; i < pointList.size(); i++) {
			Point p = pointList.get(i);
			g.setColor(colors.get(i));
			g.fillOval(p.x - RADIUS, p.y - RADIUS, 2 * RADIUS, 2 * RADIUS);
		}
	}

	private Point getPoint(int x, int y) {
		for (int i = pointList.size() - 1; i >= 0; i--) {
			Point p = pointList.get(i);
			if (p.distance(x, y) < RADIUS) {
				dx = x - p.x;
				dy = y - p.y;
				return p;
			}
		}
		return null;
	}

	private Point createPoint(int x, int y) {
		if (getPoint(x, y) != null)
			throw new IllegalArgumentException();
		Point p = new Point(x, y);
		Random r = new Random();
		pointList.add(p);
		colors.add(colorList[r.nextInt(9)]);
		return p;
	}

	@Override
	public void mouseClicked(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseClicked");
	}

	@Override
	public void mouseEntered(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseEntered");
	}

	@Override
	public void mouseExited(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseExited");
	}

	@Override
	public void mousePressed(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mousePressed");
		int x = arg0.getX();
		int y = arg0.getY();
		currentPoint = getPoint(x, y);
		if (currentPoint == null) {
			currentPoint = createPoint(x, y);
			repaint();
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseReleased");
		currentPoint = null;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseDragged");
		if (currentPoint != null) {
			currentPoint.setLocation(arg0.getX() - dx, arg0.getY() - dy);
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseMoved");
	}
}
