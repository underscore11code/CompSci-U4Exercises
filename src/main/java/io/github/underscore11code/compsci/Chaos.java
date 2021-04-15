package io.github.underscore11code.compsci;

public class Chaos implements Runnable {
  @Override
  public void run() {
    do {
      float x = Main.promptFloat("Enter the starting value");
      int multiplier = Main.promptInt("Enter the multiplier");
      int iterations = Main.promptInt("Enter the iteration count");
      boolean graph = Main.promptBoolean("Display graph?");

      for (int i = 0; i < iterations; i++) {
        x = multiplier*x*(1-x);
        out(x, i, graph);
      }
    } while (Main.promptBoolean("Again?"));
  }

  private static void out(final float num, final int iteration, final boolean graph) {
    StringBuilder out = new StringBuilder();
    if (graph) {
      for (double i = 0; i < 1; i += 0.01) {
        out.append(num <= i || num > i + 0.01 ? " " : "*");
      }
      out.append("| ");
    }
    out.append("i=").append(iteration).append(" x=").append(num);
    System.out.println(out);
  }
}
