package Business;

public class Musician implements MusicianInterface {

	
	private boolean isInitialized = false;
	
	public Musician() {
		isInitialized = true;
	}
	
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		String output = "";
		String[] parts = piece.getParts();
		int partIndex = 1;
		for(String part: parts) {
			String line = part.replaceAll("^[\\.\\d]+", "");
			output = output + "Part " + partIndex + ": " + line + "\n";
			partIndex++;
		}
		return output;
	}

	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given musician object was not created properly.");
		}
	}
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given object is null, therefore the program cannot play the song.");
		}
	}
}