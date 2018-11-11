package Business;

import Utilities.MusicianInterface;

public class StringInstrumentMusician implements MusicianInterface {
	
	public String playPiece(Piece piece) {
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
	
	private void checkIfNull(Piece piece) {
		if(piece == null) {
			throw new IllegalArgumentException("Given piece object is null, therefore the program cannot play the song.");
		}
	}
}