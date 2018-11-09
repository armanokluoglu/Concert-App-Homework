package Business;

import java.util.ArrayList;

public class Orchestra {

	private ArrayList<Musician> musiciansOrchestra;
	private int numberOfMusicians;
	private boolean isInitialized = false;
	
	public Orchestra(ArrayList<Musician> musiciansOrchestra) {
		checkIfNull(musiciansOrchestra);
		this.musiciansOrchestra = musiciansOrchestra;
		numberOfMusicians = musiciansOrchestra.size();
		isInitialized = true;
	}
	
	public Orchestra() {
		musiciansOrchestra = new ArrayList<Musician>();
		numberOfMusicians = 0;
		isInitialized = true;
	}

	public ArrayList<Musician> getMusiciansOrchestra() {
		checkInitialization();
		return musiciansOrchestra;
	}

	public int getNumberOfMusicians() {
		checkInitialization();
		return numberOfMusicians;
	}

	public void setMusiciansOrchestra(ArrayList<Musician> musiciansOrchestra) {
		checkInitialization();
		checkIfNull(musiciansOrchestra);
		this.musiciansOrchestra = musiciansOrchestra;
	}

	public void setNumberOfMusicians(int numberOfMusicians) {
		checkInitialization();
		if((numberOfMusicians < 0)) {
			throw new IllegalArgumentException("Given number of musicians cannot be negative.");
		}
		this.numberOfMusicians = numberOfMusicians;
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Orchestra object was not created properly.");
		}
	}
	
	private void checkIfNull(ArrayList<Musician> musiciansOrchestra) {
		if(musiciansOrchestra == null) {
			throw new IllegalArgumentException("Given orchestra object is null, therefore cannot be processed.");
		}
	}
	
}
