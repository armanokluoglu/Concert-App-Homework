package Business;

public class Violist extends StringInstrumentMusician{

	private boolean isInitialized = false;
	
	public Violist() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		String whatWillBePlayed = "Viola is played: \n";
		if(this.getChangeInTempo() == ChangeInTempo.ritenuto) {
			whatWillBePlayed = getTheFirstPart(piece);
		}
		return whatWillBePlayed + " " + this.getTempo().toString();
	}
	
	
	private String getTheFirstPart(Piece piece) {
		checkIfNull(piece);
		String allPartsOfThePiece = super.playPiece(piece);
		String[] allPartsArray = allPartsOfThePiece.split("\n");
		String whatViolistPlays = allPartsArray[0];
		return whatViolistPlays;
	}
	
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given violinist object was not created proeprly.");
		}
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null) {
			throw new IllegalArgumentException("Given piece argument is null, therefore cannot be played.");
		}
	}
}
