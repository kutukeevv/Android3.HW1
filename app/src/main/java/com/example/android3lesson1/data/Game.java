package com.example.android3lesson1.data;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Game<CardContent> {

    private final List<Card<CardContent>> cards = new ArrayList<>();

    public Game(List<CardContent> contents){
        for (int i = 0; i < contents.size(); i++) {
            cards.add(new Card<>((i + 1) * 2, false, false, contents.get(i)));
            cards.add(new Card<>(i * 2, false, false, contents.get(i)));
            Collections.shuffle(cards);
        }
    }

    public void choose(Card<CardContent> card){
        card.setFaceUp(!card.isFaceUp());
        if (card.isFaceUp()){
            chekPairs(card);
        }
    }

    private void chekPairs(Card<CardContent> card) {
        for (Card<CardContent> anotherCard : cards){
            if (card.isFaceUp() && anotherCard.isFaceUp()){
                if (card.equals(anotherCard) && card.getId() != anotherCard.getId()){
                    card.setMatch(true);
                    anotherCard.setMatch(true);
                }else if (!card.equals(anotherCard)){
                    card.setFaceUp(false);
                    anotherCard.setFaceUp(false);
                }
            }
        }
        remove();
    }

    private void remove() {
        List <Card<CardContent>> result = new ArrayList<>(cards);
        for (Card<CardContent> contentCard : cards){
            if (contentCard.isMatch()){
                result.remove(contentCard);
            }
        }
        cards.clear();
        cards.addAll(result);
    }

    public List<Card<CardContent>> getCards() {
        return cards; }
}
