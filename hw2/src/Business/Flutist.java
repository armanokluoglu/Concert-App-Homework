package Business;

import java.util.ArrayList;

public class Flutist extends WoodwindInstrumentMusician {

	private int partCounter = 1;
	private boolean isInitialized = false;
	
	public Flutist() {
		isInitialized = true;
	}
	
	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		Tempo[] tempos = piece.getTempo();
		String[] parts = piece.getParts();
		ArrayList<String> chorusParts = piece.getChorus();
		String output;
		if(chorusParts.contains(parts[partCounter-1])) {
			output = "Flute is played: \n";
			output += "Part " + partCounter + ": ";
			output += parts[partCounter-1].replaceAll("^[\\.\\d]+", "");
			output += " " + tempos[partCounter-1];
		} else {
			output = "";
		}
		if(partCounter == parts.length) {
			partCounter = 1;
		} else {
			partCounter++;
		}
		return output;
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalArgumentException("Given flutist object was not created properly.");
		}
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null)
			throw new IllegalArgumentException("Given piece object is null.");
	}
}
