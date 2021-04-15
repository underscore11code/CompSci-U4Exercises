package io.github.underscore11code.compsci;

import java.util.Scanner;
import java.util.function.Function;
import java.util.function.Predicate;

public class Main {
  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args) {
    // Make sure the scanner gets closed on shutdown
    Runtime.getRuntime().addShutdownHook(new Thread(scanner::close));

    do {
      final String input = prompt("Type \"C\" for Chaos (Exercise 15), \"G\" for GuessingGame (Exercise 8), \"exit\" to exit",
              s -> s.equalsIgnoreCase("C") || s.equalsIgnoreCase("G") || s.equalsIgnoreCase("exit"),
              Function.identity());

      if (input.equalsIgnoreCase("C")) {
        new Chaos().run();
      } else if (input.equalsIgnoreCase("G")) {
        new GuessingGame().run();
      } else if (input.equalsIgnoreCase("exit")) {
        break;
      } else {
        System.out.println("This should not be possible");
      }
    } while (true);

    System.out.println("Goodbye.");
    scanner.close();
  }

  // Util methods for user input

  public static <T> T prompt(String prompt, Predicate<String> check, Function<String, T> mapper) {
    while (true) {
      System.out.println(prompt);
      System.out.print("> ");
      final String s = scanner.nextLine();
      if (check.test(s)) {
        return mapper.apply(s);
      }
      System.out.println("Invalid input.");
    }
  }

  public static boolean promptBoolean(String prompt) {
    return prompt(prompt + " (y/n)",
            s -> s.equalsIgnoreCase("y") || s.equalsIgnoreCase("n"),
            s -> s.equalsIgnoreCase("y"));
  }

  public static int promptInt(String prompt) {
    return prompt(prompt, s -> {
      if (s == null || s.equalsIgnoreCase("")) {
        return false;
      }

      try {
        Integer.parseInt(s);
      } catch (NumberFormatException e) {
        return false;
      }
      return true;
    }, Integer::parseInt);
  }

  public static float promptFloat(String prompt) {
    return prompt(prompt, s -> {
      if (s == null || s.equalsIgnoreCase("")) {
        return false;
      }

      try {
        Float.parseFloat(s);
      } catch (NumberFormatException e) {
        return false;
      }
      return true;
    }, Float::parseFloat);
  }
}
