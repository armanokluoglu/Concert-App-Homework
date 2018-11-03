package Business;

import java.util.Arrays;

public class Piece {
	private String[] parts;
	
	public Piece() {
		this.parts = new String[0];
	}
	
	public Piece(String piece) {
		this.parts = piece.split("\n");
	}
	
	Piece(Piece piece) {
		String newPiece = String.join("\n", parts);
		new Piece(newPiece);
	}

	public String[] getParts() {
		return Arrays.copyOf(parts, parts.length);
	}

	public void setParts(String[] parts) {
		this.parts = parts;
	}
}