package org.example;

public class FeatureGenerator {

    public static void main(String[] args) {
        System.out.println("Feature: FizzBuzz");
        for (int i = 1; i <= 100; i++) {
            String result = FizzBuzz.compute(i);
            System.out.println("  Scenario: " + i + " returns " + result);
            System.out.println("    Given the input number is " + i);
            System.out.println("    When I compute FizzBuzz");
            System.out.println("    Then the result should be \"" + result + "\"");
        }
    }
}
