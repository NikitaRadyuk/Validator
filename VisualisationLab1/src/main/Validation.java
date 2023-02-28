package main;

public class Validation {
    public static boolean validate(String line) {
        char[] separators = {',', '.', ';', ':', '!', '?', '-', ' '};
        char[] chars = line.toCharArray();
        for (char c : chars) {
            for (char s : separators) {
                if (c == s) {
                    return true;
                }
            }

            if ((c < 97 || c > 122) && (c < 48 || c > 57)) {
                return false;
            }
        }

        return true;
    }
}
