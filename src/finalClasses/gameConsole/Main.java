package finalClasses.gameConsole;

import finalClasses.gameConsole.game.GameConsole;
import finalClasses.gameConsole.game.ShooterGame;
import finalClasses.gameConsole.pirate.Pirate;
import finalClasses.gameConsole.pirate.PirateGame;
import finalClasses.gameConsole.pirate.Weapon;

public class Main {

    public static void main(String[] args) {

//        var console = new GameConsole<>(new ShooterGame("The Shootout Game"));
//
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);

        Weapon weapon = Weapon.getWeaponByChar('P');
        System.out.println("weapon = " + weapon + ", hitPoints=" + weapon.getHitPoints() + ", minLevel=" + weapon.getMinLevel());

        var list = Weapon.getWeaponsByLevel(1);
        list.forEach(System.out::println);

        Pirate tim = new Pirate("Tim");
        System.out.println(tim);

        PirateGame.getTowns(0).forEach(System.out::println);
        System.out.println("------------------------------------------------------------");
        PirateGame.getTowns(1).forEach(System.out::println);

//        var console = new GameConsole<>(new PirateGame("The Pirate Game"));
//        int playerIndex = console.addPlayer();
//        console.playGame(playerIndex);
    }
}
