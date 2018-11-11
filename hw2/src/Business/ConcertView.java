package View;

import java.util.ArrayList;

import Business.BellPlayer;
import Business.Celloist;
import Business.Drummer;
import Business.Flutist;
import Business.Maestro;
import Business.Orchestra;
import Business.Piece;
import Business.Violinist;
import Business.Violist;
import DAL.FileInput;
import Utilities.MusicianInterface;

public class ConcertView {

	public void startConcert() {
		
		// PART I -- INITIALIZING VARIABLES \\
		FileInput fileInput = new FileInput();
		Maestro maestro = new Maestro();
		MusicianInterface bellPlayer = new BellPlayer();
		MusicianInterface celloist = new Celloist();
		MusicianInterface drummer = new Drummer();
		MusicianInterface flutist = new Flutist();
		MusicianInterface violinist = new Violinist();
		MusicianInterface violist = new Violist();
		
		ArrayList<MusicianInterface> musiciansList = new ArrayList<MusicianInterface>();
		musiciansList.add(bellPlayer);
		musiciansList.add(celloist);
		musiciansList.add(drummer);
		musiciansList.add(flutist);
		musiciansList.add(violinist);
		musiciansList.add(violist);
		
		Orchestra orchestra = new Orchestra(musiciansList);
		Concert concert = new Concert(maestro, drummer, bellPlayer, flutist, violinist, violist, celloist);
		
		String piece1InString = fileInput.readPieceFromFile("src/piece1.txt");
		String piece2InString = fileInput.readPieceFromFile("src/piece2.txt");
		String piece3InString = fileInput.readPieceFromFile("src/piece3.txt");
		String piece4InString = fileInput.readPieceFromFile("src/piece4.txt");
		
		Piece piece1 = new Piece(piece1InString);
		Piece piece2 = new Piece(piece2InString);
		Piece piece3 = new Piece(piece3InString);
		Piece piece4 = new Piece(piece4InString);

		
		for(int index=0; index < piece1.getBeats().length; index++) {
			int totalOfBeatsInAPart = piece1.getTotalOfBeatsOfASpecifiedPart(index+1);
			maestro.setTempo(totalOfBeatsInAPart, piece1, index);
		}
		
		for(int index=0; index < piece2.getBeats().length; index++) {
			int totalOfBeatsInAPart = piece2.getTotalOfBeatsOfASpecifiedPart(index+1);
			maestro.setTempo(totalOfBeatsInAPart, piece2, index);
		}
		
		for(int index=0; index < piece3.getBeats().length; index++) {
			int totalOfBeatsInAPart = piece3.getTotalOfBeatsOfASpecifiedPart(index+1);
			maestro.setTempo(totalOfBeatsInAPart, piece3, index);
		}
		
		for(int index=0; index < piece4.getBeats().length; index++) {
			int totalOfBeatsInAPart = piece4.getTotalOfBeatsOfASpecifiedPart(index+1);
			maestro.setTempo(totalOfBeatsInAPart, piece4, index);
		}
		
		int totalBeatsInThePiece = piece1.getTotalNumberOfBeatsInAPiece();
		maestro.setChangeInTempo(totalBeatsInThePiece, piece1);
		
		totalBeatsInThePiece = piece2.getTotalNumberOfBeatsInAPiece();
		maestro.setChangeInTempo(totalBeatsInThePiece, piece2);
		
		totalBeatsInThePiece = piece3.getTotalNumberOfBeatsInAPiece();
		maestro.setChangeInTempo(totalBeatsInThePiece, piece3);
		
		totalBeatsInThePiece = piece4.getTotalNumberOfBeatsInAPiece();
		maestro.setChangeInTempo(totalBeatsInThePiece, piece4);
		
		//PART II -- PLAYING THE PIECES \\
		
		//Playing the first piece....
		bellPlayer.playPiece(piece1);
		celloist.playPiece(piece1);
		drummer.playPiece(piece1);
		flutist.playPiece(piece1);
		violinist.playPiece(piece1);
		violist.playPiece(piece1);
		
		//Playing the second piece....
		bellPlayer.playPiece(piece2);
		celloist.playPiece(piece2);
		drummer.playPiece(piece2);
		flutist.playPiece(piece2);
		violinist.playPiece(piece2);
		violist.playPiece(piece2);
		
		//Playing the third piece....
		bellPlayer.playPiece(piece3);
		celloist.playPiece(piece3);
		drummer.playPiece(piece3);
		flutist.playPiece(piece3);
		violinist.playPiece(piece3);
		violist.playPiece(piece3);
		
		//Playing the last piece....
		bellPlayer.playPiece(piece4);
		celloist.playPiece(piece4);
		drummer.playPiece(piece4);
		flutist.playPiece(piece4);
		violinist.playPiece(piece4);
		violist.playPiece(piece4);
	}
}
