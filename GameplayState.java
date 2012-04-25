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
	private static Player player;

	private enum STATES {
		LOAD_RES, MOVEiGUESS, PAUSE, MENU, WIN
	}

	private STATES state = null;
	private Level level;
	int stateID = -1;

	GameplayState(int stateID) {
		s = "./res/level1.txt";
		this.stateID = stateID;
	}

	@Override
	public int getID() {
		return stateID;
	}

	public boolean checkPlayerCollision() {
		for(GameObject o : obst) {
			if(o.checkCollision(player.getPoly())) {
				return true;
			}
		}
		return false;
	}
	
	public void init(GameContainer c, StateBasedGame sbg) throws SlickException {
		level = new Level(s);
		res = level.getResources();
		obst = level.getObj();
		player = level.getPlayer();
		state = STATES.MOVEiGUESS;
	}
	
	private void renderObjects() {
		int[] i;
		float[] p;
		for(GameObject o : obst) {
			i = o.getImg();
			p = o.getPos();
			res.getSubImage(i[0], i[1], i[2], i[3]).draw(p[0],p[1]);
		}
		i = player.getImg();
		p = player.getPos();
		res.getSubImage(i[0], i[1], i[2], i[3]).draw(p[0],p[1]);
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
			Player.MOVES m = Player.MOVES.MOVE_NONE;
			if (input.isKeyDown(Input.KEY_ESCAPE)) {
				state = STATES.MENU;
			}
			if (input.isKeyDown(Input.KEY_W)) {
				m = Player.MOVES.MOVE_UP;
			}
			if (input.isKeyDown(Input.KEY_S)) {
				m = Player.MOVES.MOVE_DOWN;
			}
			if (input.isKeyDown(Input.KEY_A)) {
				m = Player.MOVES.MOVE_LEFT;
			}
			if (input.isKeyDown(Input.KEY_D)) {
				m = Player.MOVES.MOVE_RIGHT;
			}
			if (input.isKeyDown(Input.KEY_P)) {
				state = STATES.PAUSE;
			}
			player.update(m);
			if(checkPlayerCollision()) {
				player.playerCollide(m);
			}
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