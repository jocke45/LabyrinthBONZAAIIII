import org.newdawn.slick.Image;

public class Drawable {
	private Image img;
	private float[] pos;
	
	public Drawable(Image img, float[] pos) {
		this.img = img;
		this.pos[0] = pos[0];
		this.pos[1] = pos[1];
	}
	
	public Image getImg() {
		return img;
	}
	
	public float[] getPos() {
		return pos;
	}
}
