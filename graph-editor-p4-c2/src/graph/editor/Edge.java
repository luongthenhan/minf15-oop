package graph.editor;

import java.awt.Color;
import java.awt.Graphics2D;
import java.awt.Paint;
import java.awt.geom.Ellipse2D;
import java.awt.geom.Line2D;
import java.awt.geom.RectangularShape;
import java.util.ArrayList;
import java.util.List;

public class Edge {
	Vertex v1;
	Vertex v2;
	List<RectangularShape> jointPoints = new ArrayList<RectangularShape>();
	private static final int JOINT_POINT_SIZE = 10;

	Edge(Vertex v1, Vertex v2) {
		this.v1 = v1;
		this.v2 = v2;
	}

	void addJointPoint() {
		jointPoints.add(new Ellipse2D.Double((int) v2.shape.getCenterX(), (int) v2.shape.getCenterY(), JOINT_POINT_SIZE,
				JOINT_POINT_SIZE));
	}

	void removeJointPoint(RectangularShape jp) {
		jointPoints.remove(jp);
	}

	RectangularShape getJointPoint(int x, int y) {
		for (RectangularShape p : jointPoints) {
			if (p.contains(x, y))
				return p;
		}
		return null;
	}

	boolean contains(int x, int y, double precision) {
		double x1 = v1.shape.getCenterX();
		double y1 = v1.shape.getCenterY();
		for (RectangularShape jp : jointPoints) {
			double x2 = jp.getCenterX();
			double y2 = jp.getCenterY();
			if (Line2D.ptLineDist(x1, y1, x2, y2, x, y) < precision)
				return true;
			x1 = x2;
			y1 = y2;
		}
		double x2 = v2.shape.getCenterX();
		double y2 = v2.shape.getCenterY();
		return Line2D.ptLineDist(x1, y1, x2, y2, x, y) < precision;
	}

	void draw(Graphics2D g2) {
		int x1 = (int) v1.shape.getCenterX();
		int y1 = (int) v1.shape.getCenterY();
		for (RectangularShape jp : jointPoints) {
			int x2 = (int) jp.getCenterX();
			int y2 = (int) jp.getCenterY();
			g2.drawLine(x1, y1, x2, y2);
			x1 = x2;
			y1 = y2;
		}
		Paint bg = g2.getPaint();
		g2.setPaint(Color.RED);
		for (RectangularShape jp : jointPoints)
			g2.fill(jp);
		g2.setPaint(bg);
		g2.drawLine(x1, y1, (int) v2.shape.getCenterX(), (int) v2.shape.getCenterY());
	}
}
