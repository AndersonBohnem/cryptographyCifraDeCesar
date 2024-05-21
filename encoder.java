import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class encoder {

    private static final Map<Character, Integer> letterToNumber = new HashMap<>();
    private static final Map<Integer, Character> numberToLetter = new HashMap<>();
    //KEY
    private static final int KEY = 3;

    static {
        letterToNumber.put('A', 1);
        letterToNumber.put('B', 2);
        letterToNumber.put('C', 3);
        letterToNumber.put('D', 4);
        letterToNumber.put('E', 5);
        letterToNumber.put('F', 6);
        letterToNumber.put('G', 7);
        letterToNumber.put('H', 8);
        letterToNumber.put('I', 9);
        letterToNumber.put('J', 10);
        letterToNumber.put('K', 11);
        letterToNumber.put('L', 12);
        letterToNumber.put('M', 13);
        letterToNumber.put('N', 14);
        letterToNumber.put('O', 15);
        letterToNumber.put('P', 16);
        letterToNumber.put('Q', 17);
        letterToNumber.put('R', 18);
        letterToNumber.put('S', 19);
        letterToNumber.put('T', 20);
        letterToNumber.put('U', 21);
        letterToNumber.put('V', 22);
        letterToNumber.put('W', 23);
        letterToNumber.put('X', 24);
        letterToNumber.put('Y', 25);
        letterToNumber.put('Z', 26);
        numberToLetter.put(1, 'A');
        numberToLetter.put(2, 'B');
        numberToLetter.put(3, 'C');
        numberToLetter.put(4, 'D');
        numberToLetter.put(5, 'E');
        numberToLetter.put(6, 'F');
        numberToLetter.put(7, 'G');
        numberToLetter.put(8, 'H');
        numberToLetter.put(9, 'I');
        numberToLetter.put(10, 'J');
        numberToLetter.put(11, 'K');
        numberToLetter.put(12, 'L');
        numberToLetter.put(13, 'M');
        numberToLetter.put(14, 'N');
        numberToLetter.put(15, 'O');
        numberToLetter.put(16, 'P');
        numberToLetter.put(17, 'Q');
        numberToLetter.put(18, 'R');
        numberToLetter.put(19, 'S');
        numberToLetter.put(20, 'T');
        numberToLetter.put(21, 'U');
        numberToLetter.put(22, 'V');
        numberToLetter.put(23, 'W');
        numberToLetter.put(24, 'X');
        numberToLetter.put(25, 'Y');
        numberToLetter.put(26, 'Z');

        for (Map.Entry<Character, Integer> entry : letterToNumber.entrySet()) {
            numberToLetter.put(entry.getValue(), entry.getKey());
        }
    }

    @SuppressWarnings("resource")
    public static void main(String[] args) {
        cleanScreen();

        Scanner scanner = new Scanner(System.in);
        System.out.print("Digite a sequência de letters: ");
        String userResponse = scanner.nextLine().toUpperCase();

        int[] answerNumbers = convertToNumbersWithKey(userResponse);

        System.out.print("\n\nCRIPTOGRAFADO EM NÚMEROS:\n\n ");
        for (int num : answerNumbers) {
            System.out.print(num + " ");
        }

        String encrypted = convertToLetters(answerNumbers);
        System.out.println("\n\nCRIPTOGRAFADO:\n\n" + encrypted + "\n\n\n");

    }

    private static int[] convertToNumbersWithKey(String response) {
        int[] numbers = new int[response.length()];
        for (int i = 0; i < response.length(); i++) {
            char letter = response.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                int number = letterToNumber.get(letter);
                numbers[i] = number + KEY;
                if (numbers[i] > 26) {
                    numbers[i] = numbers[i] - 26;
                }
            } else {
                System.out.println("Caractere inválido: " + letter);
            }
        }
        return numbers;
    }

    private static String convertToLetters(int[] numbers) {
        StringBuilder response = new StringBuilder();
        for (int number : numbers) {
            Character letter = numberToLetter.get(number);
            if (letter != null) {
                response.append(letter);
            } else {
                System.out.println("Número inválido: " + number);
            }
        }
        return response.toString();
    }

    private static void cleanScreen() {
        for (int i = 0; i < 10; i++) {
            System.out.println("\n\n\n\n");
        }
    }

}
