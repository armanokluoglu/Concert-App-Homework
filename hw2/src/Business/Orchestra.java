package Business;

import java.util.ArrayList;

import Utilities.MusicianInterface;

public class Orchestra {

	private ArrayList<MusicianInterface> musiciansOrchestra;
	private int numberOfMusicians;
	private boolean isInitialized = false;
	
	public Orchestra(ArrayList<MusicianInterface> musiciansOrchestra) {
		checkIfNull(musiciansOrchestra);
		this.musiciansOrchestra = musiciansOrchestra;
		numberOfMusicians = musiciansOrchestra.size();
		isInitialized = true;
	}
	
	public Orchestra() {
		musiciansOrchestra = new ArrayList<MusicianInterface>();
		numberOfMusicians = 0;
		isInitialized = true;
	}

	public ArrayList<MusicianInterface> getMusiciansOrchestra() {
		checkInitialization();
		return musiciansOrchestra;
	}

	public int getNumberOfMusicians() {
		checkInitialization();
		return numberOfMusicians;
	}

	public void setMusiciansOrchestra(ArrayList<MusicianInterface> musiciansOrchestra) {
		checkInitialization();
		checkIfNull(musiciansOrchestra);
		this.musiciansOrchestra = musiciansOrchestra;
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Orchestra object was not created properly.");
		}
	}
	
	private void checkIfNull(ArrayList<MusicianInterface> musiciansOrchestra) {
		if(musiciansOrchestra == null) {
			throw new IllegalArgumentException("Given orchestra object is null, therefore cannot be processed.");
		}
	}
	
}
