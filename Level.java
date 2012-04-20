import org.newdawn.slick.Image;
import java.util.HashSet;

public class Level implements LevelInterface {

	private HashSet<GameObject> obstacles;
	private HashSet<Drawable> drawables;
	private int[] dim = new int[2];
	
	public Level(String file) {
		loadLevel(file);
	}
	
	public void loadLevel(String file) {
		obstacles = new HashSet<GameObject>();
		dim[0] = 10;
		dim[1] = 10;
		try {
		Image res = new Image("./res/slick.png");
		GameObject obj = new GameObject(res.getSubImage(0,0,16,16), 0, 0);
		obstacles.add(obj);
		drawables.add(obj.getDrawable());
		}
		catch(Exception e) {
			
		}
	}
	
	public int[] getDimensions() {
		return dim;
	}
	
	public HashSet<Drawable> getDrawables() {
		return drawables;
	}
}
