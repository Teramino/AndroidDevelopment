package com.example.teramino.playchess.Setup;

import com.example.teramino.playchess.Pieces.*;

public class GameManager
{
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

	private Piece pawn = null;
	private Piece king = null;
	private Piece rook = null;
	private int oldCol;
	private int oldRow;
	

	public static GameManager getInstance()
	{
		if(instance == null)
		{
			instance = new GameManager();
		}
		return instance;
	}

	private GameManager() {}

	public void endTurn()
	{
		setMoveConfirm();
		setPlayerTurn();
	}
	public void setMoveConfirm()
	{
		// sets moveConfirm to true so that next player may move
		if(moveConfirm == true)
		{			
			moveConfirm = false;
		}
		else
			moveConfirm = true;
	}

	// sets and resets whose turn it is to move
	public void setPlayerTurn()
	{
		if(playerTurn == false)
		{			
			playerTurn = true;
		}
		else if (playerTurn == true)
		{
			playerTurn = false;
		}
	}

	public String getPlayerColor() {
		return playerColor;
	}

	public void setPlayerColor(String playerColor) {
		this.playerColor = playerColor;
	}

	boolean pawnMoved(boolean b)
	{
		if(b == true)
		{			
			pawnFirstMove = false;
			b = false;
		}
		else
		{
			pawnFirstMove = true;
			b = true;
		}
		return b;
	}

	// returns whose move it is
	public boolean getPlayerTurn()
	{
		return playerTurn;
	}

	// returns moveConfirm
	public boolean getMoveConfirm()
	{
		return moveConfirm;
	}

	// Moved this into GameManager because it didnt feel like it should be in Chess Client
	public boolean getGameInProgress()
	{
		return gameInProgress;
	}

	boolean getPawnFirstMove()
	{
		return pawnFirstMove;
	}

	public boolean isKingChecked(Piece [] p, Piece king,  Square [][] s, int x, int y)
	{
		processingKing = true;
		for(int i=0; i<p.length;i++)
		{
			if (p[i].isDestroyed() == false)
			{
				Square ss = p[i].canMove( p[i], s, x, y);

				if(ss != null)
				{
					System.out.println(king.getName() +" Check\n");
					System.out.println(p[i].getName() + " can attack " +king.getName() + "\n");
					processingKing = false;
					return true;
				}
				else if (i == p.length - 1)
				{
					System.out.println(king.getName() +" Not check\n");
					processingKing = false;
					return false;
				}

			}
		}
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
