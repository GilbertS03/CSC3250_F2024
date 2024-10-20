import java.util.Scanner;

public class problem3 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter a palindrome: ");
        String input = scan.nextLine();
        String inputNoSpecials = "";
        String palindrome = "";
        for(int i = input.length() - 1; i >= 0; i--){
            if(Character.isAlphabetic(input.charAt(i))){
                input = input.toLowerCase();
                inputNoSpecials = input.charAt(i) + inputNoSpecials;
                palindrome += input.charAt(i);
            }
        }
        if(inputNoSpecials.equals(palindrome))
            System.out.println(input + " is a palindrome");

        else
            System.out.println(input + " is not a palindrome");
    }
}
