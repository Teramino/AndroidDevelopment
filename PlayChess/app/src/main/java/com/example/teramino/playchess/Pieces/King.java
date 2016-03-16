package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.Board;
import com.example.teramino.playchess.Setup.GameManager;
import com.example.teramino.playchess.Setup.ListFactory;
import com.example.teramino.playchess.Setup.Square;



public class King extends Piece
{
	private boolean kingMoved = false;

	public King(String name, String ownership, String color) {

		super(name,color,ownership);
	}

	@Override
	public Square canMove( Piece p, Square [][] s, int squareCol, int squareRow) {
		System.out.println(this.getName());


		if(p == null)
			System.out.println("Select a piece");
		else
		{
			for (int i = 0; i < numRows; i++)
			{
				for (int j = 0; j < numCols; j++)
				{
					if ( s[i][j].getCol() == squareCol&& s[i][j].getRow() == squareRow )
					{
						//castle
							// left
						if (kingMoved == false && p.getCol() - 2 == s[i][j].getCol() && p.getRow() == s[i][j].getRow() )
						{
							if (s[i][j].getVaccancy() == true)
							{

								GameManager.getInstance().setCastling(true);
								System.out.println("====================");
								return s[i][j-1];
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}
						}
							// right
						if (kingMoved == false && p.getCol() + 2 == s[i][j].getCol() && p.getRow() == s[i][j].getRow() )
						{
							if (s[i][j].getVaccancy() == true)
							{

								GameManager.getInstance().setCastling(true);
								System.out.println("====================");
								return s[i][j+2];
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}
						}

						// up
						if (p.getCol() == s[i][j].getCol() && p.getRow() - 1 == s[i][j].getRow() )
						{
							if (s[i][j].getVaccancy() == true)
							{
								GameManager.getInstance().setKingMoved(true, (King) p);
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									System.out.println("====================");
									return s[i][j];
								}
								else
								{
									System.out.println("====================");
									return s[i][j];
								}
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						// down
						else if (p.getCol() == s[i][j].getCol() && p.getRow() + 1 == s[i][j].getRow())
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									System.out.println("====================");
									return s[i][j];
								}
								else{
									System.out.println("====================");
									return s[i][j];
								}
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						// left
						else if (p.getCol() - 1 == s[i][j].getCol() && p.getRow() == s[i][j].getRow() )
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									System.out.println("====================");
									return s[i][j];
								}
								else{
									System.out.println("====================");
									return s[i][j];
								}
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						// right
						else if (p.getCol() + 1 == s[i][j].getCol() && p.getRow() == s[i][j].getRow() )
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									System.out.println("====================");
									return s[i][j];
								}
								else{
									System.out.println("====================");
									return s[i][j];
								}
							}
							else
							{

								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						// upLeft
						else if (p.getCol() - 1 == s[i][j].getCol() && p.getRow() - 1 == s[i][j].getRow() )
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									System.out.println("====================");
									return s[i][j];
								}
								else{
									System.out.println("====================");
									return s[i][j];
								}
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						// upRight
						else if (p.getCol() + 1 == s[i][j].getCol() && p.getRow() - 1 == s[i][j].getRow())
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									System.out.println("====================");
									return s[i][j];
								}
								else{
									System.out.println("====================");
									return s[i][j];
								}
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						// downLeft
						else if (p.getCol() - 1 == s[i][j].getCol() && p.getRow() + 1 == s[i][j].getRow())
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									System.out.println("====================");
									return s[i][j];
								}
								else{
									System.out.println("====================");
									return s[i][j];
								}
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						// downRight
						else if (p.getCol() + 1 == s[i][j].getCol() && p.getRow() + 1 == s[i][j].getRow())
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									System.out.println("====================");
									return s[i][j];
								}
								else{
									System.out.println("====================");
									return s[i][j];
								}
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						else
						{
							System.out.println("Can't move there ["+i+"]["+j+"]\n");
							System.out.println("====================");
							return null;
						}
					}// end if
				}// end for
			}// end for
		}// end else
		return null;
	} // end canMove

	@Override
	public void doMove(Piece [] p, Square [][] s, int squareCol, int squareRow) {
		// allows the previous space the king occupied to be proccesed
		Square temp = Board.getInstance().getActivePiece().getSquare();
		Board.getInstance().getActivePiece().disableSquare();

		for(int i=0; i<p.length;i++)
		{
			if (p[i].isDestroyed() == false)
			{
				// check to see if move will put king in check
				Square ss = p[i].canMove( p[i], s, squareCol, squareRow);

				if(ss != null)
				{
					System.out.println(p[i].getName() + " can attack " +Board.getInstance().getActivePiece().getName() );
					System.out.println("Removing "
							+Board.getInstance().getPieceList().get(Board.getInstance().getPieceListCount()-1).getName()
							+ " from piece list\n");

					Board.getInstance().getPieceList().remove(Board.getInstance().getPieceListCount()-1);
					Board.getInstance().setPieceListCount(Board.getInstance().getPieceListCount() - 1);
					Board.getInstance().getActivePiece().setInActive();
					Board.getInstance().getActivePiece().setSquare(temp);
					Board.getInstance().setActivePiece(null);
					return;
				}
				else if (i == p.length - 1) // once the loop has done it's last check the condition will be true
				{
					Board.getInstance().getActivePiece().setSquare(temp);


					Square s1 = Board.getInstance().getActivePiece().canMove( Board.getInstance().getActivePiece(), s, squareCol, squareRow);
					if (s1 != null)
					{
						if (GameManager.getInstance().isCastling() == true)
						{
							// if the code gets to here, active piece will contain Rook therefore I can call it specifically

//							double width = Board.getInstance().getActivePiece().getWidth();
//							double height = Board.getInstance().getActivePiece().getHeight();
							int boardKingSquareRow =  Board.getInstance().getActivePiece().getRow();
							int boardKingSquareCol = Board.getInstance().getActivePiece().getCol();
							Square[][] boardSquare = Board.getInstance().getBoardSquare();
							Rook rook = (Rook) s1.getPiece();
							Piece king = Board.getInstance().getActivePiece();

							if (rook != null && king.getCol() - 3 == rook.getCol() && rook.hasRookMoved() == false)
							{

//								king.setFrame(boardPieceX-2*size, squareRow *size, width, height);

								king.transferImage(s[squareRow][squareCol], king, squareCol, squareRow);
//								king.disableSquare();
//								king.setSquare(boardSquare[boardKingSquareRow][boardKingSquareCol]);
								GameManager.getInstance().setRook(rook);


								rook.transferImage(s[squareRow][squareCol+1], king, (squareCol+1), squareRow);
//								rook.setFrame(king.getX()+size, squareRow *size, rook.getWidth(), rook.getWidth());
//								rook.disableSquare();
//								rook.setSquare(boardSquare[rook.getRow()][rook.getCol()]);

								hasMoved = true;

								// displays confirm move to textArea after each move until confirmed or canceled
//								Board.getInstance().setDisplayConfirm(true);
//								Options.getInstance().displayConfirmMessage();
								return;


							}
							else if (rook != null && king.getCol() + 4== rook.getCol() )
							{
								king.transferImage(s[squareRow][squareCol], king, squareCol, squareRow);
//								king.setFrame(boardPieceX+2*size, squareRow *size, width, height);
//								king.disableSquare();
//								king.setSquare(boardSquare[boardKingSquareRow][boardKingSquareCol]);
								GameManager.getInstance().setRook(rook);


								rook.transferImage(s[squareRow][squareCol + 1], king, (squareCol - 1), squareRow);
//								rook.setFrame(king.getX()-size, squareRow *size, rook.getWidth(), rook.getWidth());
//								rook.disableSquare();
//								rook.setSquare(boardSquare[(int) rook.getX() / size][(int) rook.getY() / size]);

								hasMoved = true;

								// displays confirm move to textArea after each move until confirmed or canceled
//								Board.getInstance().setDisplayConfirm(true);
//								Options.getInstance().displayConfirmMessage();
								return;

							}
							else
							{
								Board.getInstance().getActivePiece().setSquare(temp);

								System.out.println("Removing "
										+Board.getInstance().getPieceList().get(Board.getInstance().getPieceListCount()-1).getName()
										+ " from piece list\n");

								System.out.println("Piece List: ");
								for( ListFactory print : Board.getPieceList())
								{
									System.out.println(print.getName());
								}
								System.out.println("====================");

								Board.getInstance().getPieceList().remove(Board.getInstance().getPieceListCount()-1);
								Board.getInstance().setPieceListCount(Board.getInstance().getPieceListCount() - 1);
								Board.getInstance().getActivePiece().setInActive();
								Board.getInstance().setActivePiece(null);
								return;
							}
						}
						// if not castling everything happens normally

						Piece king = (King) Board.getInstance().getActivePiece();
						king.transferImage(s1, king, squareCol, squareRow);

//						Board.getInstance().getActivePiece().setFrame(squareCol *size, squareRow *size,
//								Board.getInstance().getActivePiece().getWidth(),
//								Board.getInstance().getActivePiece().getWidth());
//						Board.getInstance().getActivePiece().disableSquare();
//						Board.getInstance().getActivePiece().setSquare(s1);
						hasMoved = true;

						// displays confirm move to textArea after each move until confirmed or canceled
//						Board.getInstance().setDisplayConfirm(true);
//						Options.getInstance().displayConfirmMessage();

						return;
					}
					else
					{
						Board.getInstance().getActivePiece().setSquare(temp);

						System.out.println("Invalid move...Removing "
								+Board.getInstance().getPieceList().get(Board.getInstance().getPieceListCount()-1).getName()
								+ " from piece list\n");

						System.out.println("Piece List: ");
						for( ListFactory print : Board.getPieceList())
						{
							System.out.println(print.getName());
						}
						System.out.println("====================");

						Board.getInstance().getPieceList().remove(Board.getInstance().getPieceListCount()-1);
						Board.getInstance().setPieceListCount(Board.getInstance().getPieceListCount() - 1);
						Board.getInstance().getActivePiece().setInActive();
						Board.getInstance().setActivePiece(null);
						return;
					}

				}
			}
		}
	}


//	public boolean isKingMoved() {
//		return kingMoved;
//	}


	public void setKingMoved(boolean kingMoved) {
		this.kingMoved = kingMoved;
	}

}// end king
