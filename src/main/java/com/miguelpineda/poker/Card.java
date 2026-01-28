package com.miguelpineda.poker;

/**
 * Representa una carta de poker.
 * - Palo: tréboles, corazones, picas, diamantes
 * - Color: negro o rojo (derivado del palo)
 * - Valor: 2-10, A, J, Q, K
 */
public class Card {

    public enum Color {
        ROJO("Rojo"),
        NEGRO("Negro");

        private final String display;

        Color(String display) {
            this.display = display;
        }

        public String display() {
            return display;
        }
    }

    public enum Suit {
        TREBOLES("Tréboles", Color.NEGRO),
        CORAZONES("Corazones", Color.ROJO),
        PICAS("Picas", Color.NEGRO),
        DIAMANTES("Diamantes", Color.ROJO);

        private final String display;
        private final Color color;

        Suit(String display, Color color) {
            this.display = display;
            this.color = color;
        }

        public String display() {
            return display;
        }

        public Color color() {
            return color;
        }
    }

    public enum Rank {
        A("A"),
        TWO("2"), THREE("3"), FOUR("4"), FIVE("5"), SIX("6"), SEVEN("7"),
        EIGHT("8"), NINE("9"), TEN("10"),
        J("J"), Q("Q"), K("K");

        private final String display;

        Rank(String display) {
            this.display = display;
        }

        public String display() {
            return display;
        }
    }

    // 3 atributos solicitados
    private final Suit palo;
    private final Color color;
    private final Rank valor;

    public Card(Suit palo, Rank valor) {
        this.palo = palo;
        this.color = palo.color(); // respeta reglas: color depende del palo
        this.valor = valor;
    }

    public Suit getPalo() {
        return palo;
    }

    public Color getColor() {
        return color;
    }

    public Rank getValor() {
        return valor;
    }

    @Override
    public String toString() {
        // Formato requerido: {Palo},{Color},{Valor}
        return palo.display() + "," + color.display() + "," + valor.display();
    }
}
