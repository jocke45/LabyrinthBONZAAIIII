import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;
import java.util.HashSet;

public class Level implements LevelInterface {

	private HashSet<GameObject> obstacles;
	private int[] dim = new int[2];
	
	public Level(String file) {
		loadLevel(file);
	}
	
	public void loadLevel(String file) {
		obstacles = new HashSet<GameObject>();
		dim[0] = 10;
		dim[1] = 10;
		int[] img = new int[4];
		img[0] = 0;
		img[1] = 0;
		img[2] = 16;
		img[3] = 16;
		GameObject obj = new GameObject(img, 0, 0);
		obstacles.add(obj);
	}
	
	public int[] getDimensions() {
		return dim;
	}
	
	public Image getResources() {
		try {
		return new Image("./res/slick.png");
		}
		catch(SlickException e) {
			
		}
		return null;
	}
	
	public HashSet<GameObject> getObj() {
		return obstacles;
	}
	public String getNextLevel() {
		return "drugS";
	}
}
