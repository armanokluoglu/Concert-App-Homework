package Business;

public class BellPlayer extends PercussionInstrumentMusician {

	private boolean isInitialized = false;
	
	public BellPlayer() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		String whatToPlay = "X";
		if((this.getTempo() == Tempo.grave) && (this.getChangeInTempo() ==  ChangeInTempo.stretto)) {
			whatToPlay = getTheNotesForBellPlayer(piece);
		}
		return whatToPlay;
	}
	
	private String getTheNotesForBellPlayer(Piece piece) {
		String notesToGet = "Bell is played: \n";
		String allPartsOfThePiece = super.playPiece(piece);
		String[] allPartsArray = allPartsOfThePiece.split("\n");
		for(String note : allPartsArray) {
			if((note.charAt(0) == 'F') || (note.charAt(0) == 'G') || (note.charAt(0) == 'A') || (note.charAt(0) == 'B')) {
				notesToGet += " " + note.charAt(0);
			}
			else {
				notesToGet += " X";
			}
		}
		return notesToGet + " " + this.getTempo().toString();
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given violinist object was not created proeprly.");
		}
	}
}
