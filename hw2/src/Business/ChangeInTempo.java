package Business;

public class Drummer extends PercussionInstrumentMusician {

	private boolean isInitialized = false;
	
	public Drummer() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		String whatToPlay = "X";
		if((this.getTempo() == Tempo.prestissimo) || (this.getTempo() == Tempo.vivace) ||
			this.getTempo() == Tempo.allegretto){
				whatToPlay = getTheNotesToPlay(piece);
			}
		return whatToPlay;
	}
	
	private String getTheNotesToPlay(Piece piece) {
		checkIfNull(piece);
		String whatDrummerPlays = "Drummer is played: \n";
		String allPartsOfThePiece = super.playPiece(piece);
		String[] allPartsArray = allPartsOfThePiece.split("\n");
		for(String note : allPartsArray) {
			if((note.charAt(0) == 'C') || (note.charAt(0) == 'D') || (note.charAt(0) == 'E')) {
				whatDrummerPlays += " " + note.charAt(0);
			}
			else {
				whatDrummerPlays += " X";
			}
		}
		return whatDrummerPlays + " " + this.getTempo().toString();
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given drummer object was not created properly.");
			
		}
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null) {
			throw new IllegalArgumentException("Given piece argument is null, therefore cannot be played.");
		}
	}
}
