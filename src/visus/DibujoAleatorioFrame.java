package visus;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Random;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

public class DibujoAleatorioFrame extends JFrame {

	/**
	 * 
	 */
	private static final long serialVersionUID = -2517681739961668962L;
	private JPanel contentPane;

	public DibujoAleatorioFrame() {
		setTitle("Dibujo Aleatorio");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 600, 400);

		// Creamos el panel personalizado para dibujar
		contentPane = new JPanel() {
			/**
			 * 
			 */
			private static final long serialVersionUID = -4021755076221986734L;

			@Override
			protected void paintComponent(Graphics g) {
				super.paintComponent(g);
				dibujarAleatoriamente(g);
			}
		};

		setContentPane(contentPane);
	}

	private void dibujarAleatoriamente(Graphics g) {
		Random rand = new Random();

		// Dibuja 10 formas aleatorias
		for (int i = 0; i < 10; i++) {
			int x = rand.nextInt(getWidth());
			int y = rand.nextInt(getHeight());
			int width = rand.nextInt(100) + 20;
			int height = rand.nextInt(100) + 20;

			// Color aleatorio
			g.setColor(new Color(rand.nextInt(256), rand.nextInt(256), rand.nextInt(256)));

			// Forma aleatoria
			if (rand.nextBoolean()) {
				g.fillRect(x, y, width, height); // rectángulo
			} else {
				g.fillOval(x, y, width, height); // óvalo
			}
		}
	}

	public static void main(String[] args) {
		SwingUtilities.invokeLater(() -> {
			DibujoAleatorioFrame frame = new DibujoAleatorioFrame();
			frame.setVisible(true);
		});
	}
}

