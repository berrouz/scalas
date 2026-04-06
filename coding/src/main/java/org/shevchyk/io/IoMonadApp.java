package org.shevchyk.io;

import java.util.Optional;

public class IoMonadApp {
    public static void main(String[] args) {
        Player p1 = new Player("bmw", 10);
        Player p2 = new Player("audi", 20);
        content(p1, p2).run();
    }

    static class Player {
        private String name;
        private Integer score;

        Player(String name,Integer score) {
            this.name = name;
            this.score = score;
        }
    }

    interface IO {
        void run();
    }


    public static Optional<Player> winner(Player p1, Player p2) {
        if (p1.score > p2.score) {
            return Optional.of(p1);
        } else if (p1.score < p2.score) {
            return Optional.of(p2);
        } else {
            return Optional.empty();
        }
    }

    // code without effects
    public static String winnerMsg(Optional<Player> p){
        return p.map(player -> player.name + " " + "is the winner!")
                .orElseGet(() -> "it's draw");
    }

    // IO encapsulate effectful code - EFFECT
    public static IO printLine(String message) {
        return () -> sideEffect(message);
    }

    // sideeffect
    private static void sideEffect(String message) {
        System.out.println(message);
    }

    public static IO content(Player a, Player b) {
        return printLine(winnerMsg(winner(a, b)));
    }

    // A => B

    // A => D => B
    // A => D pure function
    // D => B interpreter

    /*
    * We build an algebra - pure logic and then interpret that logic
    * IO Monad clearly separates pure code from impure code
    * */
}
