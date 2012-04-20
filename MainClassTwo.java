import org.newdawn.slick.AppGameContainer;
import org.newdawn.slick.GameContainer;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.StateBasedGame;

public class MainClassTwo extends StateBasedGame {
	 
    public static final int LABYRINTHBONZAAAIIII = 2;
    public static final int MENU = 1;
 
    public MainClassTwo()
    {
        super("LABYRINTHBONZAAAIIII");
        this.addState(new MenuState(MENU));
        this.addState(new GameplayState(LABYRINTHBONZAAAIIII));
        this.enterState(MENU);
    }
 
    public static void main(String[] args) throws SlickException
    {
         AppGameContainer app = new AppGameContainer(new MainClassTwo());
         app.setDisplayMode(1280, 800, false);
         app.start();
    }
 
    @Override
    public void initStatesList(GameContainer c) throws SlickException {
        this.getState(LABYRINTHBONZAAAIIII).init(c, this);
    	this.getState(MENU).init(c,this);
    }
}
