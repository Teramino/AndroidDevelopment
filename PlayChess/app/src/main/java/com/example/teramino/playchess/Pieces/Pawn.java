package com.example.teramino.playchess.Pieces;
import com.example.teramino.playchess.Setup.GameManager;
import com.example.teramino.playchess.Setup.Square;



public class Pawn extends Piece
{	
	private boolean pawnMoved = false;
	private Square initialSquare;

	public Pawn(String n, String c)
	{
		name = n;
		color = c;
	}

	@Override
	public Square canMove( Piece p, Square [][] s, int squareCol, int squareRow)
	{
		System.out.println(this.getName());
		
//		
//		else if (  p.getsquareColor() == squareColor.lightGray)
//		{
			if(p == null) 
				System.out.println("Select a piece\n"); 
			else
			{
				for (int i = 0; i < numRows; i++)  
				{
					for (int j = 0; j < numCols; j++)
					{
						if ( s[i][j].getRow() == squareCol && s[i][j].getCol() == squareRow)
						{
							// move 2 spaces
							if (pawnMoved == false && p.getRow() == s[i][j].getRow()  && p.getCol()- 2 == s[i][j].getCol() )
							{

								if (s[i][j].getVaccancy() == true)
								{
									
									return s[i][j];
								}

							}
							else if (p.getRow() == s[i][j].getRow() && p.getCol() == s[i][j].getCol() )
							{
								if (s[i][j].getVaccancy() == true)
								{
									
									return s[i][j];
								}
							}
							//upLeft
							else if(p.getRow() == s[i][j].getRow() && p.getCol() == s[i][j].getCol() && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									
									return s[i][j];
								}
								else
									return s[i][j];
							}
							//upRight
							else if(p.getRow() == s[i][j].getRow() && p.getCol() == s[i][j].getCol() && s[i][j].getVaccancy() == false && p.getColor() != s[i][j].getPiece().getColor() )
							{
								if (GameManager.getInstance().isProcessingKing() == false)
								{
									p.takePiece(s[i][j].getPiece());
									
									return s[i][j];
								}
								else
									return s[i][j];
							}
							else
							{
								System.out.println("Can't move there\n");
								return null;
							}// end else
						}// end if
					}// end for
				}// end for
			}// end else 
//		}// end else if 
		return null;
	} // end canMove

	public boolean isPawnMoved() {
		return pawnMoved;
	}

	public void setPawnMoved(boolean pawnMoved) {
		this.pawnMoved = pawnMoved;
	}

} // end class
