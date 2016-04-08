package graph.editor;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Point;
import java.awt.event.MouseEvent;

import javax.swing.JComponent;
import javax.swing.event.MouseInputListener;

public class GraphComponent extends JComponent implements MouseInputListener {

	private static final long serialVersionUID = 1L;

	private Point p = null;
	private static final int RADIUS = 50;
	private boolean moving = false;
	private int dx = 0;
	private int dy = 0;

	public GraphComponent() {
		addMouseListener(this);
		addMouseMotionListener(this);
	}

	@Override
	protected void paintComponent(Graphics g) {
		g.setColor(Color.BLUE);
		if (p != null) {
			g.fillOval(p.x - RADIUS, p.y - RADIUS, 2 * RADIUS, 2 * RADIUS);
		}
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
		if (p == null) {
			p = new Point(arg0.getX(), arg0.getY());
			repaint();
		}

		int x = arg0.getX();
		int y = arg0.getY();
		if (p.distance(x, y) < RADIUS) {
			moving = true;
			dx = x - p.x;
			dy = y - p.y;
			System.out.println("Holding");
		}
	}

	@Override
	public void mouseReleased(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseReleased");
		moving = false;
	}

	@Override
	public void mouseDragged(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseDragged");
		if (moving)
			p.setLocation(arg0.getX() - dx, arg0.getY() - dy);
		repaint();
	}

	@Override
	public void mouseMoved(MouseEvent arg0) {
		// TODO Auto-generated method stub
		// System.out.println("mouseMoved");
	}
}
