package DAL;

public class FileInput {

	private TxtReader txtReader;
	private boolean isInitialized = false;
	
	public FileInput() {
		this.txtReader = new TxtReader();
		isInitialized = true;
	}
	
	public String readPieceFromFile(String fileDirectory) {
		checkInitialization();
		return txtReader.readFromTxtFile(fileDirectory);
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalArgumentException("Given file input object was not created properly.");
		}
	}
}
