package com.example.teramino.playchess.Setup;

import android.graphics.Color;
import android.view.LayoutInflater;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;
import android.content.Context;
import android.view.View;

import com.example.teramino.playchess.R;

/**
 * Created by joelbateman on 9/9/16.
 */

/*

 // Large Goals
 1) 2x2 array with each square controlling a different function
 2) All four squares combine to show a complete photo of the activePiece
 3)

 // Small Goals
 1) Find out how TableRow works
 2) Find out how LayoutInflater works
 3) Find out how ImageView works

 Pick back up at building PiecePad preview implementation
    - Active Piece Check

 */

public class PiecePad {

    // Class variables
    private TableLayout piecePad;
    private Square [][] buttons;
    int numRows = 2;
    int numCols = 2;
    private Square buttonClicked;
    private Context piecePadContext;

    // Class Functions //

    // Function that sets up the builds the piecePad
    private void setPiecePad(){

        // Create Pad
        buttons = new Square[numRows][numCols];

        // outer loop to create Row
        for(int row=0; row<numRows; row++){

            // What is this all about?
            TableRow tr = new TableRow(piecePadContext);
            tr.setLayoutParams(new TableRow.LayoutParams(TableRow.LayoutParams.MATCH_PARENT, TableRow.LayoutParams.WRAP_CONTENT));

            // inner loop to create Col
            for(int col=0;col<numCols;col++){

                // Create each square at current RowxCol
                buttons[row][col] = new Square();

                // What is this all about?
                final LayoutInflater layoutInflater = LayoutInflater.from(piecePadContext);
                View squareContainerView = layoutInflater.inflate(R.layout.square, null);

                // What is this all about?
                final ImageView squareView =
                        (ImageView) squareContainerView.findViewById(R.id.square_background);
                squareView.setLayoutParams(new FrameLayout.LayoutParams(135, 135));

                // Paint Each of the four squares with the intended 4 way split piece photo
                if(row==0 && col==0 ){
                    squareView.setBackgroundColor(Color.RED);
                }
                else if(row==1 && col==0 ){
                    squareView.setBackgroundColor(Color.YELLOW);

                }
                else if(row==1 && col==1 ){
                    squareView.setBackgroundColor(Color.BLACK);
                }
                else if(row==0 && col==1 ){
                    squareView.setBackgroundColor(Color.GREEN);
                }


                // Shows which of the square was clicked.
                //  Needs to be moved to ActionListener.
                if(row==0 && col==0 ){
                    System.out.println("Top Left Square Clicked");

                }
                else if(row==1 && col==0 ){
                    System.out.println("Bottom Left Square Clicked");

                }
                else if(row==1 && col==1 ){
                    System.out.println("Bottom Right Square Clicked");

                }
                else if(row==0 && col==1 ){
                    System.out.println("Top Right Square Clicked");

                }
            }
        }
    } // End of setPiecePad Function

    // When piece is made active, active piece is checked, if active piece 
    // photo is placed on 4 buttons to show complete piece
    public void updateActivePiecePhoto(){

        // Call to board class to check if there is an Active piece
        if(Board.getInstance().getActivePiece().isActive()){

        }
    }

} // End of PiecePad Class
