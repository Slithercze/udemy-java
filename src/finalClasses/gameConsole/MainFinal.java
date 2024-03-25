package finalClasses.gameConsole;

import finalClasses.gameConsole.game.Game;
import finalClasses.gameConsole.game.GameAction;
import finalClasses.gameConsole.game.GameConsole;
import finalClasses.gameConsole.game.Player;
import finalClasses.gameConsole.pirate.PirateGame;

//class SpecialGameAction extends GameAction{} cant extend from records and enums
//class SpecialGameConsole<T extends Game<? extends Player>> extends GameConsole<Game<? extends Player>>{
//
//    public SpecialGameConsole(Game<? extends Player> game) {
//        super(game);
//    }
//}
public class MainFinal {

    public static void main(String[] args) {

        GameConsole<PirateGame> game = new GameConsole<>(new PirateGame("Pirate Game"));
    }
}
