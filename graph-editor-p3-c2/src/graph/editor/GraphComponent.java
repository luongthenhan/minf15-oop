package graph.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.MouseEvent;
import java.awt.geom.Ellipse2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

public class GraphComponent extends JComponent implements MouseInputListener {

	private static final long serialVersionUID = 1L;
	private List<RectangularShape> shapes = new ArrayList<RectangularShape>();
	private List<Color> colors = new ArrayList<>();
	private RectangularShape currentShape = null;
	private int dx = 0;
	private int dy = 0;
	private static final Color[] colorList = new Color[] { Color.BLACK, Color.BLUE, Color.CYAN, Color.GREEN,
			Color.MAGENTA, Color.ORANGE, Color.PINK, Color.RED, Color.YELLOW };

	private RectangularShape shapeSample = new Ellipse2D.Double(0, 0, 10, 10);

	List<Edge> edges = new ArrayList<Edge>();
	Edge currentEdge = null;

	public GraphComponent() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	protected void paintComponent(Graphics g) {
		if (isOpaque()) {
			g.setColor(getBackground());
			g.fillRect(0, 0, getWidth(), getHeight());
		}
		Graphics2D g2 = (Graphics2D) g;
		for (int i = 0; i < shapes.size(); i++) {
			RectangularShape s = shapes.get(i);
			g.setColor(colors.get(i));
			g2.fill(s);
		}
		for (Edge e : edges) {
			g.setColor(getForeground());
			e.draw(g2);
		}
	}

	private RectangularShape getShape(int x, int y) {
		for (int i = shapes.size() - 1; i >= 0; i--) {
			RectangularShape s = shapes.get(i);
			if (s.contains(x, y)) {
				dx = (int) (x - s.getCenterX());
				dy = (int) (y - s.getCenterY());
				System.out.println(dx);
				System.out.println(dy);
				return s;
			}
		}
		return null;
	}

	public void setShapeType(RectangularShape sample) {
		shapeSample = sample;
	}

	private RectangularShape createShape(int x, int y) {
		RectangularShape rs = newShape(x, y);
		shapes.add(rs);
		Random r = new Random();
		colors.add(colorList[r.nextInt(9)]);
		return rs;
	}

	private void moveShape(RectangularShape rs, int x, int y) {
		rs.setFrameFromCenter(x, y, x + rs.getHeight() / 2, y + rs.getWidth() / 2);
	}

	private RectangularShape newShape(int x, int y) {
		RectangularShape rs = (RectangularShape) shapeSample.clone();
		moveShape(rs, x, y);
		Random r = new Random();
		colors.add(colorList[r.nextInt(9)]);
		return rs;
	}

	private Edge startEdge(RectangularShape rs) {
		RectangularShape rs2 = newShape(0, 0);
		rs2.setFrameFromCenter((int) rs.getCenterX(), (int) rs.getCenterY(), (int) rs.getCenterX(),
				(int) rs.getCenterY());
		Edge e = new Edge(rs, rs2);
		edges.add(e);
		return e;
	}

	private void endEdge(Edge e, int x, int y) {
		RectangularShape rs = getShape(x, y);
		if (rs == null) {
			e.rs2.setFrameFromCenter(x, y, x + shapeSample.getHeight() / 2, y + shapeSample.getWidth() / 2);
			shapes.add(e.rs2);
		} else
			e.rs2 = rs;
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
		int x = arg0.getX();
		int y = arg0.getY();
		RectangularShape rs = getShape(x, y);
		if (rs == null)
			rs = createShape(x, y);
		if (arg0.isAltDown())
			currentEdge = startEdge(rs);
		else
			currentShape = rs;
		repaint();
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseReleased");
		if (currentEdge != null) {
			endEdge(currentEdge, arg0.getX(), arg0.getY());
			currentEdge = null;
			repaint();
		}
		currentShape = null;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseDragged");
		if (currentShape != null) {
			moveShape(currentShape, arg0.getX() - dx, arg0.getY() - dy);
			repaint();
		} else if (currentEdge != null) {
			moveShape(currentEdge.rs2, arg0.getX(), arg0.getY());
			repaint();
		}
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseMoved");
	}

}
