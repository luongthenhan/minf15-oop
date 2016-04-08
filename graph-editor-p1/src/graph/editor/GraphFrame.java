package graph.editor;

import java.awt.BorderLayout;
import java.awt.Dimension;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.border.EmptyBorder;

public class GraphFrame extends JFrame {

	private static final long serialVersionUID = 1L;
	private GraphComponent component;
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					GraphFrame frame = new GraphFrame();
					frame.pack();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public GraphFrame() {
		super("Graph Editor");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		//setBounds(100, 100, 450, 300);
		component = new GraphComponent();
		component.setBorder(new EmptyBorder(5, 5, 5, 5));
		component.setLayout(new BorderLayout(0, 0));
		component.setPreferredSize(new Dimension(500,500));
		setContentPane(component);
	}

}
