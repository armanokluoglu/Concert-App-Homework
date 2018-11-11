package Business;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.StringTokenizer;

import Utilities.ChangeInTempo;
import Utilities.Tempo;

public class Piece {
	
	private String[] parts;
	private Tempo[] tempo;
	private ChangeInTempo changeInTempo;
	private boolean isInitialized = false;
	
	public Piece() {
		this.parts = new String[0];
		isInitialized = true;
	}
	
	public Piece(String piece) {
		checkIfNull(piece);
		this.parts = piece.split("\n");
		isInitialized = true;
	}
	
	Piece(Piece piece) {
		this(String.join("\n", piece.getParts()));
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

	public int[][] getBeats(){
		checkInitialization();
		int[][] beats = new int[parts.length][];
		int beatIndex = 0;
		int partIndex = 0;
		for(String part : parts) {
			StringTokenizer st = new StringTokenizer(part, " ");
			String nextNote = ""; 
			while(st.hasMoreTokens()) {
				int nextBeat = 0;
				String beatInString = "";
				nextNote = st.nextToken();
				for(int index=1; index < nextNote.length(); index++) {
					beatInString += nextNote.charAt(index);
				}
				nextBeat = Integer.parseInt(beatInString);
				beats[partIndex][beatIndex] = nextBeat;
				partIndex++;
				beatIndex++;
			}
		}
		return beats;
	}
	
	public int getTotalNumberOfBeatsInAPiece() {
		checkInitialization();
		int totalOfBeats = 0;
		int[][] beats = getBeats();
		for(int partIndex=0; partIndex < beats.length; partIndex++) {
			for(int beatIndex=0; beatIndex < beats[partIndex].length; beatIndex++) {
				totalOfBeats += beats[partIndex][beatIndex];
			}
		}
		return totalOfBeats;
	}

	
	public int getTotalOfBeatsOfASpecifiedPart(int partNo) {
		checkInitialization();
		if(partNo <= 0) {
			throw new IllegalArgumentException("Given part no is either zero or less.");
		}
		int partIndex = partNo-1;
		int totalOfBeats = 0;
		int[][] beats = getBeats();
		for(int beatIndex=0; beatIndex < beats[partIndex].length; beatIndex++) {
			totalOfBeats += beats[partIndex][beatIndex];
		}
		return totalOfBeats;
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