package Business;

public class Maestro {

	private boolean isInitialized = false;
	
	public Maestro() {
		isInitialized = true;
	}
	
	public void setTempo(int numberOfBeatsInAPart, Piece piece, int partOfPiece) {
		if((numberOfBeatsInAPart <= 0) || (partOfPiece <= 0) || (partOfPiece > piece.getTempo().length)) {
			throw new IllegalArgumentException("Either part of piece or number of beats in a part is invalid.");
		}
		checkInitialization();
		checkIfNull(piece);
		Tempo newTempo = null;
			if((numberOfBeatsInAPart > 0) && (numberOfBeatsInAPart < 8)) {
				newTempo = Tempo.prestissimo;
			}
			else if((numberOfBeatsInAPart >= 8) && (numberOfBeatsInAPart < 16)) {
				newTempo = Tempo.vivace;
			}
				
			else if((numberOfBeatsInAPart >= 16) && (numberOfBeatsInAPart < 18)) {
				newTempo = Tempo.allegretto;
			}
			
			else if((numberOfBeatsInAPart >= 18) && (numberOfBeatsInAPart < 22)) {
				newTempo = Tempo.moderato;
			}
			
			else if((numberOfBeatsInAPart >= 22) && (numberOfBeatsInAPart < 23)) {
				newTempo = Tempo.adagietto;
			}
			
			else if((numberOfBeatsInAPart >= 23) && (numberOfBeatsInAPart < 24)) {
				newTempo = Tempo.andante;
			}
			
			else if((numberOfBeatsInAPart >= 24) && (numberOfBeatsInAPart < 27)) {
				newTempo = Tempo.larghetto;
			}
		
			else if((numberOfBeatsInAPart >= 27) && (numberOfBeatsInAPart < 29)) {
				newTempo = Tempo.lento;
			}
		
			else if((numberOfBeatsInAPart >= 29) && (numberOfBeatsInAPart < 33)) {
				newTempo = Tempo.grave;
			}
			
			else if((numberOfBeatsInAPart >= 33) && (numberOfBeatsInAPart < 37)) {
				newTempo = Tempo.larghissimo;
			}
			
			else {
				throw new IllegalArgumentException("Given number of beats is invalid, therefore it cannot be set.");
			}
			setTempoOfPieceAs(newTempo, piece, partOfPiece);
	}
	
	
	public void setChangeInTempo(int numberOfBeatsInAPart, Piece piece) {
		checkInitialization();
		checkIfNull(piece);
		if(numberOfBeatsInAPart <= 0) {
			throw new IllegalArgumentException("Given number of beats is invalid, therefore it cannot be set.");
		}
		ChangeInTempo newChangeInTempo = null;
		if(numberOfBeatsInAPart < 83) {
			newChangeInTempo = ChangeInTempo.lentando;
			
		}else if((numberOfBeatsInAPart < 125) && (numberOfBeatsInAPart >= 83)) {
			newChangeInTempo = ChangeInTempo.ritenuto;
			
		}else if((numberOfBeatsInAPart < 132) && (numberOfBeatsInAPart >= 125)) {
			newChangeInTempo = ChangeInTempo.stretto;
			
		}else if((numberOfBeatsInAPart < 152) && (numberOfBeatsInAPart >= 132)) {
			newChangeInTempo = ChangeInTempo.accelerando;
			
		}else {
			throw new IllegalArgumentException("Given number of beats is invalid, therefore it cannot be set.");
		}
		
		setChangeInTempoAs(newChangeInTempo, piece);
	}

	
	private void setTempoOfPieceAs(Tempo aTempo, Piece piece, int partOfPiece) {
		checkIfNull(piece);
		checkInitialization();
		piece.setTempoOfPart(aTempo, partOfPiece);
		
	}
	
	private void setChangeInTempoAs(ChangeInTempo changeInTempo, Piece piece) {
		checkIfNull(piece);
		checkInitialization();
		piece.setChangeInTempo(changeInTempo);
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Maestro object was not created properly.");
		}
	}
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given argument is null.");
		}
	}
}
