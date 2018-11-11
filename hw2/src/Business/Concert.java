package View;
import Business.BellPlayer;
import Business.Celloist;
import Business.Drummer;
import Business.Flutist;
import Business.Maestro;
import Business.PercussionInstrumentMusician;
import Business.StringInstrumentMusician;
import Business.Violinist;
import Business.Violist;
import Business.WoodwindInstrumentMusician;
import Utilities.MusicianInterface;

public class Concert {

	private Maestro maestro;
	private MusicianInterface drummer;
	private MusicianInterface bellPlayer;
	private MusicianInterface flutist;
	private MusicianInterface violinist;
	private MusicianInterface violist;
	private MusicianInterface celloist;
	private boolean isInitialized = false;
	
	
	public Concert(Maestro maestro, MusicianInterface drummer, MusicianInterface bellPlayer,
			MusicianInterface flutist, MusicianInterface violinist, MusicianInterface violist,
			MusicianInterface celloist) {
		super();
		this.maestro = maestro;
		this.drummer = drummer;
		this.bellPlayer = bellPlayer;
		this.flutist = flutist;
		this.violinist = violinist;
		this.violist = violist;
		this.celloist = celloist;
		this.isInitialized = true;
	}
	
	
	public Maestro getMaestro() {
		checkInitialization();
		return new Maestro(maestro);
	}

	public MusicianInterface getDrummer() {
		checkInitialization();
		return new Drummer(drummer);
	}

	public MusicianInterface getBellPlayer() {
		checkInitialization();
		return new BellPlayer(bellPlayer);
	}

	public MusicianInterface getFlutist() {
		checkInitialization();
		return new Flutist(flutist);
	}

	public MusicianInterface getViolinist() {
		checkInitialization();
		return new Violinist(violinist);
	}

	public MusicianInterface getViolist() {
		checkInitialization();
		return new Violist(violist);
	}

	public MusicianInterface getCelloist() {
		checkInitialization();
		return new Celloist(celloist);
	}

	public void setMaestro(Maestro maestro) {
		checkInitialization();
		checkIfNull(maestro);
		this.maestro = maestro;
	}

	public void setDrummer(PercussionInstrumentMusician drummer) {
		checkInitialization();
		checkIfNull(drummer);
		this.drummer = drummer;
	}

	public void setBellPlayer(PercussionInstrumentMusician bellPlayer) {
		checkInitialization();
		checkIfNull(bellPlayer);
		this.bellPlayer = bellPlayer;
	}

	public void setFlutist(WoodwindInstrumentMusician flutist) {
		checkInitialization();
		checkIfNull(flutist);
		this.flutist = flutist;
	}

	public void setViolinist(StringInstrumentMusician violinist) {
		checkInitialization();
		checkIfNull(violinist);
		this.violinist = violinist;
	}

	public void setViolist(StringInstrumentMusician violist) {
		checkInitialization();
		checkIfNull(violist);
		this.violist = violist;
	}

	public void setCelloist(StringInstrumentMusician celloist) {
		checkInitialization();
		checkIfNull(celloist);
		this.celloist = celloist;
	}
	
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given object is null.");
		}
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given concert object is not created properly.");
		}
	}
}
