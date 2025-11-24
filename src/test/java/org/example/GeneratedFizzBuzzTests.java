package org.example;

import static org.junit.jupiter.api.Assertions.assertEquals;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

public class GeneratedFizzBuzzTests {

    @ParameterizedTest(name = "{0} => {1}")
    @MethodSource("casesFromFeature")
    void generatedTest(int input, String expected) {
        String actual = FizzBuzz.compute(input);
        assertEquals(expected, actual);
    }

    static Stream<Arguments> casesFromFeature() throws IOException {
        Path feature = Path.of("src", "test", "resources", "features", "fizzbuzz.feature");
        List<String> lines = Files.readAllLines(feature);

        List<Arguments> args = new ArrayList<>();
        Integer currentNumber = null;

        for (String raw : lines) {
            String line = raw.strip();
            if (line.startsWith("Given the input number is ")) {
                String num = line.replace("Given the input number is ", "").trim();
                try {
                    currentNumber = Integer.parseInt(num);
                } catch (NumberFormatException e) {
                    currentNumber = null;
                }
            }

            if (line.startsWith("Then the result should be ") && currentNumber != null) {
                // Then the result should be "<expected>"
                int firstQuote = line.indexOf('"');
                int lastQuote = line.lastIndexOf('"');
                String expected = "";
                if (firstQuote >= 0 && lastQuote > firstQuote) {
                    expected = line.substring(firstQuote + 1, lastQuote);
                } else {
                    // fallback: take the rest after the phrase
                    expected = line.replace("Then the result should be ", "").trim();
                }
                args.add(Arguments.of(currentNumber, expected));
                currentNumber = null;
            }
        }

        return args.stream();
    }
}
