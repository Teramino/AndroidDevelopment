package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.Square;



public class Knight extends Piece {

	public Knight(String n, String c) {
		name = n;
		color = c;
	}

//	@Override
//	public Square canMove( Piece p, Square [][] s, double col, double row) {
//		System.out.println(this.getName());
//
//		if(p == null)
//			System.out.println("Select a piece\n");
//		else
//		{
//			for (int i = 0; i < numRows; i++)
//			{
//				for (int j = 0; j < numCols; j++)
//				{
//					if ( s[i][j].getX() == col*size && s[i][j].getY() == row*size )
//					{
//
//						// upLeft
//						if ( p.getX() - size == s[i][j].getX()  && p.getY() - 2*size  == s[i][j].getY() )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
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
//						else if ( p.getX() + size == s[i][j].getX()  && p.getY() - 2*size == s[i][j].getY()  )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor())
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
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
//						}// downLeft
//						else if ( p.getX() - size == s[i][j].getX()  && p.getY() + 2*size == s[i][j].getY()  )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
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
//						else if ( p.getX() + size == s[i][j].getX()  && p.getY() + 2*size == s[i][j].getY()  )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								return s[i][j];
//
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
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
//						// leftUp
//						else if ( p.getX() - 2*size == s[i][j].getX()  && p.getY() - size == s[i][j].getY()  )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
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
//						// rightUp
//						else if ( p.getX() + 2*size == s[i][j].getX()  && p.getY() - size == s[i][j].getY()  )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
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
//						// leftDown
//						else if ( p.getX() - 2*size == s[i][j].getX()  && p.getY() + size == s[i][j].getY()  )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor())
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
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
//						// rightDown
//						else if ( p.getX() + 2*size== s[i][j].getX()  && p.getY() + size == s[i][j].getY()  )
//						{
//							if (s[i][j].getVaccancy() == true)
//							{
//								return s[i][j];
//							}
//							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//							{
//								if (gameManager.getInstance().isProcessingKing() == false)
//								{
//									p.takePiece(s[i][j].getPiece());
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
}// end knight
