package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.Square;



public class Queen extends Piece {


	public Queen(String n, String c) {
		name = n;
		color = c;
	}

//	public Square canMove( Piece p, Square [][] s, double col, double row) {
//		double pYLocation = p.getY() / 50;
//
//		System.out.println(this.getName());
//
//		if(p == null)
//				System.out.println("Select a piece");
//			else
//			{
//				for (int i = 0; i < numRows; i++)
//				{
//					for (int j = 0; j < numCols; j++)
//					{
//						if ( s[i][j].getX() == col*size && s[i][j].getY() == row*size )
//						{
//							// up
//							if (row < (int) pYLocation && col == p.getX() / size )
//							{
//								for (int x = (int) (pYLocation - 1); x>=row; x--)
//								{
//									System.out.println("Processing move[" +x+"][" +col+ "]");
//									if(x == row && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//									{
//										if (gameManager.getInstance().isProcessingKing() == false)
//										{
//											p.takePiece(s[i][j].getPiece());
//											return s[i][j];
//										}
//										else
//											return s[i][j];
//									}
//									else if ( s[x][(int) col].getVaccancy() == false )
//									{
//										System.out.println("Blocked\n");
//										return null;
//									}
//									else if (x == row && s[i][j].getVaccancy() == true )
//									{
//										return s[i][j];
//									}
//									else if (x == row )
//									{
//										System.out.println("Cant move there\n");
//										return null;
//									}
//								} // end for
//							} // end if
//							// upLeft
//							else if (row < (int) pYLocation && col < p.getX() / size )
//							{
//								int x = (int) (pYLocation - 1);
//
//								for (int z = (int) (p.getX() / 50 - 1); z>=col; z--)
//								{
//
//									System.out.println("Processing move[" +x+"][" +z+ "]");
//									if(x == row && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//									{
//										if (gameManager.getInstance().isProcessingKing() == false)
//										{
//											p.takePiece(s[i][j].getPiece());
//											return s[i][j];
//										}
//										else
//											return s[i][j];
//									}
//									else if (s[x][z].getVaccancy() == false)
//									{
//										System.out.println("Blocked\n");
//										return null;
//									}
//									if (x == row && z == col && s[i][j].getVaccancy() == true )
//									{
//										return s[i][j];
//									}
//									else if (z == col )
//									{
//										System.out.println("Cant move there\n");
//										return null;
//									}
//									else
//									{
//										x--;
//										if (x > 7 || x < 0)
//											return null;
//									}
//								}// end for
//							} // end if
//							// upRight
//							else if (row < (int) pYLocation && col > p.getX() / size )
//							{
//								int x = (int) (pYLocation - 1);
//
//								for (int z = (int) (p.getX() / 50 + 1); z<=col; z++)
//								{
//
//									System.out.println("Processing move[" +x+"][" +z+ "]");
//									if(x == row && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//									{
//										if (gameManager.getInstance().isProcessingKing() == false)
//										{
//											p.takePiece(s[i][j].getPiece());
//											return s[i][j];
//										}
//										else
//											return s[i][j];
//									}
//									else if (s[x][z].getVaccancy() == false)
//									{
//										System.out.println("Blocked\n");
//										return null;
//									}
//									else if (x == row && z == col && s[i][j].getVaccancy() == true )
//									{
//										return s[i][j];
//									}
//									else if (z == col )
//									{
//										System.out.println("Cant move there\n");
//										return null;
//									}
//									else
//									{
//										x--;
//										if (x > 7 || x < 0)
//											return null;
//									}
//								}// end for
//							} // end  else if
//							// down
//							else if ( row > (int) pYLocation && col == p.getX() / size )
//							{
//								for (int x = (int) (pYLocation + 1); x<=row; x++)
//								{
//									System.out.println("Processing move[" +x+"][" +col+ "]");
//									if(x == row &&  s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//									{
//										if (gameManager.getInstance().isProcessingKing() == false)
//										{
//											p.takePiece(s[i][j].getPiece());
//											return s[i][j];
//										}
//										else
//											return s[i][j];
//									}
//									else if ( s[x][(int) col].getVaccancy() == false )
//									{
//										System.out.println("Blocked\n");
//										return null;
//									}
//									else if (x == row && s[i][j].getVaccancy() == true )
//									{
//										return s[i][j];
//									}
//									else if (x == row )
//									{
//										System.out.println("Cant move there\n");
//										return null;
//									}
//								} // end for
//							}// end if
//							// downLeft
//							else if (row > (int) pYLocation && col < p.getX() / size )
//							{
//								int x = (int) (pYLocation + 1);
//
//								for (int z = (int) (p.getX() / 50 - 1); z>=col; z--)
//								{
//
//									System.out.println("Processing move[" +x+"][" +z+ "]");
//									if(x == row && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//									{
//										if (gameManager.getInstance().isProcessingKing() == false)
//										{
//											p.takePiece(s[i][j].getPiece());
//											return s[i][j];
//										}
//										else
//											return s[i][j];
//									}
//									else if (s[x][z].getVaccancy() == false)
//									{
//										System.out.println("Blocked\n");
//										return null;
//									}
//									else if (x == row && z == col && s[i][j].getVaccancy() == true )
//									{
//										return s[i][j];
//									}
//									else if (z == col )
//									{
//										System.out.println("Cant move there\n");
//										return null;
//									}
//									else
//									{
//										x++;
//										if (x > 7 || x < 0)
//											return null;
//									}
//								}// end for
//							} // end else if
//							// downRight
//							else if (row > (int) pYLocation && col > p.getX() / size )
//							{
//								int x = (int) (pYLocation + 1);
//
//								for (int z = (int) (p.getX() / 50 + 1); z<=col; z++)
//								{
//
//									System.out.println("Processing move[" +x+"][" +z+ "]");
//									if(x == row && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//									{
//										if (gameManager.getInstance().isProcessingKing() == false)
//										{
//											p.takePiece(s[i][j].getPiece());
//											return s[i][j];
//										}
//										else
//											return s[i][j];
//									}
//									else if (s[x][z].getVaccancy() == false)
//									{
//										System.out.println("Blocked\n");
//										return null;
//									}
//									else if (x == row && z == col && s[i][j].getVaccancy() == true )
//									{
//										return s[i][j];
//									}
//									else if (z == col )
//									{
//										System.out.println("Cant move there\n");
//										return null;
//									}
//									else
//									{
//										x++;
//										if (x > 7 || x < 0)
//											return null;
//									}
//								}// end for
//							}// end else if
//							// left
//							else if(col < (int) p.getX() / size && p.getY() / size == row)
//							{
//								for (int x = (int) (p.getX() / size - 1); x>=col; x--)
//								{
//									System.out.println("Processing move[" +row +"][" +x+ "]");
//									if(x == col && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor())
//									{
//										if (gameManager.getInstance().isProcessingKing() == false)
//										{
//											p.takePiece(s[i][j].getPiece());
//											return s[i][j];
//										}
//										else
//											return s[i][j];
//									}
//									else if ( s[(int) row][x].getVaccancy() == false )
//									{
//										System.out.println("Blocked\n");
//										return null;
//									}
//									else if (x == col && s[i][j].getVaccancy() == true )
//									{
//										return s[i][j];
//									}
//									else if (x == col )
//									{
//										System.out.println("Cant move there\n");
//										return null;
//									}
//								} // end for
//							} // end if
//							// right
//							else if(col > (int) p.getX() / size && p.getY() / size == row)
//							{
//								for (int x = (int) (p.getX() / size + 1); x<=col; x++)
//								{
//									System.out.println("Processing move[" +row +"][" +x+ "]");
//									if(x == col && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
//									{
//										if (gameManager.getInstance().isProcessingKing() == false)
//										{
//											p.takePiece(s[i][j].getPiece());
//											return s[i][j];
//										}
//										else
//											return s[i][j];
//									}
//									else if (s[(int) row][x].getVaccancy() == false)
//									{
//										System.out.println("Blocked\n");
//										return null;
//									}
//									else if (x == col && s[i][j].getVaccancy() == true )
//									{
//										return s[i][j];
//									}
//									else if (x == col )
//									{
//										System.out.println("Cant move there\n");
//										return null;
//									}
//								} // end for
//							} // end else if
//							else // any more that isn't rook // sets the manulpated square bak to normal
//							{
//								System.out.println("Can't move there\n");
//								return null;
//							}// end else
//						} // end if
//					} // end for
//				} // end for
//			} // end else
//		return null;
//	} // end canMove
} // end Queen

