package com.example.teramino.playchess.Pieces;

import android.graphics.drawable.Drawable;
import android.view.Gravity;
import android.widget.FrameLayout;
import android.widget.ImageView;

import com.example.teramino.playchess.R;
import com.example.teramino.playchess.Setup.*;
/**
 * Created by teramino on 3/8/16.
 */
public class Piece {

    protected ImageView image;
    protected String name;
    protected String color;
    private Piece takenPiece;
    protected Square s;
    private Square takenSquare;
    private boolean isActive;
    protected boolean hasMoved  = false;
    private boolean destroyed = false;
    protected int numRows = 8;
    protected int numCols = 8;
    protected int row;
    protected int col;


    public Piece() {}

    public Piece(ImageView image) {
        this.image = image;
    }

    public ImageView getImage() {
        return image;
    }

    public void setImage(ImageView image) {
        this.image = image;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public int getRow() {
        return row;
    }

    public void setRow(int row) {
        this.row = row;
    }

    public int getCol() {
        return col;
    }

    public void setCol(int col) {
        this.col = col;
    }

    public Piece getTakenPiece() {
        return takenPiece;
    }

    public void setTakenPiece(Piece takenPiece) {
        this.takenPiece = takenPiece;
    }

    public Square getSquare() {
        return s;
    }

    public void setSquare(Square s) {
        this.s = s;
//        this.row = s.getRow();
//        this.col = s.getCol();

        s.setPiece(this);
    }

    public void disableSquare() {
        this.s.disablePiece();
        this.s = null;
    }

    public Square getTakenSquare() {
        return takenSquare;
    }

    public void setTakenSquare(Square takenSquare) {
        this.takenSquare = takenSquare;
    }

    public boolean isActive() {
        return isActive;
    }

    public void setInActive()
    {
        isActive = false;
    }

    public void setActive()
    {
        isActive = true;
    }

    public void setHasMoved(boolean hasMoved) {
        this.hasMoved = hasMoved;
    }

    public boolean getHasMoved() {
        return hasMoved;
    }

    public boolean isDestroyed() {
        return destroyed;
    }

    public void setDestroyed(boolean destroyed) {
        this.destroyed = destroyed;
    }

    public void takePiece(Piece p) {
        // set a destroyed boolean to control a piece taken


        Board.getInstance().setJumped(true);

        takenPiece = p;
        takenSquare = p.s;
        p.destroyed = true;
        p.disableSquare();


        System.out.println(p.getName() + " Jumped by " + this.getName() + "\n");
    }

    public Square canMove(Piece p, Square [][] s, int squareCol, int squareRow)
    {
        return null;
    }
    
    public void doMove(Piece [] p, Square [][] s, int squareCol, int squareRow) {


        for(int i=0; i<p.length;i++)
        {
            if (p[i].isActive() && p[i].isDestroyed() == false )
            {
                Square ss = p[i].canMove( p[i], s, squareCol, squareRow);
                if (ss != null )
                {
                    Drawable d = p[i].image.getDrawable();

                    if (d == null) {
                        System.out.println("WTF!");
                        System.out.println("====================");
                    }
                    else {

                        transferImage(ss, p[i], ss.getCol(), ss.getRow());

//                        // transfer image
//                        ImageView newSquare = (ImageView) ss.getSquare().findViewById(R.id.piece);
//                        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(110, 110);
//                        params.gravity = Gravity.CENTER;
//                        newSquare.setLayoutParams(params);
//                        // needs to be config based on players color
//
//
//
//                        newSquare.setImageDrawable(p[i].image.getDrawable());
//
//                        ImageView oldSquare = (ImageView) p[i].getSquare().getSquare().findViewById(R.id.piece);
//                        oldSquare.setImageDrawable(null);
//
//
//
////                    // set row and col of piece
//                        // set by call to setSquare
////                    myPieces[j].setRow(i);
////                    myPieces[j].setCol(j);
//
//                        p[i].disableSquare();
//                        p[i].setSquare(ss);
//
//                        // relink piece image with new square image view
//                        p[i].setImage(newSquare);

                        this.hasMoved = true;
                    }

                    if (GameManager.getInstance().getKingCheck() == true && p[i].getColor() == "Black" && GameManager.getInstance().isKingChecked(
                            Board.getInstance().getOppPieces(),
                            Board.getInstance().getMyKing(),
                            Board.getInstance().getSquares(),
                            Board.getInstance().getMyKing().getRow(),
                            Board.getInstance().getMyKing().getCol()) == true )
                    {
                        System.out.println("Can't move " +p[i].getName() +"... " +Board.getInstance().getMyKing().getName() + " still in check");
                        System.out.println("====================");

                        Board.getInstance().cancelMove();

                        return;
                    }

                    else if(GameManager.getInstance().getKingCheck() == true && p[i].getColor() == "White" && GameManager.getInstance().isKingChecked(
                            Board.getInstance().getMyPieces(),
                            Board.getInstance().getOppKing(),
                            Board.getInstance().getSquares(),
                            Board.getInstance().getOppKing().getRow(),
                            Board.getInstance().getOppKing().getCol()))
                    {
                        System.out.println("Can't move " +p[i].getName()+ "... " +Board.getInstance().getMyKing().getName() + " still in check");
                        System.out.println("====================");

                        Board.getInstance().cancelMove();

                        return;
                    }
                    else if (p[i].getColor() == "Black" &&  GameManager.getInstance().isKingChecked(
                            Board.getInstance().getOppPieces(),
                            Board.getInstance().getMyKing(),
                            Board.getInstance().getSquares(),
                            Board.getInstance().getMyKing().getRow(),
                            Board.getInstance().getMyKing().getCol()) == true )
                    {
                        System.out.println("Can't move " +p[i].getName() +"... " +Board.getInstance().getMyKing().getName() + " can be attacked");
                        System.out.println("====================");

                        Board.getInstance().cancelMove();

                        return;
                    }

                    else if(p[i].getColor() == "White" && GameManager.getInstance().isKingChecked(
                            Board.getInstance().getMyPieces(),
                            Board.getInstance().getOppKing(),
                            Board.getInstance().getSquares(),
                            Board.getInstance().getOppKing().getRow(),
                            Board.getInstance().getOppKing().getCol()))
                    {
                        System.out.println("Can't move " +p[i].getName()+ "... " +Board.getInstance().getMyKing().getName() + " can be attacked");
                        System.out.println("====================");

                        Board.getInstance().cancelMove();

                        return;
                    }
                    else
                    {


                        // displays confirm move to textArea after each move until confirmed or canceled
//                        Board.getInstance().setDisplayConfirm (true);
//                        Options.getInstance().displayConfirmMessage();

                        return;
                    }
                }
                else // resets after invalid move
                {
                    System.out.println("Invalid move...Removing " + Board.getInstance().getPieceList().get(
                            Board.getInstance().getPieceListCount() - 1).getName() + " from piece list\n");
                    System.out.println("====================");

                    Board.getInstance().getPieceList().remove(Board.getInstance().getPieceListCount() - 1);
                    Board.getInstance().setPieceListCount(Board.getInstance().getPieceListCount() - 1);

                    System.out.println("Piece List: ");
                    for( ListFactory print : Board.getPieceList())
                    {
                        System.out.println(print.getName());
                    }
                    System.out.println("====================");

                    p[i].setInActive();

                    Board.getInstance().setActivePiece(null);
                    return;
                }

            }
        }
    }

    public void transferImage(Square ss, Piece p, int newSqaureCol, int newSqaureRow ){
        // transfer image
        ImageView newSquare = (ImageView) ss.getSquare().findViewById(R.id.piece);
        FrameLayout.LayoutParams params = new FrameLayout.LayoutParams(110, 110);
        params.gravity = Gravity.CENTER;
        newSquare.setLayoutParams(params);
        // needs to be config based on players color


        newSquare.setImageDrawable(p.image.getDrawable());

            ImageView oldSquare = (ImageView) p.getSquare().getSquare().findViewById(R.id.piece);
            oldSquare.setImageResource(android.R.color.transparent);
            p.disableSquare();
//        }

        // row and column are set by call to setSquare
        p.setSquare(ss);

        p.setRow(newSqaureRow);
        p.setCol(newSqaureCol);

        // relink piece image with new square image view
        p.setImage(newSquare);
    }

}
