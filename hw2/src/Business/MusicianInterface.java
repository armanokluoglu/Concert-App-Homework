package Business;

public interface MusicianInterface {
	
	/** Plays the given or read piece by the corresponding musician
	 * @param piece Piece object to be played.
	 * @return Returns the notes that will be printed later on in the program.
	 */
	public String playPiece(Piece piece);
}