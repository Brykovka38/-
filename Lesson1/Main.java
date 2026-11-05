import java.io.FileWriter;
import java.io.IOException;
import java.util.Comparator;

public class Main {
    public static void sortArray(Game[] games, Comparator<Game> comparator){
        for (int i = 0; i < games.length - 1; i++) {
            for (int j = 0; j < games.length - i - 1; j++) {
                if (comparator.compare(games[j], games[j + 1]) > 0) {
                    Game k = games[j];
                    games[j] = games[j+1];
                    games[j+1] = k;
                }
            }
        }

    }
    public static void main(String[] args) throws IOException {
        Game[] games = new Game[15];

        games[0] = new Game("The Witcher 3: Wild Hunt", "RPG", 2015, 9.8, false);
        games[1] = new Game("Cyberpunk 2077", "RPG", 2020, 7.5, true);
        games[2] = new Game("Minecraft", "Sandbox", 2011, 9.0, true);
        games[3] = new Game("Fortnite", "Battle Royale", 2017, 8.5, true);
        games[4] = new Game("Grand Theft Auto V", "Action-adventure", 2013, 9.5, true);
        games[5] = new Game("The Legend of Zelda: Breath of the Wild", "Action-adventure", 2017, 9.7, false);
        games[6] = new Game("Red Dead Redemption 2", "Action-adventure", 2018, 9.6, false);
        games[7] = new Game("Overwatch", "First-person shooter", 2016, 8.9, true);
        games[8] = new Game("Call of Duty: Modern Warfare", "First-person shooter", 2019, 8.2, true);
        games[9] = new Game("Assassin's Creed Valhalla", "Action-adventure", 2020, 8.7, false);
        games[10] = new Game("FIFA 21", "Sports", 2020, 7.8, true);
        games[11] = new Game("NBA 2K21", "Sports", 2020, 8.1, true);
        games[12] = new Game("The Sims 4", "Simulation", 2014, 8.5, true);
        games[13] = new Game("Stardew Valley", "Simulation", 2016, 9.2, false);
        games[14] = new Game("Among Us", "Party", 2018, 8.0, true); 

        FileWriter writer = new FileWriter("games.txt");

        writer.write(("Игры: \n"));
        sortArray(games, (a, b) -> a.title.compareTo(b.title));
        for(Game game: games) {
            game.writeInfo(writer);
        }

        writer.write("\nСамые лучшие игры: \n");
        sortArray(games, (a, b) -> Double.compare(b.rating, a.rating));
        for(Game game: games) {
            game.writeInfo(writer);
        }

        writer.write("\nНовинки: \n");
        sortArray(games, (a, b) -> Integer.compare(b.releaseYear, a.releaseYear));
        for(Game game: games) {
            game.writeInfo(writer);
        }

        writer.close();    



    }
}
