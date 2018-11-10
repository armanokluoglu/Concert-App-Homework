package Business;

public class Violist extends StringInstrumentMusician{

	private int partCounter = 1;
	private boolean isInitialized = false;
	
	public Violist() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		Tempo[] tempos = piece.getTempo();
		String[] parts = piece.getParts();
		ChangeInTempo changeInTempo = piece.getChangeInTempo();
		String output;
		if((changeInTempo == ChangeInTempo.ritenuto) && (partCounter > 1)) {
			output = "";
		} else {
			output = "Viola is played: \n";
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
			throw new IllegalStateException("Given violist object was not created proeprly.");
		}
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null) {
			throw new IllegalArgumentException("Given piece object is null, therefore cannot be played.");
		}
	}
}
