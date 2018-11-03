package Business;

public class Musician implements MusicianInterface {
	private Tempo tempo;
	private ChangeInTempo changeInTempo;
	
	public Musician() {
		this.tempo = null;
		this.changeInTempo = null;
	}
	
	public Musician(Tempo tempo) {
		setTempo(tempo);
	}
	
	public Tempo getTempo() {
		return tempo;
	}

	public void setTempo(Tempo tempo) {
		checkTempo(tempo);
		this.tempo = tempo;
	}

	public ChangeInTempo getChangeInTempo() {
		return changeInTempo;
	}

	public void setChangeInTempo(ChangeInTempo changeInTempo) {
		checkChangeInTempo(changeInTempo);
		this.changeInTempo = changeInTempo;
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
	
	public String playPiece(String piece) {
		String[] parts = piece.split("\n");
		int partAmount = parts.length;
		
		return piece;
	}
}