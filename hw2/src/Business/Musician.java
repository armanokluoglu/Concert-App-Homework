package Business;

public class Musician implements MusicianInterface {
	private Tempo tempo;
	private ChangeInTempo changeInTempo;
	private boolean isInitialized = false;
	
	public Musician() {
		tempo = null;
		changeInTempo = null;
		isInitialized = true;
	}
	
	public Musician(Tempo tempo) {
		setTempo(tempo);
		isInitialized = true;
	}
	
	public Tempo getTempo() {
		checkInitialization();
		return tempo;
	}

	public void setTempo(Tempo tempo) {
		checkIfNull(tempo);
		checkTempo(tempo);
		this.tempo = tempo;
	}

	public ChangeInTempo getChangeInTempo() {
		checkInitialization();
		return changeInTempo;
	}

	public void setChangeInTempo(ChangeInTempo changeInTempo) {
		checkIfNull(changeInTempo);
		checkChangeInTempo(changeInTempo);
		this.changeInTempo = changeInTempo;
	}
	
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		String output = "";
		String[] parts = piece.getParts();
		int partIndex = 1;
		for(String part: parts) {
			String line = part.replaceAll("^[\\.\\d]+", "");
			output = output + "Part " + partIndex + ": " + line;
		}
		return output;
	}
	
	private void checkTempo(Tempo tempo) {
		for(Tempo tempoEnum: Tempo.values()) {
			if(tempo == tempoEnum) {
				return;
			}
		}
		throw new IllegalArgumentException("Given tempo is not valid.");
	}
	
	private void checkChangeInTempo(ChangeInTempo changeInTempo) {
		for(ChangeInTempo tempoEnum: ChangeInTempo.values()) {
			if(changeInTempo == tempoEnum) {
				return;
			}
		}
		throw new IllegalArgumentException("Given change in tempo is not valid.");
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given musician object was not created properly.");
		}
	}
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given object is null, therefore the program cannot play the song.");
		}
	}
}
