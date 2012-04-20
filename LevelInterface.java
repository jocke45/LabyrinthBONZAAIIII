public interface LevelInterface {
	
	/**
	 * Loads a level from a file
	 * @param file The file where level information is contained
	 */
	public void loadLevel(String file);
	
	/**
	 * Returns the dimensions of the level
	 * @return The dimensions of the level
	 */
	public int[] getDimensions();
	
	/**
	 * Returns drawable Game Objects
	 * @return Drawable Game Objects
	 */
}
