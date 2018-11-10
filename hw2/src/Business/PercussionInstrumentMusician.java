package Business;

public class PercussionInstrumentMusician implements MusicianInterface {
	
	public String playPiece(Piece piece) {
		checkIfNull(piece);
		String output = "";
		String[] parts = piece.getParts();
		int partIndex = parts.length-2;
		for(int index=parts.length-2; index<parts.length; index++) {
			String line = parts[index].replaceAll("^[\\.\\d]+", "");
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
