package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.Square;



public class King extends Piece
{
	private boolean kingMoved = false;
	
	private String whiteKing = "WhiteKing.png";
	private String blackKing = "BlackKing.png";

	//	private Piece rook = null;

	public King(String n, String c) {
		name = n;
		color = c;

	}

//	@Override
//	public Square canMove( Piece p, Square [][] s, double col, double row) {
//		System.out.println(this.getName());
//
//
//		if(p == null)
//			System.out.println("Select a piece");
//		else
//		{
//			for (int i = 0; i < numRows; i++)
//			{
//				for (int j = 0; j < numCols; j++)
//				{
//					if ( s[i][j].getX() == col*size && s[i][j].getY() == row*size )
//					{
//						//castle
//							// left
//						if (kingMoved == false && p.getX() - 2*size == s[i][j].getX() && p.getY() == s[i][j].getY() )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								gameManager.getInstance().setCastling(true);
//								return s[i][j-1];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//						}
//							// right
//						if (kingMoved == false && p.getX() + 2*size == s[i][j].getX() && p.getY() == s[i][j].getY() )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								gameManager.getInstance().setCastling(true);
//								return s[i][j+2];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//						}
//
//						// up
//						if (p.getX() == s[i][j].getX() && p.getY() == s[i][j].getY() - size )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								gameManager.getInstance().setKingMoved(true, (King) p);
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
//
//									return s[i][j];
//								}
//								else
//									return s[i][j];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//
//						}
//						// down
//						else if (p.getX() == s[i][j].getX() && p.getY() == s[i][j].getY() + size )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
//
//									return s[i][j];
//								}
//								else
//									return s[i][j];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//
//						}
//						// left
//						else if (p.getX() == s[i][j].getX() + size && p.getY() == s[i][j].getY() )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
//
//									return s[i][j];
//								}
//								else
//									return s[i][j];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//
//						}
//						// right
//						else if (p.getX() == s[i][j].getX() - size && p.getY() == s[i][j].getY() )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
//
//									return s[i][j];
//								}
//								else
//									return s[i][j];
//							}
//							else
//							{
//
//								System.out.println("Blocked\n");
//								return null;
//							}
//
//						}
//						// upLeft
//						else if (p.getX() == s[i][j].getX() + size && p.getY() == s[i][j].getY() - size )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
//
//									return s[i][j];
//								}
//								else
//									return s[i][j];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//
//						}
//						// upRight
//						else if (p.getX() == s[i][j].getX() - size && p.getY() == s[i][j].getY() - size )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
//
//									return s[i][j];
//								}
//								else
//									return s[i][j];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//
//						}
//						// downLeft
//						else if (p.getX() == s[i][j].getX() + size && p.getY() == s[i][j].getY() + size )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
//
//									return s[i][j];
//								}
//								else
//									return s[i][j];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//
//						}
//						// downRight
//						else if (p.getX() == s[i][j].getX() - size && p.getY() == s[i][j].getY() + size )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
//
//									return s[i][j];
//								}
//								else
//									return s[i][j];
//							}
//							else
//							{
//								System.out.println("Blocked\n");
//								return null;
//							}
//
//						}
//						else
//						{
//							System.out.println("Can't move there\n");
//							return null;
//						}
//					}// end if
//				}// end for
//			}// end for
//		}// end else
//		return null;
//	} // end canMove

//	@Override
//	public void doMove(Piece [] p, Square [][] s, double x, double y) {
//		// allows the previous space the king occupied to be proccesed
//		Square temp = Board.getInstance().getActivePiece().getSquare();
//		Board.getInstance().getActivePiece().disableSquare();
//
//		for(int i=0; i<p.length;i++)
//		{
//			if (p[i].isDestroyed() == false)
//			{
//				Square ss = p[i].canMove( p[i], s, x, y);
//
//				if(ss != null)
//				{
//					System.out.println(p[i].getName() + " can attack " +Board.getInstance().getActivePiece().getName() );
//					System.out.println("Removing "
//							+Board.getInstance().getPieceList().get(Board.getInstance().getPieceListCount()-1).getName()
//							+ " from piece list\n");
//
//					Board.getInstance().getPieceList().remove(Board.getInstance().getPieceListCount()-1);
//					Board.getInstance().setPieceListCount(Board.getInstance().getPieceListCount() - 1);
//					Board.getInstance().getActivePiece().setInActive();
//					Board.getInstance().getActivePiece().setSquare(temp);
//					Board.getInstance().setActivePiece(null);
//					return;
//				}
//				else if (i == p.length - 1) // once the loop has done it's last check the condition will be true
//				{
//					Board.getInstance().getActivePiece().setSquare(temp);
//
//					// if the code gets to here, active piece will contain King therefore I can call it specifically
//					Square s1 = Board.getInstance().getActivePiece().canMove( Board.getInstance().getActivePiece(), s, x, y);
//					if (s1 != null)
//					{
//						if (gameManager.getInstance().isCastling() == true)
//						{
//							double boardPieceX = Board.getInstance().getActivePiece().getX();
//							double width = Board.getInstance().getActivePiece().getWidth();
//							double height = Board.getInstance().getActivePiece().getHeight();
//							int boardKingSquareX = (int) Board.getInstance().getActivePiece().getX() / size;
//							int boardKingSquareY = (int) Board.getInstance().getActivePiece().getY() / size;
//							Square[][] boardSquare = Board.getInstance().getBoardSquare();
//							Rook rook = (Rook) s1.getPiece();
//							Piece king = Board.getInstance().getActivePiece();
//
//							if (rook != null && king.getX() - 3*size == rook.getX() && rook.hasRookMoved() == false)
//							{
//								king.setFrame(boardPieceX-2*size, y*size, width, height);
//								king.disableSquare();
//								king.setSquare(boardSquare[boardKingSquareX][boardKingSquareY]);
//								gameManager.getInstance().setRook(rook);
//
//								rook.setFrame(king.getX()+size, y*size, rook.getWidth(), rook.getWidth());
//								rook.disableSquare();
//								rook.setSquare(boardSquare[(int) rook.getX() / size][(int) rook.getY() / size]);
//
//								hasMoved = true;
//
//								// displays confirm move to textArea after each move until confirmed or canceled
//								Board.getInstance().setDisplayConfirm(true);
//								Options.getInstance().displayConfirmMessage();
//								return;
//
//
//							}
//							else if (rook != null && king.getX() + 4*size == rook.getX() )
//							{
//								king.setFrame(boardPieceX+2*size, y*size, width, height);
//								king.disableSquare();
//								king.setSquare(boardSquare[boardKingSquareX][boardKingSquareY]);
//								gameManager.getInstance().setRook(rook);
//
//								rook.setFrame(king.getX()-size, y*size, rook.getWidth(), rook.getWidth());
//								rook.disableSquare();
//								rook.setSquare(boardSquare[(int) rook.getX() / size][(int) rook.getY() / size]);
//
//								hasMoved = true;
//
//								// displays confirm move to textArea after each move until confirmed or canceled
//								Board.getInstance().setDisplayConfirm(true);
//								Options.getInstance().displayConfirmMessage();
//								return;
//
//							}
//							else
//							{
//								Board.getInstance().getActivePiece().setSquare(temp);
//
//								System.out.println("Removing "
//										+Board.getInstance().getPieceList().get(Board.getInstance().getPieceListCount()-1).getName()
//										+ " from piece list\n");
//
//								Board.getInstance().getPieceList().remove(Board.getInstance().getPieceListCount()-1);
//								Board.getInstance().setPieceListCount(Board.getInstance().getPieceListCount() - 1);
//								Board.getInstance().getActivePiece().setInActive();
//								Board.getInstance().setActivePiece(null);
//								return;
//							}
//						}
//						// if not castling everything happens normally
//
//						Board.getInstance().getActivePiece().setFrame(x*size, y*size,
//								Board.getInstance().getActivePiece().getWidth(),
//								Board.getInstance().getActivePiece().getWidth());
//						Board.getInstance().getActivePiece().disableSquare();
//						Board.getInstance().getActivePiece().setSquare(s1);
//						hasMoved = true;
//
//						// displays confirm move to textArea after each move until confirmed or canceled
//						Board.getInstance().setDisplayConfirm(true);
//						Options.getInstance().displayConfirmMessage();
//
//						return;
//					}
//					else
//					{
//						Board.getInstance().getActivePiece().setSquare(temp);
//
//						System.out.println("Invalid move...Removing "
//								+Board.getInstance().getPieceList().get(Board.getInstance().getPieceListCount()-1).getName()
//								+ " from piece list\n");
//
//						Board.getInstance().getPieceList().remove(Board.getInstance().getPieceListCount()-1);
//						Board.getInstance().setPieceListCount(Board.getInstance().getPieceListCount() - 1);
//						Board.getInstance().getActivePiece().setInActive();
//						Board.getInstance().setActivePiece(null);
//						return;
//					}
//
//				}
//			}
//		}
//	}


	public boolean isKingMoved() {
		return kingMoved;
	}


	public void setKingMoved(boolean kingMoved) {
		this.kingMoved = kingMoved;
	}

}// end king
