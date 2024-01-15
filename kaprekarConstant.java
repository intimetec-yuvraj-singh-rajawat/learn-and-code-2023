package hello;
import java.util.*;

public class KaprekarConstant {

    public static int reverseNumber(int number) {
        return Integer.parseInt(new StringBuilder(String.valueOf(number)).reverse().toString());
    }

    public static boolean hasRepeatingDigits(int number) {
        Set<Character> digitSet = new HashSet<>();
        String formattedNumber = formatNumber(number);
        for (char digit : formattedNumber.toCharArray()) {
            digitSet.add(digit);
        }
        return digitSet.size() >= 2;
    }

    public static int sortDigits(String number) {
        char[] digits = number.toCharArray();
        Arrays.sort(digits);
        return Integer.parseInt(new StringBuilder(new String(digits)).reverse().toString());
    }

    public static boolean isValidNumber(int number) {
        return number <= 9999 && hasRepeatingDigits(number);
    }

    public static String formatNumber(int number) {
        return String.format("%04d", number);
    }

    public static int kaprekarStep(int number) {
        String formattedNumber = formatNumber(number);
        int descending = sortDigits(formattedNumber);
        int ascending = reverseNumber(descending);
        int difference = descending - ascending;

        System.out.println(descending + " - " + ascending + " = " + difference);

        return difference;
    }

    public static void kaprekarConstant(int initialNumber) {
        if (!isValidNumber(initialNumber)) {
            System.out.println("Invalid input. Please provide a valid four-digit number.");
            return;
        }

        int difference = kaprekarStep(initialNumber);

        while (difference != 6174) {
            difference = kaprekarStep(difference);
        }
    }

    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int constant = sc.nextInt();
    	KaprekarConstant.kaprekarConstant(constant);
    }
}
	