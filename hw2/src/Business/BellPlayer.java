package Business;

import Utilities.ChangeInTempo;
import Utilities.MusicianInterface;
import Utilities.Tempo;

public class BellPlayer extends PercussionInstrumentMusician {

	private int partCounter = 1;
	private boolean isInitialized = false;
	
	public BellPlayer() {
		isInitialized = true;
	}
	
	public BellPlayer(MusicianInterface bellPlayer) {
		this();
	}

	@Override
	public String playPiece(Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		Tempo[] tempos = piece.getTempo();
		String[] parts = piece.getParts();
		String output = "";
		if((tempos[partCounter-1] == Tempo.grave) && (piece.getChangeInTempo() == ChangeInTempo.stretto)) {
			output = "Bell is played: \n";
			output += "Part " + partCounter + " ";
			output += parts[partCounter-1].replaceAll("^[\\.\\d]+", "");
			output += " " + tempos[partCounter-1];
			output = output.replaceAll("[CDEH]", "X");
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
			throw new IllegalStateException("Given bellplayer object was not created proeprly.");
		}
	}
	
	private void checkIfNull(Piece piece) {
		if(piece == null)
			throw new IllegalArgumentException("Given piece object is null.");
	}
}
