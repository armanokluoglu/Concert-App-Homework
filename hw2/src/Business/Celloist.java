package Business;

import Utilities.MusicianInterface;
import Utilities.Tempo;

public class Celloist extends StringInstrumentMusician {

	private int partCounter = 1;
	private boolean isInitialized = false;
	
	public Celloist() {
		isInitialized = true;
	}
	
	public Celloist(MusicianInterface celloist) {
		this();
	}

	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		Tempo[] tempos = piece.getTempo();
		String[] parts = piece.getParts();
		String output = "";
		output = "Cello is played: \n";
		output += "Part " + partCounter + " ";
		output += parts[partCounter-1].replaceAll("^[\\.\\d]+", "");
		output += " " + tempos[partCounter-1];
		if(partCounter == parts.length) {
			partCounter = 1;
		} else {
			partCounter++;
		}
		return output;
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given celloist object was not created properly.");
		}
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null) {
			throw new IllegalArgumentException("Given piece object was null, therefore cannot be played.");
		}
	}
}
