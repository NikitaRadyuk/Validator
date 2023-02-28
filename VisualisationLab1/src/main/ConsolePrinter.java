package main;

import java.util.List;

public class ConsolePrinter {
    private final StringParser parser;
    private final List<String> lines;

    public ConsolePrinter(StringParser parser) {
        this.parser = parser;
        this.lines = parser.getListOfWords();
    }

    public void printNumberOfWords() {
        System.out.println("Number of words = " + lines.size());
    }

    public void printNumberOfNumbers() {
        int intNumbers = 0;
        int doubleNumbers = 0;
        for (String l : lines) {
            if (Character.isDigit(l.charAt(0))) {
                if (l.contains(".") || l.contains(",")) {
                    doubleNumbers++;
                } else {
                    intNumbers++;
                }
            }
        }

        System.out.println("Number of integer numbers = " + intNumbers);
        System.out.println("Number of double numbers = " + doubleNumbers);
    }

    public void printNumberOfDigits() {
        int digitNumbers = 0;
        for (String l : lines) {
            if (Character.isDigit(l.charAt(0))) {
                if ((l.contains(".") || l.contains(","))) {
                    digitNumbers += l.length() - 1;
                } else {
                    digitNumbers += l.length();
                }
            }
        }

        System.out.println("Number of digits = " + digitNumbers);
    }

    public void printNumberOfLatins() {
        int num = 0;
        for (String l : lines) {
            if (!Character.isDigit(l.charAt(0))) {
                num += l.length();
            }
        }

        System.out.println("Number of latins = " + num);
    }

    public void printNumberOfPunctuationMarks() {
        System.out.println("Number of punctuation marks = " + parser.getNumberOfPunctuationMarks());
    }

    public void printListOfWords() {
        System.out.println("List of words: ");
        for (String l : lines) {
            System.out.println(l);
        }

        System.out.println("#The end.");
    }
}
