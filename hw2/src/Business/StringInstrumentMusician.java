package Business;

public class StringInstrumentMusician extends Musician {

	public StringInstrumentMusician() {
		super();
	}
	
	public StringInstrumentMusician(Tempo tempo) {
		super(tempo);
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkIfNull(piece);
		String whatWillBePlayed = "X";
		String[] parts = piece.getParts();
		for(String line : parts) {
			whatWillBePlayed += line;
		}
		return whatWillBePlayed;
	}
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given object is null, therefore the program cannot play the song.");
		}
	}
}
