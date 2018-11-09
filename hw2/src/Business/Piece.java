package Business;

import java.util.ArrayList;
import java.util.Arrays;

public class Piece {
	
	private String[] parts;
	private Tempo[] tempo;
	private ChangeInTempo changeInTempo;
	private boolean isInitialized = false;
	
	public Piece() {
		this.parts = new String[0];
		isInitialized = true;
	}
	
	public Piece(String piece, Tempo[] tempo, ChangeInTempo changeInTempo) {
		checkIfNull(piece);
		checkIfNull(tempo);
		checkIfNull(changeInTempo);
		this.parts = piece.split("\n");
		setTempo(tempo);
		setChangeInTempo(changeInTempo);
		isInitialized = true;
	}
	
	Piece(Piece piece) {
		this(String.join("\n", piece.getParts()), piece.getTempo(), piece.getChangeInTempo());
	}

	public Tempo[] getTempo() {
		checkInitialization();
		return Arrays.copyOf(tempo, tempo.length);
	}
	
	public ArrayList<String> getChorus() {
		checkInitialization();
		String[] parts = getParts();
		ArrayList<String> chorus = new ArrayList<String>();
		for (int j=0;j<parts.length;j++) {
			for (int k=j+1;k<parts.length;k++) {
				if (k!=j && parts[k] == parts[j]) {	
					chorus.add(parts[k]);
				}
			}
		}
		return chorus;
	}

	public ChangeInTempo getChangeInTempo() {
		checkInitialization();
		return changeInTempo;
	}

	public void setTempo(Tempo[] tempo) {
		checkIfNull(tempo);
		checkTempo(tempo);
		this.tempo = tempo;
	}
	
	public void setTempoOfPart(Tempo tempo, int partOfPiece) {
		checkIfNull(tempo);
		checkInitialization();
		this.tempo[partOfPiece] = tempo;
	}

	public void setChangeInTempo(ChangeInTempo changeInTempo) {
		checkInitialization();
		checkIfNull(changeInTempo);
		checkChangeInTempo(changeInTempo);
		this.changeInTempo = changeInTempo;
	}


	public String[] getParts() {
		checkInitialization();
		return Arrays.copyOf(parts, parts.length);
	}

	public void setParts(String[] parts) {
		checkInitialization();
		checkIfNull(parts);
		this.parts = parts;
	}
	
	private void checkTempo(Tempo[] tempo) {
		for(Tempo nextTempo : tempo) {
			for(Tempo tempoEnum: Tempo.values()) {
				if(nextTempo == tempoEnum) {
					break;
				}else if(tempoEnum == Tempo.values()[Tempo.values().length-1]) {
					throw new IllegalArgumentException("Given tempo is invalid.");
				}
			}
		}
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
			throw new IllegalStateException("Given piece object was not created properly.");
		}
	}
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given piece argument is null, therefore cannot be played.");
		}
	}
}