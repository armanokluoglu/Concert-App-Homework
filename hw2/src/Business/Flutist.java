package Business;

public class Flutist extends WoodwindInstrumentMusician {

	private boolean isInitialized = false;
	
	public Flutist() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		String whatWillBePlayed = "Flut is played: \n";
		
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalArgumentException("Given flutist object was not created properly.");
		}
	}
}
