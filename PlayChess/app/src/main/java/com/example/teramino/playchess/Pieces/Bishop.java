package com.example.teramino.playchess.Pieces;

import com.example.teramino.playchess.Setup.GameManager;
import com.example.teramino.playchess.Setup.Square;

public class Bishop extends Piece
{

	public Bishop(String name, String ownership, String color) {

		super(name,color,ownership);
	}

    @Override
	public Square canMove( Piece p, Square [][] s, int squareCol, int squareRow) {

		// using the indices of the piece and square can replace using squareCol and row


		int pRowLocation = p.getRow();

		System.out.println(this.getName());

		// used to quickly detect if bishop CANT attack king
		if (GameManager.getInstance().isProcessingKing()){
			int blah = (squareCol+squareRow) %2;
			if (this.getName() == "My_Bishop1" && (squareCol+squareRow) %2 != 1){
				System.out.println("Cant move there\n");
				System.out.println("============");
				return null;
			}
			else if (this.getName() == "My_Bishop2" && (squareCol+squareRow) %2 != 0){
				System.out.println("Cant move there\n");
				System.out.println("============");
				return null;
			}
		}


		if(p == null)
			System.out.println("Select a piece");
		else
		{
			for (int i = 0; i < numRows; i++)
			{
				for (int j = 0; j < numCols; j++)
				{
					// finding the piece attached to square
					if ( s[i][j].getPiece() ==  p)
					{
						// upLeft
						// is the row and squareCol (square) to the left of piece
						if (squareRow < p.getRow() && squareCol < p.getCol() )
						{
							// x will get subtracted after each loop
							// consider for loop
							int x = pRowLocation - 1;

							for (int z = p.getCol()-1; z>=squareCol; z--)
							{
								System.out.println("Processing move[" +x+"][" +z+ "]");

								// fix this so that it doesnt always return a square
								if(s[x][z].getCol() == squareCol && s[x][z].getRow() == squareRow && s[x][z].getVaccancy() == false
										&& p.getColor() != s[x][z].getPiece().getColor() )
								{
									if (GameManager.getInstance().isProcessingKing() == false)
									{
										p.takePiece(s[x][z].getPiece());
                                        System.out.println("============");
										return s[x][z];
									}
									else {
                                        // if processingKing is true
                                        // the king is in the space resulting in a check
                                        System.out.println("============");
//
                                        return s[x][z];
                                    }
								}
								else if ( s[x][z].getVaccancy() == false )
								{
									System.out.println("UpLeft Blocked\n");
                                    System.out.println("============");
									if (GameManager.getInstance().isProcessingKing()) {
										GameManager.getInstance().blocking(s[x][z].getPiece());
										GameManager.getInstance().attacking(this);
									}
									return null;
								}
								else if (s[x][z].getCol()== squareCol && s[x][z].getRow() == squareRow
										&& s[x][z].getVaccancy() == true )
								{
                                    System.out.println("============");
									return s[x][z];
								}
								else if (z == squareCol )
								{
									System.out.println("Cant move there\n");
                                    System.out.println("============");
									return null;
								}
								else
								{
									x--;
									if (x > 7 || x < 0) {
                                        System.out.println("============");
                                        return null;
                                    }
								}
							}// end for
						} // end if
						// upRight
						else if (squareRow < pRowLocation && squareCol > p.getCol() )
						{
							int x = (pRowLocation - 1);

							for (int z = (p.getCol() + 1); z<=squareCol; z++)
							{
								System.out.println("Processing move[" +x+"][" +z+ "]");

								if(s[x][z].getCol() == squareCol && s[x][z].getRow()  == squareRow && s[x][z].getVaccancy() == false
										&& p.getColor() != s[x][z].getPiece().getColor() )
								{
									if (GameManager.getInstance().isProcessingKing() == false)
									{
										p.takePiece(s[x][z].getPiece());
                                        System.out.println("============");
										return s[x][z];
									}
									else {
                                        System.out.println("============");
                                        return s[x][z];
                                    }
								}
								else if ( s[x][z].getVaccancy() == false )
								{
									System.out.println("UpRight Blocked\n");
                                    System.out.println("============");
									if (GameManager.getInstance().isProcessingKing()) {
										GameManager.getInstance().blocking(s[x][z].getPiece());
										GameManager.getInstance().attacking(this);
									}
									return null;
								}
								else if (s[x][z].getCol() == squareCol && s[x][z].getRow() == squareRow
										&& s[x][z].getVaccancy() == true )
								{
                                    System.out.println("============");
                                    return s[x][z];
								}
								else if (z == squareCol )
								{
									System.out.println("Cant move there\n");
                                    System.out.println("============");
									return null;
								}
								else
								{
									x--;

									if (x > 7 || x < 0) {
                                        System.out.println("============");
                                        return null;
                                    }
								}
							}// end for
						} // end  else if
						// downLeft
						else if (squareRow > (int) pRowLocation && squareCol < p.getCol() )
						{
							int x = (pRowLocation + 1);

							for (int z = (p.getCol() - 1); z>=squareCol; z--)
							{
								System.out.println("Processing move[" +x+"][" +z+ "]");

								if(s[x][z].getCol() == squareCol && s[x][z].getRow() == squareRow && s[x][z].getVaccancy() == false
										&& p.getColor() != s[x][z].getPiece().getColor() )
								{
									if (GameManager.getInstance().isProcessingKing() == false)
									{
										p.takePiece(s[x][z].getPiece());
                                        System.out.println("============");
                                        return s[x][z];
									}
									else {
                                        System.out.println("============");
                                        return s[x][z];
                                    }
                                }
								else if ( s[x][z].getVaccancy() == false )
								{
									System.out.println("DownLeft Blocked\n");
                                    System.out.println("============");
									if (GameManager.getInstance().isProcessingKing()) {
										GameManager.getInstance().blocking(s[x][z].getPiece());
										GameManager.getInstance().attacking(this);
									}
									return null;
								}
								else if (s[x][z].getCol() == squareCol && s[x][z].getRow()== squareRow
										&& s[x][z].getVaccancy() == true )
								{
                                    System.out.println("============");
                                    return s[x][z];
								}
								else if (z == squareCol )
								{
									System.out.println("Cant move there\n");
                                    System.out.println("============");
									return null;
								}
								else
								{
									x++;
									if (x > 7 || x < 0){
                                        System.out.println("============");
                                        return null;
                                    }

								}
							}// end for
						} // end else if
						// downRight
						else if (squareRow > (int) pRowLocation && squareCol > p.getCol() )
						{
							int x = (int) (pRowLocation + 1);

							for (int z = (p.getCol() + 1); z<=squareCol; z++)
							{
								System.out.println("Processing move[" +x+"][" +z+ "]");

								if(s[x][z].getCol() == squareCol && s[x][z].getRow() == squareRow && s[x][z].getVaccancy() == false
										&& p.getColor() != s[x][z].getPiece().getColor() )
								{
									if (GameManager.getInstance().isProcessingKing() == false)
									{
										p.takePiece(s[x][z].getPiece());
                                        System.out.println("============");
                                        return s[x][z];
									}
									else{
                                        System.out.println("============");
                                        return s[x][z];
                                    }
                                }
								else if ( s[x][z].getVaccancy() == false )
								{
									System.out.println("DownRight Blocked\n");
                                    System.out.println("============");
									if (GameManager.getInstance().isProcessingKing()) {
										GameManager.getInstance().blocking(s[x][z].getPiece());
										GameManager.getInstance().attacking(this);
									}
									return null;
								}
								else if (s[x][z].getCol()== squareCol && s[x][z].getRow()== squareRow
										&& s[x][z].getVaccancy() == true )
								{
                                    System.out.println("============");
                                    return s[x][z];
								}
								else if (z == squareCol )
								{
									System.out.println("Cant move there\n");
                                    System.out.println("============");
									return null;
								}
								else
								{
									x++;
									if (x > 7 || x < 0){
                                        System.out.println("============");
                                        return null;
                                    }

								}
							}// end for
						} // end else if
						else
						{
							System.out.println("Cant move there\n");
                            System.out.println("============");
							return null;
						}// end else
					} // end if
				} // end for
			} // end for
		} // end else
		return null;
	} // end canMove
} // end bishop


