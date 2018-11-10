package Business;

public class Violinist extends StringInstrumentMusician {

	private int partCounter = 1;
	private boolean isInitialized = false;
	
	public Violinist() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		Tempo[] tempos = piece.getTempo();
		String[] parts = piece.getParts();
		String output = "";
		if(tempos[partCounter-1] == Tempo.prestissimo) {
			output = "Violin is played: \n";
			output += "Part " + partCounter + " ";
			output += parts[partCounter-1].replaceAll("^[\\.\\d]+", "");
			output += " " + tempos[partCounter-1];
		}
		if(partCounter == parts.length) {
			partCounter = 1;
		} else {
			partCounter++;
		}
		return output;
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given violinist object was not created properly.");
		}
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null) {
			throw new IllegalArgumentException("Given piece object was null, therefore cannot be played.");
		}
	}
}
