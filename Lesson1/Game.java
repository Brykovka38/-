import java.io.FileWriter;
import java.io.IOException;

public class Game {
    String title;
    String genre;
    int releaseYear;
    double rating;
    boolean isMultiPlayer;

    Game(String title, String genre, int releaseYear, double rating, boolean isMultiPlayer) {
        this.title = title;
        this.genre = genre;
        this.releaseYear = releaseYear;
        this.rating = rating;
        this.isMultiPlayer = isMultiPlayer;
    }

    void writeInfo(FileWriter writer) throws IOException {
        String multiplayerStatus = isMultiPlayer ? "Да" : "Нет";
        writer.write(String.format(
            "%-43s | %-21s | %4d | %4.1f | %-3s%n",
            title,
            genre,
            releaseYear,
            rating,
            multiplayerStatus
        ));
    }



}
