package shape.viewer;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.geom.Point2D;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

import shape.Square;
import shape.Rectangle;
import shape.Shape;

public class ShapeViewer extends JFrame {
	private JFrame mainFrame;
	private JPanel buttonFrame;
	private DessinZone dessinPanel;

	private Random m_random;

	public ShapeViewer() {
		mainFrame = new JFrame();
		mainFrame.setSize(400, 400);
		mainFrame.setLayout(new BorderLayout());
		m_random = new Random();

		buttonFrame = new JPanel();
		getContentPane().add(buttonFrame, BorderLayout.SOUTH);

		dessinPanel = new DessinZone();
		dessinPanel.setShapeList(new ArrayList<Shape>());
		getContentPane().add(dessinPanel, BorderLayout.CENTER);

		JButton b1 = new JButton("Rectangle");
		b1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Rectangle");
				Rectangle r = new Rectangle(
						new Point2D.Double(200 * m_random.nextDouble(), 200 * m_random.nextDouble()),
						200 * m_random.nextDouble(), 200 * m_random.nextDouble());
				dessinPanel.addShape(r);
				dessinPanel.repaint();
			}
		});
		buttonFrame.add(b1);

		JButton b2 = new JButton("Square");
		b2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				System.out.println("Square");
				Square s = new Square(new Point2D.Double(200 * m_random.nextDouble(), 200 * m_random.nextDouble()),
						200 * m_random.nextDouble());
				dessinPanel.addShape(s);
				dessinPanel.repaint();
			}
		});
		buttonFrame.add(b2);

		setBounds(100, 100, 600, 400);
		setTitle("Shape Viewer");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ShapeViewer viewer = new ShapeViewer();
					viewer.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
}
