package Business;

public class Violinist extends StringInstrumentMusician {

	private boolean isInitialized = false;
	
	public Violinist() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		String whatWillBePlayed = "Violin is played: \n";
		if(this.getTempo() != Tempo.prestissimo) {
			whatWillBePlayed = super.playPiece(piece);
		}
		return whatWillBePlayed + " " + this.getTempo().toString();
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given violinist object was not created proeprly.");
		}
	}
}
