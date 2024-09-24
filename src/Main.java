public class Main {

    // 1. parenthesesCheck
    public static boolean parenthesesCheck(String seq) {
        char item = ' ';
        for (int i = 0; i < seq.length(); i++) {
            item = seq.charAt(i);
            if ((i == 0 && item == ')') || (i == seq.length() - 1 && item == '(')) {
                return false;
            }
        }
        if (item != ')') {
            return false;
        }
        return true;
    }

    // 2. reverseInteger
    public static String reverseInteger(int num) {
        String str = String.valueOf(num); // Can't just set num to String directly because they're testing it using ints
        String temp = "";
        for (int i = 0; i < str.length(); i++) {
            temp = temp + str.charAt((str.length()-1) - i);
        }
        return temp;
    }

    // 3. encryptThis
    public static String encryptThis(String encrypt) {
        String temp = "";
        String[] words = encrypt.split("\\s"); // I couldn't think of another way to split the string into words without using an array
        char item = ' ';
        for (String word : words) {
            for (int i = 0; i < word.length(); i++) {
                item = word.charAt(i);
                if (i == 0) {
                    temp = temp + ((int) item);
                } else if (i == 1) {
                    temp = temp + word.charAt(word.length()-1);
                } else if (i == word.length()-1) {
                    temp = temp + word.charAt(1);
                } else {
                    temp = temp + item;
                }
            }
            temp = temp + " ";
        }
        return temp.substring(0, temp.length()-1);
    }

    // 4. decipherThis: I feel like I'm severely overcomplicating this...
    public static String decipherThis(String decrypt) {
        String decipher = "";
        String temp = "";
        String decodedChar = "";
        String[] words = decrypt.split("\\s");
        int i;
        for (String word : words) {
            i = 0;
            temp = "";
            while (Character.isDigit(word.charAt(i))) {
                temp = temp + word.charAt(i);
                i++;
            }
            decodedChar = String.valueOf((char) Integer.parseInt(temp));
            word = word.replaceAll(temp, decodedChar);
            temp = decodedChar;
            for (i = 1; i < word.length(); i++) {
                if (i == 1) {
                    temp = temp + word.charAt(word.length()-1);
                } else if (i == word.length()-1) {
                    temp = temp + word.charAt(1);
                } else {
                    temp = temp + word.charAt(i);
                }
            }
            decipher = decipher + temp + " ";
        }
        return decipher.substring(0, decipher.length()-1);
    }

}
