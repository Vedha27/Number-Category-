package CategoryNumber;
import java.util.*;
@FunctionalInterface interface NumberCategory { boolean checkNumberCategory(int n1, int n2); }

public class NumberCategoryAmiPali { public static NumberCategory checkAmicable() { return (n1, n2) -> { int sumDivisors1 = sumDivisors(n1); int sumDivisors2 = sumDivisors(n2); return sumDivisors1 == n2 && sumDivisors2 == n1; }; }

public static NumberCategory checkPalindrome() {
    return (n1, n2) -> {
        int product = n1 * n2;
        String productString = String.valueOf(product);
        return isPalindrome(productString);
    };
}

private static int sumDivisors(int n) {
    int sum = 1; // Start with 1 as 1 is always a divisor
    for (int i = 2; i <= Math.sqrt(n); i++) {
        if (n % i == 0) {
            sum += i;
            if (i != n / i) { // Check for non-square divisors
                sum += n / i;
            }
        }
    }
    return sum;
}

private static boolean isPalindrome(String str) {
    int i = 0;
    int j = str.length() - 1;
    while (i < j) {
        if (str.charAt(i) != str.charAt(j)) {
            return false;
        }
        i++;
        j--;
    }
    return true;
}

public static void main(String[] args) {
	Scanner y=new Scanner(System.in);
    int num1;
    int num2; 
    System.out.println("Enter Number1:");
    num1=y.nextInt();
    System.out.println("Enter Number2:");
    num2=y.nextInt();

    NumberCategory amicableChecker = checkAmicable();
    NumberCategory palindromeChecker = checkPalindrome();
    if(amicableChecker.checkNumberCategory(num1, num2)==true)
    {
    	System.out.println(num1 +" and "+ num2+" are amicable.");
    }
    else
    {
    	System.out.println(num1+" and "+num2+" are not amicable.");
    }
    
    if(palindromeChecker.checkNumberCategory(num1, num2)==true)
    
    {
    	System.out.println("Their Product "+num1*num2+" do produce a  palindrome.");
    }
    else
    {
    	System.out.println("Their Product "+num1*num2+" does not produce a palindrome.");
    }
}
}