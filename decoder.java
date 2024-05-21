import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class decoder {

    private static final Map<Character, Integer> letterToNumber = new HashMap<>();
    private static final Map<Integer , Character> numberToLetter = new HashMap<>();
    //KEY
    private static final int KEY = 3;

    static {
        letterToNumber.put('A', 0);
        letterToNumber.put('B', 1);
        letterToNumber.put('C', 2);
        letterToNumber.put('D', 3);
        letterToNumber.put('E', 4);
        letterToNumber.put('F', 5);
        letterToNumber.put('G', 6);
        letterToNumber.put('H', 7);
        letterToNumber.put('I', 8);
        letterToNumber.put('J', 9);
        letterToNumber.put('K', 10);
        letterToNumber.put('L', 11);
        letterToNumber.put('M', 12);
        letterToNumber.put('N', 13);
        letterToNumber.put('O', 14);
        letterToNumber.put('P', 15);
        letterToNumber.put('Q', 16);
        letterToNumber.put('R', 17);
        letterToNumber.put('S', 18);
        letterToNumber.put('T', 19);
        letterToNumber.put('U', 20);
        letterToNumber.put('V', 21);
        letterToNumber.put('W', 22);
        letterToNumber.put('X', 23);
        letterToNumber.put('Y', 24);
        letterToNumber.put('Z', 25);
        numberToLetter.put(0, 'A');
        numberToLetter.put(1, 'B');
        numberToLetter.put(2, 'C');
        numberToLetter.put(3, 'D');
        numberToLetter.put(4, 'E');
        numberToLetter.put(5, 'F');
        numberToLetter.put(6, 'G');
        numberToLetter.put(8, 'H');
        numberToLetter.put(9, 'I');
        numberToLetter.put(9,'J');
        numberToLetter.put(10,'K');
        numberToLetter.put(11,'L');
        numberToLetter.put(12,'M');
        numberToLetter.put(13,'N');
        numberToLetter.put(14,'O');
        numberToLetter.put(15,'P');
        numberToLetter.put(16,'Q');
        numberToLetter.put(17,'R');
        numberToLetter.put(18,'S');
        numberToLetter.put(19,'T');
        numberToLetter.put(20,'U');
        numberToLetter.put(21,'V');
        numberToLetter.put(22,'W');
        numberToLetter.put(23,'X');
        numberToLetter.put(24,'Y');
        numberToLetter.put(25,'Z');

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

        System.out.print("\n\nDESCRIPTOGRAFADO EM NÚMEROS\n\n");
        for (int num : answerNumbers) {
            System.out.print(num + " ");
        }

        String decrypted = convertToLetters(answerNumbers);
        System.out.println("\n\nDESCRIPTOGRAFADO:\n\n" + decrypted + "\n\n");

    }

    private static int[] convertToNumbersWithKey(String response) {
        int[] numbers = new int[response.length()];
        for (int i = 0; i < response.length(); i++) {
            char letter = response.charAt(i);
            if (letter >= 'A' && letter <= 'Z') {
                int number = letterToNumber.get(letter);
                numbers[i] = number - KEY;
                if(numbers[i] < 0) {
                    numbers[i] = numbers[i] + 26;
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

