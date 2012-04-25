public class WallV extends GameObject {
	private int[] img = {8,0,4,16};
	
	public WallV(float x, float y) {
		super(x,y);
		setImg(img);
		createBB(img);
		setPos(x,y,false);
	}
}