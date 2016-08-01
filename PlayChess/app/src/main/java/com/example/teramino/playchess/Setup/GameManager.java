package com.example.teramino.playchess.Setup;

import com.example.teramino.playchess.Pieces.*;
import com.example.teramino.playchess.Player;

public class GameManager {
	private static GameManager instance;
	private String playerColor;
	private boolean playerTurn = true;
	private boolean moveConfirm = true;
	private boolean gameInProgress = true;
	private boolean pawnFirstMove = true;
	private boolean processingKing = false;
	private boolean kingCheck = false;
	private boolean castling = false;
	private boolean kingHasMoved = false;
	private boolean pawnHasMoved = false;
	private boolean rookHasMoved = false;
	private boolean mate = false;

	private Piece pawn = null;
	private Piece king = null;
	private Piece rook = null;
	private int oldCol;
	private int oldRow;
	public boolean OPPChecked = false;


	public static GameManager getInstance() {
		if (instance == null) {
			instance = new GameManager();
		}
		return instance;
	}

	private GameManager() {}

	public void endTurn() {
		setMoveConfirm();
		setPlayerTurn();
	}

	public void setMoveConfirm() {
		// sets moveConfirm to true so that next player may move
		if (moveConfirm == true) {
			moveConfirm = false;
		} else
			moveConfirm = true;
	}

	// sets and resets whose turn it is to move
	public void setPlayerTurn() {
		if (playerTurn == false) {
			playerTurn = true;
		} else if (playerTurn == true) {
			playerTurn = false;
		}
	}

	public String getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(String playerColor) {
		this.playerColor = playerColor;
	}

	boolean pawnMoved(boolean b) {
		if (b == true) {
			pawnFirstMove = false;
			b = false;
		} else {
			pawnFirstMove = true;
			b = true;
		}
		return b;
	}

	// returns whose move it is
	public boolean getPlayerTurn() {
		return playerTurn;
	}

	// returns moveConfirm
	public boolean getMoveConfirm() {
		return moveConfirm;
	}

	// Moved this into GameManager because it didnt feel like it should be in Chess Client
	public boolean getGameInProgress() {
		return gameInProgress;
	}

	boolean getPawnFirstMove() {
		return pawnFirstMove;
	}

	public boolean ifKingMovedStillChecked(Piece[] p, Square[][] s, int kingRow, int kingCol) {
		processingKing = true;

		System.out.println("If King moved check?");
		for (int i = 0; i < p.length; i++) {
			if (p[i].isDestroyed() == false) {

				Square ss = p[i].canMove(p[i], s, kingCol, kingRow);

				if (ss != null)
					return true;
				else if (i == p.length)
					return false;
			}
		}
		System.out.println("Out of loop");
		System.out.println("============");
		return false;
	}



	public boolean isKingChecked(Piece [] p, Piece king,  Square [][] s, int kingRow, int kingCol) {
		processingKing = true;

		System.out.println("*********************");
		System.out.println("King in check?");
		for(int i=0; i<p.length;i++)
		{
			if (p[i].isDestroyed() == false)
			{

				Square ss = p[i].canMove( p[i], s, kingCol, kingRow);

				if(ss != null)
				{ // if code gets in here a piece is potentially can attack King
					Square blockSquare = null;
					// relative to the king is there a piece directly in front to block
					// taking a case by case scenario to validate king is in check
					// checking to see if king can move in one spot in any directiong
					// will determing if there is a piece to block the king from being in check

					// same row
					if (p[i].getRow() == kingRow){
						// check to see if the king is getting checked from the left or right
						int kingCheckMove;
						if (ss.getCol() > kingCol)
							// checks square to the right of king
							kingCheckMove = kingCol+1;
						else
							// checks square to the left of king
							kingCheckMove = kingCol-1;

						blockSquare = king.canMove( king, s, kingCheckMove, kingRow);
					}
					// same column
					else if(p[i].getCol() == kingCol){
						// this check can get complicated.
						// King could be in check in multiple spots
						// which would require to now allow that spot to be proccessed
						// maybe using different booleans to confirm a spot is in check for King could work
						// this chunck of comment actually doesnt apply to this scenario but it doesnt present
						// an issue that could arise if there wasnt a piece to block for the king

						int kingCheckMove;
						if (p[i].getRow() > kingRow)
							// checks square to the right of king
							kingCheckMove = kingRow+1;
						else
							// checks square to the left of king
							kingCheckMove = kingRow-1;

						blockSquare = king.canMove( king, s, kingCol, kingCheckMove);

					}
					// diag down left
					else if(p[i].getRow() < kingRow && p[i].getCol() < kingCol){
						int kingCheckMoveRow = kingRow - 1;
						int kingCheckMoveCol = kingCol - 1;

						blockSquare = king.canMove( king, s, kingCheckMoveCol, kingCheckMoveRow);

					}
					// diag down right
					else if(p[i].getRow() < kingRow && p[i].getCol() > kingCol){
						int kingCheckMoveRow = kingRow - 1;
						int kingCheckMoveCol = kingCol + 1;

						blockSquare = king.canMove( king, s, kingCheckMoveCol, kingCheckMoveRow);

					}
					// diag up left
					else if(p[i].getRow() > kingRow && p[i].getCol() < kingCol){
						int kingCheckMoveRow = kingRow + 1;
						int kingCheckMoveCol = kingCol - 1;

						blockSquare = king.canMove( king, s, kingCheckMoveCol, kingCheckMoveRow);

					}
					// diag up right
					else if(p[i].getRow() > kingRow && p[i].getCol() > kingCol){
						int kingCheckMoveRow = kingRow + 1;
						int kingCheckMoveCol = kingCol + 1;

						blockSquare = king.canMove( king, s, kingCheckMoveCol, kingCheckMoveRow);

					}
					if (blockSquare != null) {

						System.out.println(king.getName() + " Check\n");
						System.out.println(p[i].getName() + " can attack " + king.getName() + "\n");
						processingKing = false;
						System.out.println("*********************");
						return true;
					}
					else
						System.out.println("A piece is blocking check!");
				}
				else if (i == p.length - 1)
				{
					System.out.println(king.getName() +" Not check\n");
					System.out.println("*********************");
					processingKing = false;
					return false;
				}

			}
		}
		System.out.println("====================");
		return false;
	}

	public boolean isMate() {
		return mate;
	}

	public void setMate(boolean mate) {
		this.mate = mate;
	}

	public boolean isMated(Piece[] p, King king, Square[][] s, int kingCol, int kingRow, int checkedCol, int checkedRow) {
		processingKing = true;

		System.out.println("Can a piece Block check?");
		for(int i=0; i<p.length;i++)
		{
			if (p[i].isDestroyed() == false) {

				Square ss = p[i].canMove(p[i], s, checkedCol, checkedRow);
				if (ss != null) {
					System.out.println(p[i].getName() + " can attack ");
					System.out.println("====================");
					return false;
				}
				if (king.isUpCheck() && king.isDownCheck() && king.isLeftCheck() && king.isRightCheck() && king.isDownLeftCheck() && king.isDownRightCheck()
						&& king.isUpLeftCheck() && king.isUpRightCheck()) {

					System.out.println(king.getName() + " is Mated");
					System.out.println("====================");
					processingKing = false;
					return true;
				}
			}
		}
		System.out.println("====================");
		return false;

	}

	public boolean isProcessingKing() {
		return processingKing;
	}

	public void setProcessingKing(boolean processingKing) {
		this.processingKing = processingKing;
	}

	public boolean getKingCheck() {
		return kingCheck;
	}

	public void setKingCheck(boolean kingCheck) {
		this.kingCheck = kingCheck;
	}

	public boolean isCastling() {
		return castling;
	}

	public void setCastling(boolean castling) {
		this.castling = castling;
	}

	public void setKingMoved(boolean kingMoved, King k)
	{
		if (isKingHasMoved() == false)
			k.setKingMoved(kingMoved);
	}


	public void setPawnMoved(boolean pawnMoved, Pawn p)
	{
		if (isPawnHasMoved() == false)
			p.setPawnMoved(pawnMoved);
	}

	public Piece getRook() {
		return rook;
	}

	public void setRook(Piece rook) {
		this.rook = rook;

		// find a new way to keep track of Rooks old position
		// for use of cancel move
//		oldRow = rook.getX();
//		oldCol = rook.getY();
	}

	public int getOldRow() {
		return oldRow;
	}

	public void setOldRow(int oldRow) {
		this.oldRow = oldRow;
	}

	public int getOldCol() {
		return oldCol;
	}

	public void setOldCol(int oldCol) {
		this.oldCol = oldCol;
	}

	public void setRookMoved(boolean rookMoved, Rook r)
	{
		if (isRookHasMoved() == false)
			r.setRookMoved(rookMoved);
	}

	public boolean isPawnHasMoved() {
		return pawnHasMoved;
	}

	public void setPawnHasMoved(boolean pawnHasMoved) {
		this.pawnHasMoved = pawnHasMoved;
	}

	public boolean isRookHasMoved() {
		return rookHasMoved;
	}

	public void setRookHasMoved(boolean rookHasMoved) {
		this.rookHasMoved = rookHasMoved;
	}

	public boolean isKingHasMoved() {
		return kingHasMoved;
	}

	public void setKingHasMoved(boolean kingHasMoved) {
		this.kingHasMoved = kingHasMoved;
	}
}
