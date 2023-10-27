import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Random;

public class ObjectManager {
	Rocketship rocket;
	ArrayList<Projectile> projectile = new ArrayList<Projectile> ();
	ArrayList<Alien> aliens = new ArrayList<Alien> ();
	Random ran = new Random();
	public ObjectManager(Rocketship rocket) {
		this.rocket = rocket;
	}
	public void addProjectile(Projectile p) {
		projectile.add(p);
	}
	public void addAlien(Alien a) {
		aliens.add(new Alien(ran.nextInt(LeagueInvaders.WIDTH),0,50,50));
	}
	public void update() {
		for(int i = 0; i < aliens.size(); i ++) {
			aliens.get(i).update();
			if(aliens.get(i).y > 800) {
				aliens.get(i).isActive = false;
			}
		}
	}
	public void draw(Graphics g) {
		rocket.draw(g);
		for(int i = 0; i < aliens.size(); ++i) {
			aliens.get(i).draw(g);
		}
		for(int i = 0; i < projectile.size(); ++i) {
			projectile.get(i).draw(g);
		}
	}
	public void purgeObjects() {
		for(int i = 0; i< aliens.size(); i ++) {
			if(aliens.get(i).isActive = false) {
				aliens.remove(i);
			}
		}
	}
}
