import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.image.BufferedImage;

import javax.imageio.ImageIO;
import javax.swing.JPanel;
import javax.swing.Timer;

public class GamePanel extends JPanel implements ActionListener,KeyListener{
	public static BufferedImage image;
	public static boolean needImage = true;
	public static boolean gotImage = false;	
	final int MENU = 0;
	final int GAME = 1;
    final int END = 2;
    Timer frameDraw;
    int currentState = MENU;
    Font titleFont = new Font("Arial", Font.PLAIN, 48);
    Font captionFont = new Font("Arial", Font.PLAIN, 20);
    Rocketship ship = new Rocketship (250,700,50,50);
    ObjectManager manager = new ObjectManager(ship);
	@Override
	public void paintComponent(Graphics g){
		if(currentState == MENU){
		    drawMenuState(g);
		}else if(currentState == GAME){
		    drawGameState(g);
		}else if(currentState == END){
		    drawEndState(g);
		}
	}
	public GamePanel() {
		frameDraw = new Timer(1000/60,this);
	    frameDraw.start();
	}
	public void updateMenuState() {  
		manager.update();
	}
	public void updateGameState() {  
		
	}
	public void updateEndState()  {  
		
	}
	public void drawMenuState(Graphics g) { 
		
		g.setColor(Color.BLUE);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("LEAGUE INVADERS", 20, 100);
		g.setFont(captionFont);
		g.drawString("PRESS ENTER TO START" , 120, 350);
		g.drawString("PRESS SPACE FOR INSTRUCTIONS" , 70, 500);
	}
	public void drawGameState(Graphics g) { 
		
		manager.draw(g);
	}
	public void drawEndState(Graphics g)  { 
		g.setColor(Color.RED);
		g.fillRect(0, 0, LeagueInvaders.WIDTH, LeagueInvaders.HEIGHT);
		g.setFont(titleFont);
		g.setColor(Color.YELLOW);
		g.drawString("GAME OVER", 110, 100);
		g.setFont(captionFont);
		g.drawString("YOU KILLED ENEMIES" , 140, 500);
		g.drawString("PRESS ENTER TO RESTART" , 120, 350);
	}
	@Override
	public void actionPerformed(ActionEvent arg0) {
		// TODO Auto-generated method stub
		System.out.println("ACTION");
		repaint();
		if(currentState == MENU){
		    updateMenuState();
		}else if(currentState == GAME){
		    updateGameState();
		}else if(currentState == END){
		    updateEndState();
		}
	}
	@Override
	public void keyPressed(KeyEvent arg0) {
		// TODO Auto-generated method stub
		if (arg0.getKeyCode()==KeyEvent.VK_ENTER) {
		    if (currentState == END) {
		        currentState = MENU;
		    } else {
		        currentState++;
		    }
		}   
		if(currentState == GAME) {
			if (arg0.getKeyCode()==KeyEvent.VK_UP && ship.y > 0) {
			    ship.up();
			}
			if (arg0.getKeyCode()==KeyEvent.VK_LEFT && ship.x > 0) {
			    ship.left();
			}
			if (arg0.getKeyCode()==KeyEvent.VK_DOWN && ship.y < 725) {
			    ship.down();
			}
			if (arg0.getKeyCode()==KeyEvent.VK_RIGHT && ship.x < 450) {
			   ship.right();
			}
		}
	}
	@Override
	public void keyReleased(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	@Override
	public void keyTyped(KeyEvent arg0) {
		// TODO Auto-generated method stub
		
	}
	void loadImage(String imageFile) {
	    if (needImage) {
	        try {
	            image = ImageIO.read(this.getClass().getResourceAsStream(imageFile));
		    gotImage = true;
	        } catch (Exception e) {
	            
	        }
	        needImage = false;
	    }
	}
}
