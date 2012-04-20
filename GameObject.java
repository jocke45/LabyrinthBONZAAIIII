import org.newdawn.slick.Image;

public class GameObject implements GameObjectInterface {
	private Drawable img;
	private float[] pos;
	
	public GameObject(Image i, float x, float y) {
		pos[0] = x;
		pos[1] = y;
		img = new Drawable(i, pos);
	}
	
	public float[] getPos() {
		return pos;
	}
	
	public Drawable getDrawable() {
		return img;
	}
	
	public boolean checkCollision() {
		return false;
	}
	
	public void setPos(float x, float y) {
		pos[0] = x;
		pos[1] = y;
	}
	
	public void update() {
		//Do nothing
	}
}
