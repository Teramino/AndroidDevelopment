package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.GameManager;
import com.example.teramino.playchess.Setup.Square;



public class Knight extends Piece {

	public Knight(String n, String c) {
		name = n;
		color = c;
	}

	@Override
	public Square canMove( Piece p, Square [][] s, int squareCol, int squareRow) {
		System.out.println(this.getName());

		if(p == null)
			System.out.println("Select a piece\n");
		else
		{
			for (int i = 0; i < numRows; i++)
			{
				for (int j = 0; j < numCols; j++)
				{
					if ( s[i][j].getCol() == squareCol && s[i][j].getRow() == squareRow)
					{

						// upLeft
						if ( p.getCol() - 1 == s[i][j].getCol()  && p.getRow() - 2  == s[i][j].getRow() )
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
								else
									return s[i][j];
							}
							else
							{
								System.out.println("Blocked\n");
								System.out.println("====================");
								return null;
							}

						}
						// upRight
						else if ( p.getCol() + 1 == s[i][j].getCol()  && p.getRow() - 2 == s[i][j].getRow()  )
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor())
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

						}// downLeft
						else if ( p.getCol() - 1 == s[i][j].getCol()  && p.getRow() + 2 == s[i][j].getRow()  )
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
						else if ( p.getCol() + 1== s[i][j].getCol()  && p.getRow() + 2 == s[i][j].getRow()  )
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
						// leftUp
						else if ( p.getCol() - 2 == s[i][j].getCol()  && p.getRow() - 1 == s[i][j].getRow()  )
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
						// rightUp
						else if ( p.getCol() + 2 == s[i][j].getCol()  && p.getRow() - 1 == s[i][j].getRow()  )
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
						// leftDown
						else if ( p.getCol() - 2 == s[i][j].getCol()  && p.getRow() + 1 == s[i][j].getRow()  )
						{
							if (s[i][j].getVaccancy() == true)
							{
								System.out.println("====================");
								return s[i][j];
							}
							else if(s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor())
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
						// rightDown
						else if ( p.getCol() + 2== s[i][j].getCol()  && p.getRow() + 1 == s[i][j].getRow()  )
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
							System.out.println("Can't move there\n");
							System.out.println("====================");
							return null;
						}
					}// end if
				}// end for
			}// end for
		}// end else
		return null;
	} // end canMove
}// end knight
