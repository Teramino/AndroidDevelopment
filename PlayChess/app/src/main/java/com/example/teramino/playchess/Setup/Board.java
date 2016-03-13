package com.example.teramino.playchess.Setup;

import android.content.Context;
import android.graphics.Color;
import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.teramino.playchess.Pieces.*;
import com.example.teramino.playchess.R;

import java.util.ArrayList;
import java.util.List;



//1. activate piece
//2. click the spot
//3. validate move
//4. write to file  
//5. read to file [Opp read]
//6. do move
//7. repaint

public class Board
{
	private TableLayout chessBoard;
	private Context context;
	private Piece[] myPieces;
	private Piece[] oppPieces;
	private Piece activePiece = null;
	private Square[][] squares;
	Square squareCheck;
	private static Board instance;
	int numRows = 8; 
	int numCols = 8;
	int col = 0, row = 0;
	int size = 50; 
	private int pieceListCount = 0;
	double loaderX;
	double loaderY;
	double pYLocation;
	int oldRow;
	int oldCol;
	private boolean displayConfirm = false;
	boolean yourTurn = false;
	boolean moveCheck = false;
	private boolean jumped = false;
	String loaderName;
	private Piece myKing;
	private Piece oppKing;
	private int player = 1;
	private int clicks = 0;
	private Square squareClicked;
	private boolean firstClick = true;
	private boolean secondClick = false;

	private Integer [] whitePieces = {
			R.drawable.white_rook, R.drawable.white_knight, R.drawable.white_bishop, R.drawable.white_king,
			R.drawable.white_queen, R.drawable.white_bishop, R.drawable.white_knight, R.drawable.white_rook,
			R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn,
			R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn, R.drawable.white_pawn
	};

	private Integer [] blackPieces = {
			R.drawable.black_rook, R.drawable.black_knight, R.drawable.black_bishop, R.drawable.black_king,
			R.drawable.black_queen, R.drawable.black_bishop, R.drawable.black_knight, R.drawable.black_rook,
			R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn,
			R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn, R.drawable.black_pawn
	};


	// whoever becomes player 0 they become the white pieces and vice versa
	// i hard coded to start at 0 but however you set up the player to be initialized the code is the pieces are initialized 
	// accordingly in the Board constructor
	// players have to be initialized before the setupBoard method is called which is called in board
	// i tried to flip the board by having the top row start off at the hightest and count down but didnt work
	// so i am just going to hard code it, but i do think we should look into that!
	// once you do a move the game goes in a frozen state waiting for the opponent to make a move
	// you have to make code when the oppenents move is made it sent to the board an updated and at that moment the opponents turn is ended
	// call GameManager.getInstance().endTurn(); I would suggest that would happen where the client is listening for a move
	// once it receives the move it draws it on the board and then u call the endturn method
	


	// Update the moves into ArrayList Dynamically
	private static List <ListFactory>pieceList = new ArrayList<ListFactory>();
	String pieceMoves;

	public static Board getInstance() {
		if( instance == null )
		{
			instance = new Board();
		}
		return instance;
	}

	private Board(){}

	public void setupGame(Context context, TableLayout chessBoard){
		this.context = context;
		this.chessBoard = chessBoard;

		setPieces();
		setBoard();
	}

	private void setPieces(){

		myPieces = new Piece[16];
		oppPieces = new Piece[16];

		// needs to be config based on players color
        myPieces[0] = new Rook("MY_Rook1", "White");
        myPieces[1] = new Knight("MY_Knight1", "White");
        myPieces[2] = new Bishop("MY_Bishop1", "White");
        setMyKing(myPieces[3] = new King("MY_King", "White"));
        myPieces[4] = new Queen("MY_Queen", "White");
        myPieces[5] = new Bishop("MY_Bishop2", "White");
        myPieces[6] = new Knight("MY_Knight2", "White");
        myPieces[7] = new Rook("MY_Rook2", "White");

        for (int i=8; i<myPieces.length; i++)
        {
            myPieces[i] = new Pawn("MY_Pawn" +i, "White");
        }

		// needs to be config based on players color
        oppPieces[0] = new Rook("OPP_Rook1", "Black");
        oppPieces[1] = new Knight("OPP_Knight1", "Black");
        oppPieces[2] = new Bishop("OPP_Bishop1", "Black");
        setOppKing(oppPieces[3] = new King("OPP_King", "Black"));
        oppPieces[4] = new Queen("OPP_Queen", "Black");
        oppPieces[5] = new Bishop("OPP_Bishop2", "Black");
        oppPieces[6] = new Knight("OPP_Knight2", "Black");
        oppPieces[7] = new Rook("OPP_Rook2", "Black");

        for (int i=8; i<getOppPieces().length; i++)
        {
            oppPieces[i] = new Pawn("OPP_Pawn" +i, "Black");
        }
	}

	private void setBoard(){

		squares = new Square[numRows][numCols];

		// used for pawns
		int count = 8;
		// row
		for (int i = 0; i < numRows; i++) {

			TableRow tr = new TableRow(context);
			tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));
			// col
			for (int j = 0; j < numCols; j++) {

				// initalize square
				squares[i][j] = new Square();

				// access Square layout
				final LayoutInflater layoutInflater = LayoutInflater.from(context);
				View squareContainerView = layoutInflater.inflate(R.layout.square, null);

				final ImageView squareView =
						(ImageView) squareContainerView.findViewById(R.id.square_background);
				squareView.setLayoutParams(new FrameLayout.LayoutParams(135, 135));

				if(i%2 == 0)
				{
					if(j%2==0)
						squareView.setBackgroundColor(Color.WHITE);
					else
						squareView.setBackgroundColor(Color.RED);
				}
				else
				{
					if(j%2==0)
						squareView.setBackgroundColor(Color.RED);
					else
						squareView.setBackgroundColor(Color.WHITE);
				}

				//myPiece first row
				if (i == 7)
				{
					getMyPieces()[j].setSquare(getSquares()[i][j]);
					ImageView piece = (ImageView) squareContainerView.findViewById(R.id.piece);
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(110,110);
                    params.gravity= Gravity.CENTER;
                    piece.setLayoutParams(params);
					// needs to be config based on players color
					piece.setImageDrawable(context.getResources().getDrawable(whitePieces[j]));
//                    piece.setImageResource(whitePieces[j]);

					// set row and col of piece
					myPieces[j].setRow(i);
					myPieces[j].setCol(j);

					// set image
					myPieces[j].setImage(piece);

				}
				// myPiece second row
				else if (i == 6)
				{
					getMyPieces()[count].setSquare(getSquares()[i][j]);
					ImageView piece = (ImageView) squareContainerView.findViewById(R.id.piece);
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(110,110);
					params.gravity= Gravity.CENTER;
                    piece.setLayoutParams(params);
					// needs to be config based on players color
					piece.setImageDrawable(context.getResources().getDrawable(whitePieces[count]));
//                    piece.setImageResource(whitePieces[count]);

					// set row and col of piece
					myPieces[count].setRow(i);
					myPieces[count].setCol(j);

					// set image
					myPieces[count].setImage(piece);

					count++;
				}
				//oppPiece second row
				else if (i == 1)
				{
					getOppPieces()[count].setSquare(getSquares()[i][j]);
					ImageView piece = (ImageView) squareContainerView.findViewById(R.id.piece);
                    FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(110,110);
                    params.gravity= Gravity.CENTER;
                    piece.setLayoutParams(params);
					// needs to be config based on players color
					piece.setImageDrawable(context.getResources().getDrawable(blackPieces[count]));
//                    piece.setImageResource(blackPieces[count]);

					// set row and col of piece
					oppPieces[count].setRow(i);
					oppPieces[count].setCol(j);

					// set image
					oppPieces[count].setImage(piece);

					count++;
				}
				// oppPiece first row
				else if (i == 0)
				{
					getOppPieces()[j].setSquare(getSquares()[i][j]);
					ImageView piece = (ImageView) squareContainerView.findViewById(R.id.piece);
					FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(110,110);
					params.gravity= Gravity.CENTER;
					piece.setLayoutParams(params);
					// needs to be config based on players color
					piece.setImageDrawable(context.getResources().getDrawable(blackPieces[j]));
//					piece.setImageResource(blackPieces[j]);

					// set row and col of piece
					oppPieces[j].setRow(i);
					oppPieces[j].setCol(j);

					// set image
					oppPieces[j].setImage(piece);

				}
                squareContainerView.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View v) {

						// find square clicked
						squareClicked = findSquareClicked(v);

						// first click
						for (int i = 0; i < myPieces.length; i++) {
							if (myPieces[i].getRow() == squareClicked.getRow() && myPieces[i].getCol() == squareClicked.getCol() && myPieces[i].isDestroyed() == false) {

								// deactivate piece if already activated
								if (myPieces[i].isActive()) {
									myPieces[i].setInActive();
									System.out.println("Deactivate\n");
									System.out.println("====================");
									activePiece = null;
									return;
								}
								// active piece
								else {
									if (activePiece == null) // (once activePiece is initialized this block of code is jumped)
									{
										// checks that it is this players turn and that moveConfirm has been clicked
//										if (GameManager.getInstance().getPlayerTurn() == true
//												&& GameManager.getInstance().getMoveConfirm() == true) {

										if (myPieces[i].isActive() == false) {
											myPieces[i].setActive();

											// print out name | use this to set piece name and original piece location
											System.out.println(myPieces[i].getName());
											// positions printing our wrong
											System.out.println("Row: " + myPieces[i].getRow() + " Col: " + myPieces[i].getCol() + "\n");

											//save the piece and x,y for cancelMove()
											oldRow = myPieces[i].getRow();
											oldCol = myPieces[i].getCol();
											activePiece = myPieces[i];

											return;
										}// end if

//										} // end if(player move check)

										else if (GameManager.getInstance().getMoveConfirm() == false) {
											System.out.println("Move not confirmed\n");
											return;
										} else {
											System.out.println("Clicked " + myPieces[i].getName());
											System.out.println("OPP turn to move");
											System.out.println("Confirm: " + GameManager.getInstance().getMoveConfirm());
											System.out.println("Turn: " + GameManager.getInstance().getPlayerTurn() + "\n");
											System.out.println("====================");
										}
									}// end if(once activePiece is initialized this block of code is jumped)
								}// end else if
							} // end if

						} // end for

						// second click piece will move
						// verifies second click is on the board
						// invalid click
						for (int i = 0; i < getBoardSquare().length; i++) {

							boolean contains = false;
							for (int j = 0; j < getBoardSquare()[i].length; j++) {

								if (activePiece != null && getBoardSquare()[i][j].getRow() == activePiece.getRow() && getBoardSquare()[i][j].getCol() == activePiece.getCol()) {
									contains = true;
									break;
								}

                                // I dont think this block is needed
//								// if there is a click off the board
//								else if (i == getBoardSquare().length - 1 && j == getBoardSquare()[i].length - 1) {
//
//									System.out.println("Can't click there\n");
//									System.out.println("====================");
//									if (activePiece != null)
//										activePiece.setInActive();
//									activePiece = null;
//									return;
//								}
							}
							if (contains)
								break;
						}

						// valid click
						for (int x = 0; x < myPieces.length; x++) {
							if (myPieces[x].isActive() || oppPieces[x].isActive()) {

								col = squareClicked.getCol();
								row = squareClicked.getRow();


								System.out.println(activePiece.getClass());

								// send moves to array list from here
								System.out.println("To space");
								System.out.println("Row: " + row + " Col: " + col + "\n");
								System.out.println("====================");

								loaderName = activePiece.getName();
								loaderX = col;
								loaderY = row;
								Loader();

								if (activePiece.getClass().toString().equalsIgnoreCase("class com.example.teramino.playchess.Pieces.King")) {

									activePiece.doMove(oppPieces, getBoardSquare(), col, row);

								} else if (myPieces[x].isActive()) {

									activePiece.doMove(myPieces, getBoardSquare(), col, row);
								}

								if (activePiece != null) {
                                    System.out.print("OPP_");
									GameManager.getInstance().setKingCheck(
											GameManager.getInstance().isKingChecked(getMyPieces(),
													oppKing, getSquares(), oppKing.getRow(), oppKing.getCol()));

									// redraw the image
//								repaint();

									// this code was used in move confirmed

									// once these pieces have moved their special move can't happen anymore
									if (Board.getInstance().getActivePiece() instanceof Pawn)
									{
										Pawn pawn = (Pawn) Board.getInstance().getActivePiece();
										GameManager.getInstance().setPawnMoved(true, pawn);
									}
									if (Board.getInstance().getActivePiece() instanceof Rook)
									{
										Rook rook = (Rook) Board.getInstance().getActivePiece();
										GameManager.getInstance().setRookMoved(true, rook);
									}
									if (Board.getInstance().getActivePiece() instanceof King)
									{
										King king = (King) Board.getInstance().getActivePiece();
										GameManager.getInstance().setKingMoved(true, king);
									}


									Board.getInstance().getActivePiece().setInActive();
									Board.getInstance().getActivePiece().setHasMoved(false);
									Board.getInstance().setActivePiece(null);
									Board.getInstance().setJumped(false);
								}
								return;
							}// end if

						} // end for
					} // end on click
				});

				// set view as Square
				squares[i][j].setSquare(squareContainerView);

				// set row and col of square
				squares[i][j].setRow(i);
				squares[i][j].setCol(j);

				tr.addView(squareContainerView);


			}// end second for
			count = 8;
			chessBoard.addView(tr);
//            count = 8;
		}// end first for
	}

	public Square findSquareClicked(View v){

			Square s = new Square();
			boolean breakLoop = false;

			for (int x = 0; x < numRows; x++) {
				for (int y = 0; y < numCols; y++) {
					if (squares[x][y].getSquare() == v) {

						s = squares[x][y];
						breakLoop = true;
						break;
					}
				}
				if (breakLoop)
					break;
			}
			return s;
	}

	// Loader for Moves List
	public void Loader() {
		ListFactory p = null;

		p = new ListFactory(null, 0, 0);
		p.setName(loaderName);
		p.setRow(loaderY);
		p.setCol(loaderX);

		getPieceList().add(p);
		setPieceListCount(getPieceListCount() + 1);

		System.out.println("Piece List: ");
		for( ListFactory print : Board.getPieceList())
		{
			System.out.println(print.getName());
		}
		System.out.println("====================");
	}

	public void cancelMove() {
		if (activePiece != null && activePiece.getHasMoved() == true)
		{

            Drawable d = activePiece.getImage().getDrawable();

            if (d == null) {
                System.out.println("WTF!");
                System.out.println("====================");
            }
            else {

                activePiece.transferImage(getBoardSquare()[oldRow][oldCol], activePiece, oldCol, oldRow);

//                // transfer image
//                ImageView oldSquare = (ImageView) getBoardSquare()[oldRow][oldCol].getSquare().findViewById(R.id.piece);
//                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(110, 110);
//                params.gravity = Gravity.CENTER;
//                oldSquare.setLayoutParams(params);
//                // needs to be config based on players color
//
//
//                oldSquare.setImageDrawable(activePiece.getImage().getDrawable());
//
//                ImageView newSquare = (ImageView) activePiece.getSquare().getSquare().findViewById(R.id.piece);
//                newSquare.setImageDrawable(null);
//
//                activePiece.disableSquare();
//                activePiece.setSquare(getBoardSquare()[oldRow][oldCol]);
//                activePiece.setImage(oldSquare);
            }
			// need to fix this
			if ( activePiece instanceof King)
			{
				King k = (King) activePiece;
				if (GameManager.getInstance().isCastling())
				{
					GameManager.getInstance().setCastling(false);

					int rookOldRow = GameManager.getInstance().getOldRow();
					int rookOldCol = GameManager.getInstance().getOldCol();
					Rook rook = (Rook) GameManager.getInstance().getRook();

					rook.disableSquare();
					rook.setSquare(squares[rookOldCol][rookOldRow]);

					GameManager.getInstance().setCastling(false);
				}
			}
			if(jumped == true)
			{
//                activePiece.transferImage(
//                        activePiece.getTakenSquare(), activePiece.getTakenPiece(),
//                        activePiece.getTakenSquare().getCol(), activePiece.getTakenSquare().getRow());

                ImageView resetSquare = (ImageView)  activePiece.getTakenSquare().getSquare().findViewById(R.id.piece);
                FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(110, 110);
                params.gravity = Gravity.CENTER;
                resetSquare.setLayoutParams(params);
                // needs to be config based on players color

                d = activePiece.getTakenPiece().getImage().getDrawable();
                if (d == null){

                    System.out.println("This is the problem");
                    System.out.println("====================");
                }

                resetSquare.setImageDrawable(activePiece.getTakenPiece().getImage().getDrawable());

                // row and column are set by call to setSquare
                activePiece.getTakenPiece().setSquare(activePiece.getTakenSquare());

                activePiece.setRow(activePiece.getTakenSquare().getRow());
                activePiece.setCol(activePiece.getTakenSquare().getCol());

                // relink piece image with new square image view
                activePiece.getTakenPiece().setImage(resetSquare);

//				activePiece.getTakenPiece().setSquare(activePiece.getTakenSquare());
				activePiece.getTakenPiece().setDestroyed(false);

				System.out.println(activePiece.getTakenPiece().getName() +" visible");
				jumped = false;
			}
			if (GameManager.getInstance().getKingCheck() )
			{
				GameManager.getInstance().setKingCheck(false);
				if (activePiece.getColor() == "Black")
					System.out.println(oppKing.getName() +" Not Checked\n" +GameManager.getInstance().getKingCheck() );
				else
					System.out.println(myKing.getName() +" Not Checked\n" +GameManager.getInstance().getKingCheck() );
			}
			activePiece.setHasMoved(false);
			activePiece.setInActive();
			activePiece = null;

			System.out.println("Canceled");
			System.out.println("Removing " + getPieceList().get(getPieceListCount() - 1).getName() + "\n");
			getPieceList().remove(getPieceListCount() - 1);
			setPieceListCount(getPieceListCount() - 1);

            System.out.println("Piece List: ");
            for( ListFactory print : Board.getPieceList())
            {
                System.out.println(print.getName());
            }
            System.out.println("====================");

			// reload screen
//			repaint();

		}
	}

	public TableLayout getChessBoard() {
		return chessBoard;
	}

	public void setChessBoard(TableLayout chessBoard) {
		this.chessBoard = chessBoard;
	}

	public Context getContext() {
		return context;
	}

	public void setContext(Context context) {
		this.context = context;
	}

	public static List <ListFactory> getPieceList() {
		return pieceList;
	}

	public static void setPieceList(List <ListFactory> pieceList) {
		Board.pieceList = pieceList;
	}

	public int getPieceListCount() {
		return pieceListCount;
	}

	public void setPieceListCount(int pieceListCount) {
		this.pieceListCount = pieceListCount;
	}

	public void setActivePiece(Piece activePiece) {
		this.activePiece = activePiece;
	}

	public boolean getDisplayConfirm() {
		return displayConfirm;
	}

	public void setDisplayConfirm(boolean displayConfirm) {
		this.displayConfirm = displayConfirm;
	}

	public boolean getJumped() {
		return jumped;
	}

	public void setJumped(boolean jumped) {
		this.jumped = jumped;
	}

	public Piece getActivePiece()
	{  
		return activePiece; 	
	}  // end getActivePiece

	public Piece getMyKing() {
		return myKing;
	}

	public void setMyKing(Piece myKing) {
		this.myKing = myKing;
	}

	public Piece getOppKing() {
		return oppKing;
	}

	public void setOppKing(Piece oppKing) {
		this.oppKing = oppKing;
	}

	public Piece[] getMyPieces() {
		return myPieces;
	}

	public void setMyPieces(Piece[] myPieces) {
		this.myPieces = myPieces;
	}

	public Square[] [] getSquares() {
		return getBoardSquare();
	}

	public void setSquares(Square[] [] squares) {
		this.setBoardSquare(squares);
	}

	public Piece[] getOppPieces() {
		return oppPieces;
	}

	public void setOppPieces(Piece[] oppPieces) {
		this.oppPieces = oppPieces;
	}

	public Square[] [] getBoardSquare() {
		return squares;
	}

	public void setBoardSquare(Square[] [] square) {
		this.squares = square;
	}
}// end board
