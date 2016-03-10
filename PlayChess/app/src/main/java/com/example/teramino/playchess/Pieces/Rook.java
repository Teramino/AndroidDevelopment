package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.Square;


public class Rook extends Piece {
	private boolean rookMoved = false;

	public Rook(String n, String c) {

		name = n;
		color = c;
	}

//	@Override
//	public Square canMove( Piece p, Square [][] s, double col, double row) {
//		double pYLocation = p.getY() / 50;
//
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
//					if (s[i][j].getX() == col*size && s[i][j].getY() == row*size)
//					{
//						// up
//						if (row > (int) pYLocation && p.getX() / size == col )
//						{
//							for (int x = (int) (pYLocation + 1); x<=row; x++)
//							{
//								System.out.println("Processing move[" +x +"][" +col+ "]");
//								if(s[x][(int) col].getY() / size == row && s[x][(int) col].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//								{
//									if (gameManager.getInstance().isProcessingKing() == false)
//									{
//										p.takePiece(s[i][j].getPiece());
//
//										return s[i][j];
//									}
//									else
//										return s[i][j];
//								}
//								else if (s[x][(int) col].getVaccancy() == false)
//								{
//									System.out.println("Blocked\n");
//									return null;
//								}
//								else if (x == row && s[x][(int) col].getY() / size == row && s[x][(int) col].getVaccancy() == true )
//								{
//
//									return s[i][j];
//								}
//							} // end for
//						} // end if
//						// down
//						else if ( row < (int) pYLocation && p.getX()  / size == col )
//						{
//							for (int x = (int) (pYLocation - 1); x>=row; x--)
//							{
//								System.out.println("Processing move[" +x +"][" +col+ "]");
//								if(s[x][(int) col].getY() / size == row && s[x][(int) col].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//								{
//									if (gameManager.getInstance().isProcessingKing() == false)
//									{
//										p.takePiece(s[i][j].getPiece());
//
//										return s[i][j];
//									}
//									else
//										return s[i][j];
//								}
//								else if (s[x][(int) col].getVaccancy() == false)
//								{
//									System.out.println("Blocked\n");
//									return null;
//								}
//								else if (x == row && s[x][(int) col].getY() / size == row && s[x][(int) col].getVaccancy() == true )
//								{
//
//									return s[i][j];
//								}
//							} // end for
//						}// end if
//						// left
//						else if(col < (int) p.getX() / size && p.getY() / size == row )
//						{
//							for (int x = (int) (p.getX() / size - 1); x>=col; x--)
//							{
//								System.out.println("Processing move[" +row +"][" +x+ "]");
//								if(s[(int) row][x].getX() / size == col && s[(int) row][x].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//								{
//									if (gameManager.getInstance().isProcessingKing() == false)
//									{
//										p.takePiece(s[i][j].getPiece());
//
//										return s[i][j];
//									}
//									else
//										return s[i][j];
//								}
//								else if (s[(int) row][x].getVaccancy() == false)
//								{
//									System.out.println("Blocked\n");
//									return null;
//								}
//								else if (x == col && s[(int) row][x].getX() / size == col && s[(int) row][x].getVaccancy() == true )
//								{
//
//									return s[i][j];
//								}
//							} // end for
//						} // end if
//						// right
//						else if(col > (int) p.getX() / size && p.getY() / size == row )
//						{
//							for (int x = (int) (p.getX() / size + 1); x<=col; x++)
//							{
//								System.out.println("Processing move[" +row +"][" +x+ "]");
//								if(s[(int) row][x].getX() / size == col && s[(int) row][x].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//								{
//									if (gameManager.getInstance().isProcessingKing() == false)
//									{
//										p.takePiece(s[i][j].getPiece());
//
//										return s[i][j];
//									}
//									else
//										return s[i][j];
//								}
//								else if (s[(int) row][x].getVaccancy() == false)
//								{
//									System.out.println("Blocked\n");
//									return null;
//								}
//								else if (x == col && s[(int) row][x].getX() / size == col && s[(int) row][x].getVaccancy() == true )
//								{
//
//									return s[i][j];
//								}
//							} // end for
//						} // end else if
//						else
//						{
//							System.out.println("Can't move there\n");
//							return null;
//						}
//					} // end if
//				} // end for
//			}  // end for
//		} // end else
//		return null;
//	} // end canMove

	public boolean hasRookMoved() {
		return rookMoved;
	}

	public void setRookMoved(boolean rookMoved) {
		this.rookMoved = rookMoved;
	}
} // end rook
