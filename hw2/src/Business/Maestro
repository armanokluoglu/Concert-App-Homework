package Business;

public class Maestro {

	private Orchestra musicians;
	private final boolean isInitialized;
	
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
		switch(numberOfBeatsInAPart) {
			case 1 : case 2 : case 3 : case 4 : case 5 : case 6 : case 7 :
				newTempo = Tempo.prestissimo;
				break;
				
			case 8: case 9: case 10: case 11: case 12: case 13: case 14: case 15:
				newTempo = Tempo.vivace;
				break;
				
			case 16: case 17:
				newTempo = Tempo.allegretto;
				break;
				
			case 18: case 19: case 20: case 21:
				newTempo = Tempo.moderato;
				break;
				
			case 22: 
				newTempo = Tempo.adagietto;
				break;
			
			case 23:
				newTempo = Tempo.andante;
				break;
			
			case 24: case 25: case 26:
				newTempo = Tempo.larghetto;
				break;
			
			case 27: case 28:
				newTempo = Tempo.lento;
				break;
			
			case 29: case 30: case 31: case 32:
				newTempo = Tempo.grave;
				break;
				
			case 33: case 34: case 35: case 36:
				newTempo = Tempo.larghissimo;
				break;
			
			default:
				throw new IllegalArgumentException("Number of beats does not match with any tempo.");
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
