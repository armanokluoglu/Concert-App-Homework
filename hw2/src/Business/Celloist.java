package Business;

public class Celloist extends StringInstrumentMusician {

	
	private boolean isInitialized = false;
	
	public Celloist() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		String whatCelloistPlays = "Cello is played: \n";
		String allPartsOfThePiece = super.playPiece(piece);
		String[] allPartsArray = allPartsOfThePiece.split("\n");
		for(String note : allPartsArray) {
			whatCelloistPlays += " " + note.charAt(0);
		}
		return whatCelloistPlays + " "  + this.getTempo().toString();
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given celloist object was not created properly.");
		}
	}
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given piece object was null, therefore cannot be played.");
		}
	}
}
