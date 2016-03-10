package com.example.teramino.playchess.Pieces;

import com.example.teramino.playchess.Setup.Square;

public class Bishop extends Piece
{

	public Bishop(String n, String c)
	{
		name = n;
		color = c;

	}

//	public Square canMove( Piece p, Square [][] s, int squareCol, int squareRow) {
//
//		// using the indices of the piece and square can replace using squareCol and row
//
//
////		double pYLocation = p.getY() / 50;
//
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
//					// finding the piece attached to square
//					if ( s[i][j].getPiece() ==  p)
//					{
//						// upLeft
//						// is the row and squareCol (square) to the left of piece
//						if (squareRow < p.getRow() && squareCol < p.getCol() )
//						{
//							int x = p.getRow();
//
//							for (int z = p.getRow(); z>=squareCol; z--)
//							{
//								System.out.println("Processing move[" +x+"][" +z+ "]");
//
//								// fix this so that it doesnt always return a square
//								if(s[x][z].getRow() == squareCol && s[x][z].getCol() == squareRow && s[x][z].getVaccancy() == false
//										&& p.getsquareColor() != s[i][j].getPiece().getsquareColor() )
//								{
//									if (gameManager.getInstance().isProcessingKing() == false)
//									{
//										p.takePiece(s[i][j].getPiece());
//										return s[i][j];
//									}
//									else
//										return s[i][j];
//								}
//								else if ( s[x][z].getVaccancy() == false )
//								{
//									System.out.println("Blocked\n");
//									return null;
//								}
//								else if (s[x][z].getX() / size == squareCol && s[x][z].getY() / size == squareRow
//										&& s[x][z].getVaccancy() == true )
//								{
//									return s[i][j];
//								}
//								else if (z == squareCol )
//								{
//									System.out.println("Cant move there\n");
//									return null;
//								}
//								else
//								{
//									x--;
//									if (x > 7 || x < 0)
//										return null;
//								}
//							}// end for
//						} // end if
//						// upRight
//						else if (squareRow < (int) pYLocation && squareCol > p.getX() / 50 )
//						{
//							int x = (int) (pYLocation - 1);
//
//							for (int z = (int) (p.getX() / 50 + 1); z<=squareCol; z++)
//							{
//								System.out.println("Processing move[" +x+"][" +z+ "]");
//
//								if(s[x][z].getX() / size == squareCol && s[x][z].getY() / size == squareRow && s[x][z].getVaccancy() == false
//										&& p.getsquareColor() != s[i][j].getPiece().getsquareColor() )
//								{
//									if (gameManager.getInstance().isProcessingKing() == false)
//									{
//										p.takePiece(s[i][j].getPiece());
//										return s[i][j];
//									}
//									else
//										return s[i][j];
//								}
//								else if ( s[x][z].getVaccancy() == false )
//								{
//									System.out.println("Blocked\n");
//									return null;
//								}
//								else if (s[x][z].getX() / size == squareCol && s[x][z].getY() / size == squareRow
//										&& s[x][z].getVaccancy() == true )
//								{
//									return s[i][j];
//								}
//								else if (z == squareCol )
//								{
//									System.out.println("Cant move there\n");
//									return null;
//								}
//								else
//								{
//									x--;
//
//									if (x > 7 || x < 0)
//										return null;
//								}
//							}// end for
//						} // end  else if
//						// downLeft
//						else if (squareRow > (int) pYLocation && squareCol < p.getX() / 50 )
//						{
//							int x = (int) (pYLocation + 1);
//
//							for (int z = (int) (p.getX() / 50 - 1); z>=squareCol; z--)
//							{
//								System.out.println("Processing move[" +x+"][" +z+ "]");
//
//								if(s[x][z].getX() / size == squareCol && s[x][z].getY() / size == squareRow && s[x][z].getVaccancy() == false
//										&& p.getsquareColor() != s[i][j].getPiece().getsquareColor() )
//								{
//									if (gameManager.getInstance().isProcessingKing() == false)
//									{
//										p.takePiece(s[i][j].getPiece());
//										return s[i][j];
//									}
//									else
//										return s[i][j];
//								}
//								else if ( s[x][z].getVaccancy() == false )
//								{
//									System.out.println("Blocked\n");
//									return null;
//								}
//								else if (s[x][z].getX() / size == squareCol && s[x][z].getY() / size == squareRow
//										&& s[x][z].getVaccancy() == true )
//								{
//									return s[i][j];
//								}
//								else if (z == squareCol )
//								{
//									System.out.println("Cant move there\n");
//									return null;
//								}
//								else
//								{
//									x++;
//									if (x > 7 || x < 0)
//										return null;
//
//								}
//							}// end for
//						} // end else if
//						// downRight
//						else if (squareRow > (int) pYLocation && squareCol > p.getX() / 50 )
//						{
//							int x = (int) (pYLocation + 1);
//
//							for (int z = (int) (p.getX() / 50 + 1); z<=squareCol; z++)
//							{
//								System.out.println("Processing move[" +x+"][" +z+ "]");
//
//								if(s[x][z].getX() / size == squareCol && s[x][z].getY() / size == squareRow && s[x][z].getVaccancy() == false
//										&& p.getsquareColor() != s[i][j].getPiece().getsquareColor() )
//								{
//									if (gameManager.getInstance().isProcessingKing() == false)
//									{
//										p.takePiece(s[i][j].getPiece());
//										return s[i][j];
//									}
//									else
//										return s[i][j];
//								}
//								else if ( s[x][z].getVaccancy() == false )
//								{
//									System.out.println("Blocked\n");
//									return null;
//								}
//								else if (s[x][z].getX() / size == squareCol && s[x][z].getY() / size == squareRow
//										&& s[x][z].getVaccancy() == true )
//								{
//									return s[i][j];
//								}
//								else if (z == squareCol )
//								{
//									System.out.println("Cant move there\n");
//									return null;
//								}
//								else
//								{
//									x++;
//									if (x > 7 || x < 0)
//										return null;
//
//								}
//							}// end for
//						} // end else if
//						else
//						{
//							System.out.println("Cant move there\n");
//							return null;
//						}// end else
//					} // end if
//				} // end for
//			} // end for
//		} // end else
//		return null;
//	} // end canMove
} // end bishop


