public class Player extends GameObject {
	public enum MOVES {
		MOVE_UP, MOVE_DOWN, MOVE_LEFT, MOVE_RIGHT, MOVE_NONE
	}
	private int[] img = {0,0,16,16};
	
	public Player(float x, float y) {
		super(x, y);
		setImg(img);
		createBB(img);
		setPos(x,y,false);
	}
	public void update(MOVES s) {
		switch (s) {
		case MOVE_UP:
			setPos(0, -.2f, true);
			break;
		case MOVE_RIGHT:
			setPos(.2f, 0, true);
			break;
		case MOVE_DOWN:
			setPos(0, .2f, true);
			break;
		case MOVE_LEFT:
			setPos(-.2f, 0, true);
			break;
		}
	}
	public void playerCollide(MOVES s) {
		switch (s) {
		case MOVE_UP:
			setPos(0, .2f, true);
			break;
		case MOVE_RIGHT:
			setPos(-.2f, 0, true);
			break;
		case MOVE_DOWN:
			setPos(0, -.2f, true);
			break;
		case MOVE_LEFT:
			setPos(.2f, 0, true);
			break;
		}
	}
}