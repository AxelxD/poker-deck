package com.miguelpineda.poker;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Random;

/**
 * Representa un Deck (baraja) de poker de 52 cartas.
 * Tiene dos atributos del Collection Framework:
 * - cards: cartas disponibles
 * - dealt: historial de cartas removidas
 */
public class Deck {

    // 2 atributos solicitados (Collection Framework)
    private final List<Card> cards = new ArrayList<>();
    private final List<Card> dealt = new ArrayList<>();

    private final Random random = new Random();

    public Deck() {
        init52Cards();
    }

    private void init52Cards() {
        cards.clear();
        dealt.clear();

        for (Card.Suit suit : Card.Suit.values()) {
            for (Card.Rank rank : Card.Rank.values()) {
                cards.add(new Card(suit, rank));
            }
        }

        if (cards.size() != 52) {
            throw new IllegalStateException("El deck debe contener 52 cartas. Size=" + cards.size());
        }
    }

    /**
     * shuffle: mezcla el deck.
     * Imprime: "Se mezcló el Deck."
     */
    public void shuffle() {
        Collections.shuffle(cards, random);
        System.out.println("Se mezcló el Deck.");
        System.out.println();
    }

    private void ensureNotEmpty() {
        if (cards.isEmpty()) {
            throw new IllegalStateException("No hay cartas disponibles en el deck.");
        }
    }

    /**
     * head: muestra la primera carta del deck y la remueve.
     * Imprime:
     * {Palo},{Color},{Valor}
     * Quedan {n} cartas en deck
     */
    public void head() {
        ensureNotEmpty();
        Card c = cards.remove(0);
        dealt.add(c);

        System.out.println(c);
        System.out.println("Quedan " + cards.size() + " cartas en deck");
        System.out.println();
    }

    /**
     * pick: selecciona una carta al azar del deck y la remueve.
     */
    public void pick() {
        ensureNotEmpty();
        int idx = random.nextInt(cards.size());
        Card c = cards.remove(idx);
        dealt.add(c);

        System.out.println(c);
        System.out.println("Quedan " + cards.size() + " cartas en deck");
        System.out.println();
    }

    /**
     * hand: regresa un arreglo de 5 cartas (y las remueve).
     */
    public Card[] hand() {
        if (cards.size() < 5) {
            throw new IllegalStateException("No hay suficientes cartas para una mano de 5. Quedan: " + cards.size());
        }

        Card[] hand = new Card[5];
        for (int i = 0; i < 5; i++) {
            Card c = cards.remove(0);
            dealt.add(c);
            hand[i] = c;
        }

        for (Card c : hand) {
            System.out.println(c);
        }
        System.out.println("Quedan " + cards.size() + " cartas en deck");
        System.out.println();

        return hand;
    }

    public int remainingCards() {
        return cards.size();
    }

    public List<Card> dealtSnapshot() {
        return List.copyOf(dealt);
    }
}
