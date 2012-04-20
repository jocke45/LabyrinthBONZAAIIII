import org.newdawn.slick.BasicGame;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.Input;
import org.newdawn.slick.Image;
import java.util.HashSet;

public class MainClass extends BasicGame {
	private static Level level;
	private static HashSet<Drawable> drawables;
	private static Image img;
	private static float[] pos = new float[2];
	
	public MainClass() {
		super("SimpleTest");
		
		level = new Level("derp");
	}

	@Override
	public void init(GameContainer container) throws SlickException {
		level.loadLevel("");
		drawables = level.getDrawables();
	}

	@Override
	public void update(GameContainer container, int delta)
			throws SlickException {
		
		
		Input input = container.getInput();
		if(input.isKeyDown(Input.KEY_W)) {
			pos[1] -= .2f *delta;
		}
		if(input.isKeyDown(Input.KEY_S)) {
			pos[1] += .2f*delta;
		}
		if(input.isKeyDown(Input.KEY_A)) {
			pos[0] -= .2f*delta;
		}
		if(input.isKeyDown(Input.KEY_D)) {
			pos[0] += .2f*delta;
		}
	}

	@Override
	public void render(GameContainer container, Graphics g)
			throws SlickException {
		for(Drawable d : drawables) {
			g.drawImage(d.getImg(), d.getPos()[0], d.getPos()[1]);
		}
	}

	public static void main(String[] args) {
		try {
			AppGameContainer app = new AppGameContainer(new MainClass());
			app.setDisplayMode(1280,800,false);
			app.start();
		} catch (SlickException e) {
			e.printStackTrace();
		}
	}
}