package main;

import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

public class StringParser {
    private static final char SPACE = ' ';
    private final String line;
    private char[] chars;
    private final boolean isValidated;
    private int numberOfPunctuationMarks = 0;

    public StringParser(String line) {
        this.line = line;
        this.chars = line.toLowerCase().toCharArray();
        this.isValidated = Validation.validate(line.toLowerCase(Locale.US));
    }

    public List<String> getListOfWords() {
        if (this.isValidated) {
            removePunctuationMarks();
            List<String> lines = new ArrayList<>();
            int startInd = 0;
            for (int i = 0; i < this.chars.length; i++) {
                if (this.chars[i] == SPACE) {
                    lines.add(getString(this.chars, startInd, i));
                    startInd = i + 1;
                    if (this.chars[i + 1] == SPACE) {
                        startInd = ++i + 1;
                    }
                }
            }

            lines.add(getString(this.chars, startInd, this.chars.length));
            return lines;
        }

        return null;
    }

    private void removePunctuationMarks() {
        char[] separators = {',', '.', ';', ':', '!', '?', '-'};
        for (int i = 0; i < this.chars.length; i++) {
            for (char separator : separators) {
                if (this.chars[i] == separator) {
                    if (i != this.chars.length - 1
                            && (separator == '.' || separator == ',')
                            && this.chars[i + 1] > 47 && this.chars[i + 1] < 58) {
                        continue;
                    }

                    this.numberOfPunctuationMarks++;
                    this.chars = remove(chars, i);
                    break;
                }
            }
        }
    }

    private String getString(char[] arr, int startIndex, int endIndex) {
        StringBuilder stringBuilder = new StringBuilder();
        for (int i = startIndex; i < endIndex; i++) {
            stringBuilder.append(arr[i]);
        }

        return stringBuilder.toString();
    }

    private char[] remove(char[] arr, int index) {
        char[] res = new char[arr.length - 1];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (i != index) {
                res[count++] = arr[i];
            }
        }

        return res;
    }

    public int getNumberOfPunctuationMarks() {
        return this.numberOfPunctuationMarks;
    }

    public boolean isValidated() {
        return this.isValidated;
    }


}
