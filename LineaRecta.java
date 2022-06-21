import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.Graphics;
import java.awt.Color;
import java.util.List;
import java.util.ArrayList;

public class LineaRecta extends JFrame{
	private int xi, yi, xf, yf, XF, YF;
	private PanelDibujo panel;
	private List<int[]> lineas;

	public LineaRecta(){
		initComponents();
	}

	private void initComponents(){
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(500,500);
		setLocationRelativeTo(null);
		setTitle("Dibujar lineas rectas");

		panel = new PanelDibujo();
		add(panel);

		lineas = new ArrayList<>();

		panel.addMouseListener(new MouseAdapter(){
			@Override 
			public void mousePressed(MouseEvent e){
				xi = e.getX();
				yi = e.getY(); 
				xf = e.getX();
				yf = e.getY(); 
			}

			public void mouseReleased(MouseEvent e){
				lineas.add(new int[]{xi,yi,xf,yf});
			}
		});

		panel.addMouseMotionListener(new MouseAdapter(){
			@Override 
			public void mouseDragged(MouseEvent e){
				xf = e.getX();
				yf = e.getY(); 
			}
		});
	}

	class PanelDibujo extends JPanel{
		@Override
		public void paintComponent(Graphics g){
			super.paintComponent(g);
			g.setColor(Color.BLACK);

			for (int[] l : lineas)
				g.drawLine(l[0],l[1],l[2],l[3]);

			g.drawLine(xi,yi,xf,yf);	
			repaint();
		}
	}

	public static void main(String[] args) {
		new LineaRecta().setVisible(true);
	}

	
}