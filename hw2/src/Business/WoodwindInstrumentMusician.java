package Business;

public class WoodwindInstrumentMusician extends Musician {

	public WoodwindInstrumentMusician() {
		super();
	}
	
	public WoodwindInstrumentMusician(Tempo tempo) {
		super(tempo);
	}
	
	WoodwindInstrumentMusician(WoodwindInstrumentMusician wim){
		this(wim.getTempo());
	}
	
	@Override
	public String playPiece(Piece piece) {
		String whatWillBePlayed = "";
		String[] parts = piece.getParts();
		whatWillBePlayed = getChorusNotes(piece);
		return whatWillBePlayed;
	}
	
	private String getChorusNotes(Piece piece) {
		String chorus = "";
	}
}
