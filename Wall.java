public class Wall extends GameObject {
	private int[] img = {0,0,16,16};
	
	public Wall(float x, float y) {
		super(x,y);
		setImg(img);
		createBB(img);
		setPos(x,y,false);
	}
}
