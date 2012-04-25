import org.newdawn.slick.Image;
import org.newdawn.slick.SlickException;

import java.io.BufferedReader;
import java.io.FileReader;
import java.util.HashSet;

public class Level implements LevelInterface {

	private HashSet<GameObject> obstacles;
	private int[] dim = new int[2];
	private float[] playerPos;

	public Level(String file) {
		loadLevel(file);
	}

	public void loadLevel(String file) {
		obstacles = new HashSet<GameObject>();
		int vPos = 0;
		try {
			BufferedReader levelFile = new BufferedReader(new FileReader(file));
			String edges = levelFile.readLine();
			while (edges != null) {
				System.out.println(edges);
				for (int i = 0; i < edges.length(); i++) {
					if (edges.substring(i, i + 1).equals("H")) {
						obstacles.add(new Wall(i * 16, vPos - 2));
					} else if (edges.substring(i, i + 1).equals("P")) {
						playerPos = new float[] { i * 16, vPos + 2};
					}
				}

				edges = levelFile.readLine();
				System.out.println(edges);
				if (edges != null) {
					for (int i = 0; i < edges.length(); i++) {
						for (i = 0; i < edges.length(); i++) {
							if (edges.substring(i, i + 1).equals("V")) {
								obstacles.add(new WallV((i * 16) - 2, vPos));
							} else if (edges.substring(i, i + 1).equals("P")) {
								playerPos = new float[] { i * 16, vPos + 2};
							}
						}
					}
					edges = levelFile.readLine();
					vPos += 16;
				}
			}
		} catch (Exception e) {
			System.out.println(e);
		}
	}

	public int[] getDimensions() {
		return dim;
	}

	public Image getResources() {
		try {
			return new Image("./res/slick.png");
		} catch (SlickException e) {
		}
		return null;
	}

	public HashSet<GameObject> getObj() {
		return obstacles;
	}

	public Player getPlayer() {
		return new Player(playerPos[0], playerPos[1]);
	}

	public String getNextLevel() {
		return "drugS";
	}

	public void update() {
		for (GameObject o : obstacles) {
			o.update();
		}
	}
}
