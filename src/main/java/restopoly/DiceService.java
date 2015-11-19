package restopoly;
import schemas.Dice;

import static spark.Spark.get;
/**
 * Created by diana on 01.11.15.
 */
public class DiceService {
    public static void main( String[] args) {
        get("/dice", (req, res) -> {
            return new Dice();
        });
    }
}
