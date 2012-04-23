import org.newdawn.slick.geom.Polygon;

public class GameObject implements GameObjectInterface {
	private int[] img;
	private float[] pos = new float[2];
	private Polygon bb;
	
	public GameObject(float x, float y) {
		
	}
	public void setImg(int[]img) {
		this.img = img;
	}
	
	public float[] getPos() {
		return pos;
	}
	
	public int[] getImg() {
		return img;
	}
	
	public Polygon getPoly() {
		return bb;
	}
	
	public boolean checkCollision(Polygon e) {
		if(bb.intersects(e)) {
			return true;
		}
		return false;
	}
	
	public void setPos(float x, float y, boolean relative) {
		if(relative) {
			pos[0] += x;
			pos[1] += y;
		}
		else {
			pos[0] = x;
			pos[1] = y;
		}
		bb.setX(pos[0]);
		bb.setY(pos[1]);
	}
	
	public void createBB(int[] img) {
		bb = new Polygon(new float[] {
				0,0,
				0,img[3],
				img[2],img[3],
				img[2],0
		});
	}
	
	public void update() {
		//Do nothing
	}
}
