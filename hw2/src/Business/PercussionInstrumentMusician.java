package Business;

public class PercussionInstrumentMusician extends Musician {
	
	
	public PercussionInstrumentMusician() {
		super();
	}
	
	public PercussionInstrumentMusician(Tempo tempo) {
		super(tempo);
	}
	
	PercussionInstrumentMusician(PercussionInstrumentMusician pim){
		this(pim.getTempo());
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkIfNull(piece);
		String whatWillBePlayed = "";
		String[] parts = piece.getParts();
		String lastPartToPlay = parts[parts.length-1];
		String firstPartToPlay = parts[parts.length-2];
		whatWillBePlayed = whatWillBePlayed + firstPartToPlay;
		whatWillBePlayed = whatWillBePlayed + lastPartToPlay;
		return whatWillBePlayed;
	}
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given object is null, therefore the program cannot play the song.");
		}
	}
}
