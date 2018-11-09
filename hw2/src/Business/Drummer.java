package Business;

public class Drummer extends PercussionInstrumentMusician {

	private int partCounter = 1;
	private boolean isInitialized = false;
	
	public Drummer() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		Tempo[] tempos = piece.getTempo();
		String[] parts = piece.getParts();
		String output;
		if(((tempos[partCounter-1] == Tempo.vivace) || (tempos[partCounter-1] == Tempo.prestissimo) ||
			(tempos[partCounter-1] == Tempo.allegretto)) && (partCounter > parts.length-3)) {
			output = "Drum is played: \n";
			output += "Part " + partCounter + " ";
			output += parts[partCounter-1].replaceAll("^[\\.\\d]+", "");
			output += " " + tempos[partCounter-1];
			output = output.replaceAll("[FGABH]", "X");
		} else {
			output = "";
		}
		partCounter++;
		return output;
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given drummer object was not created proeprly.");
		}
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null)
			throw new IllegalArgumentException("Given piece object is null.");
	}
}
