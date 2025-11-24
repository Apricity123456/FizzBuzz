package org.example;

public class FizzBuzz {

    /**
     * Placeholder compute method for FizzBuzz.
     * Implement the actual logic later.
     *
     * @param n input number
     * @return placeholder string representation of n
     */
    public static String compute(int n) {
        boolean fizz = (n % 3 == 0);
        boolean buzz = (n % 5 == 0);
        if (fizz && buzz) return "FizzBuzz";
        if (fizz) return "Fizz";
        if (buzz) return "Buzz";
        return Integer.toString(n);
    }
}
