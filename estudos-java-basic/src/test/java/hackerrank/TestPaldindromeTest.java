package hackerrank;

public class TestPaldindromeTest {

 
    private static boolean isPalindrome(String palindrome) {
        // Find the pivot
        int pivot = palindrome.length() / 2;
        boolean hasPivotOdd = palindrome.length() % 2 != 0;
        if (hasPivotOdd) {
            return checkPalindromeOdd(palindrome, pivot);
        } else {
            return checkPalindromePair(palindrome);
        }
    }

    private static boolean checkPalindromeOdd(String palindrome, int pivot) {
        String firstPart = palindrome.substring(0, pivot + 1);
        int j = palindrome.length();
        String[] characteres = palindrome.split("");
        StringBuilder stringBuilder = new StringBuilder();
        while (j >= pivot + 1) {
            stringBuilder.append(characteres[j - 1]);
            j--;
        }
        return firstPart.equals(stringBuilder.toString());
    }
}
