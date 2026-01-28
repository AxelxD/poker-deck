# Poker Deck (Java + Maven)

Proyecto en Java que implementa una baraja (deck) de 52 cartas de poker con las operaciones solicitadas:

- `shuffle()` mezcla el deck e imprime: **"Se mezcló el Deck."**
- `head()` muestra/remueve la primera carta.
- `pick()` selecciona/remueve una carta al azar.
- `hand()` devuelve 5 cartas (arreglo) y las remueve del deck.

## Requisitos
- Java 21+
- Maven 3.9+

## Cómo ejecutar
Desde la carpeta del proyecto:

```bash
mvn -q clean package
java -jar target/poker-deck-1.0.0.jar
```

