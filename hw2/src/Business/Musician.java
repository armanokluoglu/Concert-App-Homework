package Business;

public class Musician implements MusicianInterface {
	private String tempo;
	private String changeInTempo;
	
	public Musician() {
		this.tempo = "No tempo";
		this.changeInTempo = "No change in tempo.";
	}
	
	public Musician(String tempo) {
		setTempo(tempo);
	}
	
	public String getTempo() {
		return tempo;
	}

	public void setTempo(String tempo) {
		checkTempo(tempo);
		this.tempo = tempo;
	}

	public String getChangeInTempo() {
		return changeInTempo;
	}

	public void setChangeInTempo(String changeInTempo) {
		checkChangeInTempo(changeInTempo);
		this.changeInTempo = changeInTempo;
	}

	private void checkTempo(String tempo) {
		for(Tempo tempoEnum: Tempo.values()) {
			if(Tempo.valueOf(tempo) == tempoEnum) {
				return;
			}
		}
		throw new IllegalArgumentException("Given tempo is not valid.");
	}
	
	private void checkChangeInTempo(String changeInTempo) {
		for(ChangeInTempo tempoEnum: ChangeInTempo.values()) {
			if(ChangeInTempo.valueOf(tempo) == tempoEnum) {
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