package com.example.teramino.playchess;

import com.example.teramino.playchess.Pieces.Piece;

/**
 * Created by teramino on 3/15/16.
 */
public class Player {

    private Piece [] piece;
    private boolean turn;
    private String player;


    public Player(Piece [] p, String s){
        piece = p;
        player = s;
    }
}
