import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import org.newdawn.slick.Image;
import java.util.HashSet;

public class GameplayState extends BasicGameState {
	private static String s = "dugga!";
	private static Image res;
	private static HashSet<GameObject> obst;

	private enum STATES {
		LOAD_RES, MOVEiGUESS, PAUSE, MENU, WIN
	}

	private STATES state = null;
	private Level level;
	private float[] d = new float[2];
	int stateID = -1;

	GameplayState(int stateID) {
		s = "yayZer";
		this.stateID = stateID;
	}

	@Override
	public int getID() {
		return stateID;
	}

	public void init(GameContainer c, StateBasedGame sbg) throws SlickException {
		level = new Level(s);
		res = level.getResources();
		obst = level.getObj();
		
		d[0] = 200f;
		d[1] = 200f;
		state = STATES.MOVEiGUESS;
	}
	private void renderObjects() {
		for(GameObject o : obst) {
			int[] i = o.getImg();
			res.getSubImage(i[0], i[1], i[2], i[3]).draw();
		}
	}
	
	public void render(GameContainer c, StateBasedGame sbg, Graphics g) {
		switch (state) {
		case LOAD_RES:
			break;
		case PAUSE:
			renderObjects();
			g.drawString("PAUSE", 600, 300);
			break;
		case MOVEiGUESS:
			renderObjects();
			break;
		}
	}

	public void update(GameContainer c, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = c.getInput();
		switch (state) {
		//Laddar en ny labyrint
		case LOAD_RES:
			try {
			s = level.getNextLevel();
			init(c,sbg);
			}
			catch(SlickException e) {
			}
			break;
		//Går till huvudmenyn
		case MENU:
			state = STATES.MOVEiGUESS;
			sbg.enterState(MainClassTwo.MENU);
			break;
		//Uppdaterar alla objekt
		case MOVEiGUESS:
			if (input.isKeyDown(Input.KEY_ESCAPE)) {
				state = STATES.MENU;
			}
			if (input.isKeyDown(Input.KEY_W)) {
				state = STATES.LOAD_RES;
			}
			if (input.isKeyDown(Input.KEY_S)) {
			}
			if (input.isKeyDown(Input.KEY_A)) {
			}
			if (input.isKeyDown(Input.KEY_D)) {
			}
			if (input.isKeyDown(Input.KEY_P)) {
				state = STATES.PAUSE;
			}
			d[0] += .2f;
			d[1] += .2f;
			break;
		//Pausar spelet
		case PAUSE:
			if (input.isKeyDown(Input.KEY_R)) {
				state = STATES.MOVEiGUESS;
			}
			if (input.isKeyDown(Input.KEY_ESCAPE)) {
				state = STATES.MENU;
			}
			break;
		}
	}
}