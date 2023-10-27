import javax.swing.JFrame;

public class LeagueInvaders {
	public static final int WIDTH = 500;
	public static final int HEIGHT = 800;
	JFrame frame;
	GamePanel panel;
	public static void main(String[] args) {
		LeagueInvaders invaders = new LeagueInvaders();
		invaders.setup();
		
	}
	
	public LeagueInvaders() {
		panel = new GamePanel();
		frame = new JFrame();
	}
	public void setup() {
		frame.add(panel);
		frame.setSize(WIDTH, HEIGHT);
		frame.setVisible(true);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.addKeyListener(panel);
	}
}
