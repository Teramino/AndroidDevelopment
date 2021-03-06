package com.example.teramino.playchess.Activity;

import android.content.Intent;
import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.teramino.playchess.Pieces.Piece;
import com.example.teramino.playchess.R;
import com.example.teramino.playchess.Setup.Board;
import com.example.teramino.playchess.Setup.GameManager;
import com.example.teramino.playchess.Setup.Square;
import com.firebase.client.Firebase;
import com.firebase.client.FirebaseError;

import java.util.Map;

public class ChessActivity extends AppCompatActivity {

    private TableLayout chessBoard;
    private Square[][] squares;
    private Piece[] myPieces;
    private Piece [] oppPieces;

    private final int numCols = 8;
    private final int numRows = 8;

   public Firebase mRef;

    public Button restart;
    public Button activePiece;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chess_board);

        activePiece = (Button) findViewById(R.id.activePieceButton);

        restart = (Button) findViewById(R.id.restartButton);

        chessBoard = (TableLayout) findViewById(R.id.board);

        Board board = Board.getInstance();
        board.getInstance().setupGame(this, chessBoard);

    }


    public void restartButton(View v){
        Intent i = new Intent(this, MainActivity.class);
        i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP| Intent.FLAG_ACTIVITY_NEW_TASK);
        startActivity(i);
    }

    public void activePieceButton(View v){

        // Test Output
        System.out.println("Active Piece Print");

        // Check if an Active Piece is selected

        // Retrieve all possible moves for Active Piece

        // Paint all possible squares that can be moved to


    }


//    private void initSquares() {
//        for (int i = 0; i < 8; i++) {
//            for (int j = 0; j < 8; j++) {
//                Square s = new Square();
//                s.color = (i + j) % 2;
//                squares[j + 8 * i] = s;
//            }
//        }
//    }

}
