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
        boolean mult3 = (n % 3 == 0);
        boolean mult5 = (n % 5 == 0);
        String s = Integer.toString(n);
        boolean contains3 = s.indexOf('3') >= 0;
        boolean contains5 = s.indexOf('5') >= 0;

        boolean isFizz = mult3 || contains3;
        boolean isBuzz = mult5 || contains5;

        if (isFizz && isBuzz) return "FizzBuzz";
        if (isFizz) return "Fizz";
        if (isBuzz) return "Buzz";
        return s;
    }
}
