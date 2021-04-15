package io.github.underscore11code.compsci;

import java.util.Random;

public class GuessingGame implements Runnable {
  @Override
  public void run() {
    do {
      int max = Main.promptInt("Enter the max");
      int num = new Random().nextInt(max);

      while (true) {
        int entered = Main.promptInt("Take a guess!");
        if (entered > num) {
          System.out.println("Too high.");
        } else if (entered < num) {
          System.out.println("Too low.");
        } else if (entered == num) {
          System.out.println("You got it!");
          break;
        }
      }
    } while (Main.promptBoolean("Again?"));
  }
}
