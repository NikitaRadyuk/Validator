package main;

import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        //1
        Scanner in = new Scanner(System.in);
        System.out.print("Enter line: ");
        String line = in.nextLine();
        StringParser parser = new StringParser(line);
        if (parser.isValidated()) {
            ConsolePrinter printer = new ConsolePrinter(parser);
            // 2
            printer.printNumberOfWords();
            printer.printNumberOfNumbers();
            printer.printNumberOfLatins();
            printer.printNumberOfDigits();
            printer.printNumberOfPunctuationMarks();
            // 3
            printer.printListOfWords();
        }
        else {
            System.out.println("Incorrect symbols.");
        }
    }
}