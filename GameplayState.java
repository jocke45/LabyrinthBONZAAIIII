import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;
import java.util.HashSet;

public class GameplayState extends BasicGameState {
	private static HashSet<Drawable> drawables;
	private static String s = "dugga!";

	private enum STATES {
		LOAD_RES, MOVEiGUESS, PAUSE, MENU, WIN
	}

	private STATES state = null;
	private Level level;
	private float[] d = new float[2];
	int stateID = -1;

	GameplayState(int stateID) {
		this.stateID = stateID;
		level = new Level("durp");
	}

	@Override
	public int getID() {
		return stateID;
	}

	public void init(GameContainer c, StateBasedGame sbg) throws SlickException {
		state = STATES.LOAD_RES;
		d[0] = 200f;
		d[1] = 200f;
	}

	public void render(GameContainer c, StateBasedGame sbg, Graphics g) {
		switch (state) {
		case LOAD_RES:
			break;
		case PAUSE:
			g.drawString("PAUSE", 600, 300);
		case MOVEiGUESS:
			if (drawables != null) {
				g.drawString("loll", d[0], d[1]);
			} else {
				g.drawString(s, 300, 300);
			}
			break;
		}
	}

	public void update(GameContainer c, StateBasedGame sbg, int delta)
			throws SlickException {
		Input input = c.getInput();
		switch (state) {
		case LOAD_RES:
			s = "fucko!";
			level.loadLevel("duro");
			drawables = level.getDrawables();
			if (drawables instanceof HashSet<?> && drawables != null) {
				state = STATES.MOVEiGUESS;
			} else {
				state = STATES.MENU;
			}
			break;
		case MENU:
			state = STATES.MOVEiGUESS;
			sbg.enterState(MainClassTwo.MENU);
			break;
		case MOVEiGUESS:
			if (input.isKeyDown(Input.KEY_ESCAPE)) {
				state = STATES.MENU;
			}
			if (input.isKeyDown(Input.KEY_W)) {
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