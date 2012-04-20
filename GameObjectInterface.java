/**
 * GameObject handles basic objects
 * @author Johan Ekström
 * @version 0.12.04.15
 */
public interface GameObjectInterface {
	
	/**
	 * Returns a vector with the position of the object
	 * @return A vector with the position of the object
	 */
	public float[] getPos();
	
	/**
	 * Returns the image object from the object
	 * @return The image object that is 
	 */
	public int[] getImg();
	
	/**
	 * Checks if a collision has occurred with another GameObject and runs some code
	 * @param collisionObject The object that is checked for collision
	 */
	public boolean checkCollision();
	
	public void setPos(float x, float y);
	
	public void update();
}
