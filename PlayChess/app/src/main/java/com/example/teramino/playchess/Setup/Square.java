package com.example.teramino.playchess.Setup;

import android.view.View;

import com.example.teramino.playchess.Pieces.Piece;

/**
 * Created by teramino on 3/8/16.
 */
public class Square {

    private boolean vaccant = true;
    private View square;
    private Piece piece;
    private int row;
    private int col;
    private String color;

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

    public Square() {}

    public View getSquare() {
        return square;
    }

    public void setSquare(View square) {
        this.square = square;
    }

    public Piece getPiece() {
        return piece;
    }

    public void setPiece(Piece p) {
        this.piece = p;
        this.vaccant = false;
    }

    public void disablePiece() {
        this.piece = null;
        this.vaccant = true;
    }

    public boolean getVaccancy()
    {
        return vaccant;
    }

    public void setVaccancy(boolean n)
    {
        vaccant = n;
    }

}

