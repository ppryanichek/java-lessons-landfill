package main.java;

public class BouncingBalls {
    public static void main(String[] args) {
        double height = 2.4;
        double bounce = 0.66;
        double windowHeight = 1.5;
        System.out.println(bouncingBall(height, bounce, windowHeight));
    }

    public static int bouncingBall(double h, double bounce, double window) {
        int count = 0;
        if (h > 0 && (bounce > 0 && bounce < 1) && window < h) {

            while ((h = h * bounce) > window) {
                count += 2;
            }

            ++count;
            return count;
        }
        return -1;
    }
}