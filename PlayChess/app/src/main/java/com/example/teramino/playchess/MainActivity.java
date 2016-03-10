package com.example.teramino.playchess;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.TableLayout;
import android.widget.TableRow;

import com.example.teramino.playchess.Pieces.Piece;
import com.example.teramino.playchess.Setup.Board;
import com.example.teramino.playchess.Setup.Square;

public class MainActivity extends AppCompatActivity {

    private TableLayout chessBoard;
    private Square[][] squares;
    private Piece[] myPieces;
    private Piece [] oppPieces;

    private final int numCols = 8;
    private final int numRows = 8;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.chess_board);

        chessBoard = (TableLayout) findViewById(R.id.board);

        Board board = Board.getInstance();
        board.getInstance().setupGame(this, chessBoard);
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
