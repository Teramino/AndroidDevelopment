package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.GameManager;
import com.example.teramino.playchess.Setup.Square;


public class Rook extends Piece {
	private boolean rookMoved = false;

	public Rook(String n, String c) {

		name = n;
		color = c;
	}

	@Override
	public Square canMove( Piece p, Square [][] s, int squareCol, int squareRow) {

		int pRowLocation = p.getRow();

		System.out.println(this.getName());

		if(p == null)
			System.out.println("Select a piece\n");
		else
		{
			for (int i = 0; i < numRows; i++)
			{
				for (int j = 0; j < numCols; j++)
				{
					if (s[i][j].getCol() == squareCol && s[i][j].getRow() == squareRow)
					{
						// up
						if (squareRow > pRowLocation && p.getCol() == squareCol )
						{
							for (int x = (pRowLocation + 1); x<=squareRow; x++)
							{
								System.out.println("Processing move[" +x +"][" +squareCol+ "]");
								if(s[x][squareCol].getRow() == squareRow && s[x][squareCol].getVaccancy() == false && p.getColor() != s[x][squareCol].getPiece().getColor() )
								{
									if (GameManager.getInstance().isProcessingKing() == false)
									{
										p.takePiece(s[x][squareCol].getPiece());

										return s[x][squareCol];
									}
									else
										return s[x][squareCol];
								}
								else if (s[x][squareCol].getVaccancy() == false)
								{
									System.out.println("Blocked\n");
									return null;
								}
								else if (x == squareRow && s[x][squareCol].getRow() == squareRow && s[x][squareCol].getVaccancy() == true )
								{

									return s[x][squareCol];
								}
							} // end for
						} // end if
						// down
						else if ( squareRow < pRowLocation && p.getCol() == squareCol )
						{
							for (int x = (pRowLocation - 1); x>=squareRow; x--)
							{
								System.out.println("Processing move[" +x +"][" +squareCol+ "]");
								if(s[x][squareCol].getRow() == squareRow && s[x][squareCol].getVaccancy() == false && p.getColor() != s[x][squareCol].getPiece().getColor() )
								{
									if (GameManager.getInstance().isProcessingKing() == false)
									{
										p.takePiece(s[x][squareCol].getPiece());

										return s[x][squareCol];
									}
									else
										return s[x][squareCol];
								}
								else if (s[x][squareCol].getVaccancy() == false)
								{
									System.out.println("Blocked\n");
									return null;
								}
								else if (x == squareRow && s[x][squareCol].getRow() == squareRow && s[x][squareCol].getVaccancy() == true )
								{

									return s[x][squareCol];
								}
							} // end for
						}// end if
						// left
						else if(squareCol < p.getCol() && p.getRow() == squareRow )
						{
							for (int x = (int) (p.getCol() - 1); x>=squareCol; x--)
							{
								System.out.println("Processing move[" +squareRow +"][" +x+ "]");
								if(s[squareRow][x].getCol() == squareCol && s[squareRow][x].getVaccancy() == false && p.getColor() != s[squareRow][x].getPiece().getColor() )
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
									System.out.println("Blocked\n");
									return null;
								}
								else if (x == squareCol && s[squareRow][x].getCol() == squareCol && s[squareRow][x].getVaccancy() == true )
								{

									return s[squareRow][x];
								}
							} // end for
						} // end if
						// right
						else if(squareCol > p.getCol() && p.getRow() == squareRow )
						{
							for (int x = (p.getCol() + 1); x<=squareCol; x++)
							{
								System.out.println("Processing move[" +squareRow +"][" +x+ "]");
								if(s[squareRow][x].getCol() == squareCol && s[squareRow][x].getVaccancy() == false && p.getColor() != s[squareRow][x].getPiece().getColor() )
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
									System.out.println("Blocked\n");
									return null;
								}
								else if (x == squareCol && s[squareRow][x].getCol() == squareCol && s[squareRow][x].getVaccancy() == true )
								{

									return s[squareRow][x];
								}
							} // end for
						} // end else if
						else
						{
							System.out.println("Can't move there\n");
							return null;
						}
					} // end if
				} // end for
			}  // end for
		} // end else
		return null;
	} // end canMove

	public boolean hasRookMoved() {
		return rookMoved;
	}

	public void setRookMoved(boolean rookMoved) {
		this.rookMoved = rookMoved;
	}
} // end rook
