package schemas;

import java.util.ArrayList;
import java.util.List;

/**
 * - game: |
     {
        "type":    "object",
        "$schema": "http://json-schema.org/draft-03/schema",
        "id":      "game",
        "properties": {
             "gameID": { "type":    "string", "required": true},
             "players":{ "type":    "array",
                         "items":   {"$ref": "player"} },
             "components": { "$ref": "components" }
        }
    }
     example: |
         {"gameID":"42",
         "players":[{"id":"mario","name":"Mario","uri":"http://localhost:4567/player/mario","ready":false}],
         "started":false
     }
*/

public class Game {

    private String gameID;
    private List<String> players;
    private Components components = null;

    public Game(String gameID, ArrayList<String> players, Components components){
        this.gameID = gameID;
        this.players = players;
        this.components = components;
    }

    public Game(String gameID){
        this.gameID = gameID;
        this.players = new ArrayList<>();
    }

    public String getGameID() {
        return gameID;
    }

    public void addPlayer(String player){
        this.players.add(player);
    }

    public List<String> getPlayers() {
        return players;
    }

    public Components getComponents() {
        return components;
    }

    public void setComponents(Components components) {
        this.components = components;
    }
}

