package com.example.android3lesson1.ui;

import android.os.Build;

import androidx.annotation.RequiresApi;

import com.example.android3lesson1.data.Card;
import com.example.android3lesson1.data.Game;

import java.util.List;

public class EmojiGame {

    private final Game<String> game;

    @RequiresApi(api = Build.VERSION_CODES.R)
    public EmojiGame(){
        List<String> contents = List.of("🤡", "👮", "🙀", "🐉");
        game = new Game(contents);
    }

    public void choose(Card<String> card){
        game.choose(card);
    }

    public List<Card<String>> getCards(){
        return game.getCards();
    }

}
