public class GameObject implements GameObjectInterface {
	private int[] img = new int[4];
	private float[] pos = new float[2];
	
	public GameObject(int[] img, float x, float y) {
		pos[0] = x;
		pos[1] = y;
		this.img = img;
	}
	
	public float[] getPos() {
		return pos;
	}
	
	public int[] getImg() {
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
