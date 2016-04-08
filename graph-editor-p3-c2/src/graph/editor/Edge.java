package graph.editor;

import java.awt.Graphics2D;
import java.awt.geom.Line2D;
import java.awt.geom.RectangularShape;

public class Edge {
	RectangularShape rs1;
	RectangularShape rs2;
	Line2D line;

	Edge(RectangularShape rs1, RectangularShape rs2) {
		this.rs1 = rs1;
		this.rs2 = rs2;
		this.line = new Line2D.Double(rs1.getCenterX(), rs1.getCenterY(), rs2.getCenterX(), rs2.getCenterY());
	}

	void draw(Graphics2D g2) {
		this.line.setLine(rs1.getCenterX(), rs1.getCenterY(), rs2.getCenterX(), rs2.getCenterY());
		g2.draw(line);
	}
}
