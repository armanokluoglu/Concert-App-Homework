package Business;

import java.util.Arrays;

public class Piece {
	
	private String[] parts;
	private boolean isInitialized = false;
	
	public Piece() {
		this.parts = new String[0];
		isInitialized = true;
	}
	
	public Piece(String piece) {
		checkIfNull(piece);
		this.parts = piece.split("\n");
		isInitialized = true;
	}
	
	Piece(Piece piece) {
		this(String.join("\n", piece.getParts()));
	}

	public String[] getParts() {
		checkInitialization();
		return Arrays.copyOf(parts, parts.length);
	}

	public void setParts(String[] parts) {
		checkInitialization();
		checkIfNull(parts);
		this.parts = parts;
	}
	
	private void checkInitialization() {
		if(!isInitialized) {
			throw new IllegalStateException("Given piece object was not created properly.");
		}
	}
	
	private void checkIfNull(Object object) {
		if(object == null) {
			throw new IllegalArgumentException("Given piece argument is null, therefore cannot be played.");
		}
	}
}
