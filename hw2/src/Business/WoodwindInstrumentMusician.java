package Business;

import java.util.ArrayList;

public class WoodwindInstrumentMusician implements MusicianInterface {

	public String playPiece(Piece piece) {
		checkIfNull(piece);
		String[] parts = piece.getParts();
		ArrayList<String> chorusParts = piece.getChorus();
		String output = "";
		int partIndex = 1;
		for(String part: parts) {
			if(chorusParts.contains(part)) {
				String line = part.replaceAll("^[\\.\\d]+", "");
				output = output + "Part " + partIndex + ": " + line + "\n";
				partIndex++;
			}
		}
		return output;
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null) {
			throw new IllegalArgumentException("Given piece object is null, therefore the program cannot play the song.");
		}
	}
}
