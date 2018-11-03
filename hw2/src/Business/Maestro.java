package Business;

public class Maestro {

	private Orchestra musicians;
	private boolean isInitialized = false;
	
	public Maestro(Orchestra musicians) {
		if(musicians == null) {
			throw new IllegalArgumentException("Given orchestra object argument is null.");
		}
		this.musicians = musicians;
		isInitialized = true;
	}
	
	public void setTempo(int numberOfBeatsInAPart) {
		if(numberOfBeatsInAPart <= 0) {
			throw new IllegalArgumentException("Given number of beats is illegal, therefore cannot be set.");
		}
		checkInitialization();
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
				throw new IllegalArgumentException("Given number of beats is illegal, therefore it cannot be set.");
			}
			setTempoAs(newTempo);
	}
	
	
	public void setChangeInTempo(int numberOfBeatsInAPiece) {
		checkInitialization();
		if(numberOfBeatsInAPiece <= 0) {
			throw new IllegalArgumentException("Given number of beats is illegal, therefore it cannot be set.");
		}
		ChangeInTempo newChangeInTempo = null;
		if(numberOfBeatsInAPiece < 83) {
			newChangeInTempo = ChangeInTempo.lentando;
			
		}else if((numberOfBeatsInAPiece < 125) && (numberOfBeatsInAPiece >= 83)) {
			newChangeInTempo = ChangeInTempo.ritenuto;
			
		}else if((numberOfBeatsInAPiece < 132) && (numberOfBeatsInAPiece >= 125)) {
			newChangeInTempo = ChangeInTempo.stretto;
			
		}else if((numberOfBeatsInAPiece < 152) && (numberOfBeatsInAPiece >= 132)) {
			newChangeInTempo = ChangeInTempo.accelerando;
			
		}else {
			throw new IllegalArgumentException("Given number of beats is illegal, therefore it cannot be set.");
		}
		
		setChangeInTempoAs(newChangeInTempo);
	}

	
	private void setTempoAs(Tempo aTempo) {
		for(Musician musician : musicians.getMusiciansOrchestra()) {
			musician.setTempo(aTempo);
		}
	}
	
	private void setChangeInTempoAs(ChangeInTempo changeInTempo) {
		for(Musician musician : musicians.getMusiciansOrchestra()) {
			musician.setChangeInTempo(changeInTempo);
		}
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Maestro object was not created properly.");
		}
	}
}
