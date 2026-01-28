package com.miguelpineda.poker;

public class App {
    public static void main(String[] args) {
        Deck deck = new Deck();

        // Demostración del funcionamiento
        deck.shuffle();
        deck.head();
        deck.pick();
        deck.hand();

        // Ejecuciones extra para evidencia
        deck.pick();
        deck.head();
    }
}
