import org.newdawn.slick.GameContainer;
import org.newdawn.slick.Graphics;
import org.newdawn.slick.Input;
import org.newdawn.slick.SlickException;
import org.newdawn.slick.state.BasicGameState;
import org.newdawn.slick.state.StateBasedGame;

public class MenuState extends BasicGameState {
   private enum STATES {MENUSTATE, STARTGAME, LOADGAME, QUIT}
   private STATES state = null;
    int stateID = -1;

    MenuState(int stateID) {
      this.stateID = stateID;
    }

    @Override
    public int getID() {
       return stateID;
    }

    public void init(GameContainer c, StateBasedGame sbg) throws SlickException {
       state = STATES.MENUSTATE;
    }

    public void render(GameContainer c, StateBasedGame sbg, Graphics g) throws SlickException {
       g.drawString("Wanna play?", 1280/2, 800/3);// jag tycker ENTER passar bättre än q(=quit)
       g.drawString("Press 'ENTER' to play!!", 1280/2, 600);
    }

    public void update(GameContainer c, StateBasedGame sbg, int delta) throws SlickException {
       Input ip = c.getInput();
       switch(state) {
       case MENUSTATE:
           if(ip.isKeyDown(Input.KEY_ENTER)) {
               state = STATES.STARTGAME;
           }
           break;
       case STARTGAME:
           state = STATES.MENUSTATE;
           sbg.enterState(MainClassTwo.LABYRINTHBONZAAAIIII);
           break;
       }
    }
}