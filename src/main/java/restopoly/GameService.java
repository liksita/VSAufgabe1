package restopoly;

import com.google.gson.Gson;
import com.sun.tools.javac.util.List;
import schemas.Game;

import java.util.ArrayList;
import java.util.HashMap;

import static spark.Spark.*;

public class GameService {

    private static Gson gson = new Gson();
    private static int gameID = 1;
    private static ArrayList<Game> games = new ArrayList<>();

    public static void main(String[] args) {

        get("/games", (request1, response1) -> {

            return games;
        }, gson::toJson);

        // Benutzer können mit dem Client ein neues Spiel eröffnen
        // post /games
        post("/games", (req, res) -> {
            String neugameID = getNextGameID();
            Game game = new Game(neugameID);
            games.add(game);
            return game;
        }, gson::toJson);

        // Benutzer können sich mit dem Client als Spieler registrieren
        // put /games/{gameid}/players/{playerid}
        put("/games/:gameid/players/:playerid", (request, response) -> {
            Game game = findGame(request.params(":gameid"));

            game.addPlayer(request.params(":playerid"));
            response.type("application/json");
            return game;
        }, gson::toJson);

        // Benutzer können mit dem Client melden, dass sie fertig sind und das Spiel losgehen kann

        // Wenn alle Clients bereit sind, kann das Spiel beginnen – die erste Person muss anfangen zu würfeln!
        // Achten Sie darauf, dass  für die verschiedenen Spielkomponenten auch unterschiedliche Hosts
        // über- bzw. angegeben werden können
    }

    private static String getNextGameID() {
        return String.valueOf(gameID++);
    }

    private static Game findGame(String gameID) {
        for (Game game : games) {
            if (game.getGameID().equals(gameID)) return game;
        }
        return null;
    }
}