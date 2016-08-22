package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.GameManager;
import com.example.teramino.playchess.Setup.Square;



public class Queen extends Piece {

	public Queen(String name, String ownership, String color) {

		super(name,color,ownership);
	}

	@Override
	public Square canMove( Piece p, Square [][] s, int squareCol, int squareRow) {

		int pRowLocation = p.getRow();

		System.out.println(this.getName());

		if(p == null)
				System.out.println("Select a piece");
			else
			{
				for (int i = 0; i < numRows; i++)
				{
					for (int j = 0; j < numCols; j++)
					{
						if ( s[i][j].getCol() == squareCol && s[i][j].getRow() == squareRow )
						{
							// up
							if (squareRow <  pRowLocation && squareCol == p.getCol() )
							{
								for (int x = (pRowLocation - 1); x>=squareRow; x--)
								{
									System.out.println("Processing move[" +x+"][" +squareCol+ "]");
									// if there's a opp piece on that square
									if(x == squareRow && s[x][squareCol].getVaccancy() == false && p.getColor() != s[x][squareCol].getPiece().getColor() )
									{
										if (GameManager.getInstance().isProcessingKing() == false)
										{
											p.takePiece(s[x][squareCol].getPiece());
											return s[x][squareCol];
										}
										else
											return s[x][squareCol];
									}
									else if ( s[x][squareCol].getVaccancy() == false )
									{
										System.out.println("Up Blocked\n");
										if (GameManager.getInstance().isProcessingKing()) {
											GameManager.getInstance().blocking(s[x][squareCol].getPiece());
											GameManager.getInstance().attacking(this);
										}
										return null;
									}
									else if (x == squareRow && s[x][squareCol].getVaccancy() == true )
									{
										return s[x][squareCol];
									}
									else if (x == squareRow )
									{
										System.out.println("Cant move there\n");
										return null;
									}

								} // end for
							} // end if
							// upLeft
							else if (squareRow < pRowLocation && squareCol < p.getCol() )
							{
								int x = (pRowLocation - 1);

								for (int z = (p.getCol() - 1); z>=squareCol; z--)
								{

									System.out.println("Processing move[" +x+"][" +z+ "]");
									if(x == squareRow && s[x][z].getVaccancy() == false && p.getColor() != s[x][z].getPiece().getColor() )
									{
										if (GameManager.getInstance().isProcessingKing() == false)
										{
											p.takePiece(s[x][z].getPiece());
											return s[x][z];
										}
										else
											return s[x][z];
									}
									else if (s[x][z].getVaccancy() == false)
									{
										System.out.println("UpLeft Blocked\n");
										if (GameManager.getInstance().isProcessingKing()) {
											GameManager.getInstance().blocking(s[x][z].getPiece());
											GameManager.getInstance().attacking(this);
										}
										return null;
									}
									if (x == squareRow && z == squareCol && s[i][j].getVaccancy() == true )
									{
										return s[x][z];
									}
									else if (z == squareCol )
									{
										System.out.println("Cant move there\n");
										return null;
									}
									else
									{
										x--;
										if (x > 7 || x < 0)
											return null;
									}
								}// end for
							} // end if
							// upRight
							else if (squareRow < pRowLocation && squareCol > p.getCol() )
							{
								int x = (pRowLocation - 1);

								for (int z = (p.getCol()+ 1); z<=squareCol; z++)
								{

									System.out.println("Processing move[" +x+"][" +z+ "]");
									if(x == squareRow && s[x][z].getVaccancy() == false && p.getColor() != s[x][z].getPiece().getColor() )
									{
										if (GameManager.getInstance().isProcessingKing() == false)
										{
											p.takePiece(s[x][z].getPiece());
											return s[x][z];
										}
										else
											return s[x][z];
									}
									else if (s[x][z].getVaccancy() == false)
									{
										System.out.println("UpRight Blocked\n");
										if (GameManager.getInstance().isProcessingKing() && p.getColor() != s[x][z].getPiece().getColor()) {
											GameManager.getInstance().blocking(s[x][z].getPiece());
											GameManager.getInstance().attacking(this);
										}
										return null;
									}
									else if (x == squareRow && z == squareCol && s[i][j].getVaccancy() == true )
									{
										return s[x][z];
									}
									else if (z == squareCol )
									{
										System.out.println("Cant move there\n");
										return null;
									}
									else
									{
										x--;
										if (x > 7 || x < 0)
											return null;
									}
								}// end for
							} // end  else if
							// down
							else if ( squareRow > pRowLocation && squareCol == p.getCol() )
							{
								for (int x = (pRowLocation + 1); x<=squareRow; x++)
								{
									System.out.println("Processing move[" +x+"][" +squareCol+ "]");
									if(x == squareRow &&  s[x][squareCol].getVaccancy() == false && p.getColor() != s[x][squareCol].getPiece().getColor() )
									{
										if (GameManager.getInstance().isProcessingKing() == false)
										{
											p.takePiece(s[x][squareCol].getPiece());
											return s[x][squareCol];
										}
										else
											return s[x][squareCol];
									}
									else if ( s[x][squareCol].getVaccancy() == false )
									{
										System.out.println("Down Blocked\n");
										if (GameManager.getInstance().isProcessingKing()) {
											GameManager.getInstance().blocking(s[x][squareCol].getPiece());
											GameManager.getInstance().attacking(this);
										}
										return null;
									}
									else if (x == squareRow && s[x][squareCol].getVaccancy() == true )
									{
										return s[x][squareCol];
									}
									else if (x == squareRow )
									{
										System.out.println("Cant move there\n");
										return null;
									}
								} // end for
							}// end if
							// downLeft
							else if (squareRow > pRowLocation && squareCol < p.getCol() )
							{
								int x = (int) (pRowLocation + 1);

								for (int z = (p.getCol()- 1); z>=squareCol; z--)
								{

									System.out.println("Processing move[" +x+"][" +z+ "]");
									if(x == squareRow && s[x][z].getVaccancy() == false && p.getColor() != s[x][z].getPiece().getColor() )
									{
										if (GameManager.getInstance().isProcessingKing() == false)
										{
											p.takePiece(s[x][z].getPiece());
											return s[x][z];
										}
										else
											return s[x][z];
									}
									else if (s[x][z].getVaccancy() == false)
									{
										System.out.println("DownLeft Blocked\n");
										if (GameManager.getInstance().isProcessingKing()) {
											GameManager.getInstance().blocking(s[x][z].getPiece());
											GameManager.getInstance().attacking(this);
										}
										return null;
									}
									else if (x == squareRow && z == squareCol && s[x][z].getVaccancy() == true )
									{
										return s[x][z];
									}
									else if (z == squareCol )
									{
										System.out.println("Cant move there\n");
										return null;
									}
									else
									{
										x++;
										if (x > 7 || x < 0)
											return null;
									}
								}// end for
							} // end else if
							// downRight
							else if (squareRow > pRowLocation && squareCol > p.getCol() )
							{
								int x = (pRowLocation + 1);

								for (int z = (p.getCol() + 1); z<=squareCol; z++)
								{

									System.out.println("Processing move[" +x+"][" +z+ "]");
									if(x == squareRow && s[x][z].getVaccancy() == false && p.getColor() != s[x][z].getPiece().getColor() )
									{
										if (GameManager.getInstance().isProcessingKing() == false)
										{
											p.takePiece(s[x][z].getPiece());
											return s[x][z];
										}
										else
											return s[x][z];
									}
									else if (s[x][z].getVaccancy() == false)
									{
										System.out.println("DownRight Blocked\n");
										if (GameManager.getInstance().isProcessingKing()) {
											GameManager.getInstance().blocking(s[x][z].getPiece());
											GameManager.getInstance().attacking(this);
										}
										return null;
									}
									else if (x == squareRow && z == squareCol && s[x][z].getVaccancy() == true )
									{
										return s[x][z];
									}
									else if (z == squareCol )
									{
										System.out.println("Cant move there\n");
										return null;
									}
									else
									{
										x++;
										if (x > 7 || x < 0)
											return null;
									}
								}// end for
							}// end else if
							// left
							else if(squareCol < p.getCol() && p.getRow() == squareRow)
							{
								for (int x = (p.getCol() - 1); x>=squareCol; x--)
								{
									System.out.println("Processing move[" +squareRow +"][" +x+ "]");
									if(x == squareCol && s[squareRow][x].getVaccancy() == false && p.getColor() != s[squareRow][x].getPiece().getColor())
									{
										if (GameManager.getInstance().isProcessingKing() == false)
										{
											p.takePiece(s[squareRow][x].getPiece());
											return s[squareRow][x];
										}
										else
											return s[squareRow][x];
									}
									else if ( s[squareRow][x].getVaccancy() == false )
									{
										System.out.println("Left Blocked\n");
										if (GameManager.getInstance().isProcessingKing()) {
											GameManager.getInstance().blocking(s[squareRow][x].getPiece());
											GameManager.getInstance().attacking(this);
										}
										return null;
									}
									else if (x == squareCol && s[squareRow][x].getVaccancy() == true )
									{
										return s[squareRow][x];
									}
									else if (x == squareCol )
									{
										System.out.println("Cant move there\n");
										return null;
									}
								} // end for
							} // end if
							// right
							else if(squareCol > p.getCol() && p.getRow() == squareRow)
							{
								for (int x = (p.getCol()+ 1); x<=squareCol; x++)
								{
									System.out.println("Processing move[" +squareRow +"][" +x+ "]");
									if(x == squareCol && s[squareRow][x].getVaccancy() == false && p.getColor() != s[squareRow][x].getPiece().getColor() )
									{
										if (GameManager.getInstance().isProcessingKing() == false)
										{
											p.takePiece(s[squareRow][x].getPiece());
											return s[squareRow][x];
										}
										else
											return s[squareRow][x];
									}
									else if (s[squareRow][x].getVaccancy() == false)
									{
										System.out.println("Right Blocked\n");
										if (GameManager.getInstance().isProcessingKing()) {
											GameManager.getInstance().blocking(s[squareRow][x].getPiece());
											GameManager.getInstance().attacking(this);
										}
										return null;
									}
									else if (x == squareCol && s[squareRow][x].getVaccancy() == true )
									{
										return s[squareRow][x];
									}
									else if (x == squareCol )
									{
										System.out.println("Cant move there\n");
										return null;
									}
								} // end for
							} // end else if
							else // any more that isn't rook // sets the manulpated square bak to normal
							{
								System.out.println("Can't move there\n");
								return null;
							}// end else
						} // end if
					} // end for
				} // end for
			} // end else
		return null;
	} // end canMove
} // end Queen

