package simpleTimer;


public class SimpleTimer implements AutoCloseable{
  private final double start;
  private double end;

  public SimpleTimer() {
    start = System.nanoTime();
  }

  @Override
  public void close() {
    end = System.nanoTime();
    double duration = end - start;
    System.out.println("Duration: " + duration / 1_000_000_000);
  }
}
