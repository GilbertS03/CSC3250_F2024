//import java.util.ArrayList;
//import java.util.Scanner;
//
////problem 1
//public class problem1 {
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter in a number: (-1 to stop)");
//        Integer largest, smallest;
//        int ctr = 0;
//        largest = smallest = null;
//        int x = scan.nextInt();
//        while(x != -1){
//            if(ctr == 0)
//                largest = smallest = x;
//            else{
//                if(x > largest)
//                    largest = x;
//                else if (x < smallest)
//                    smallest = x;
//            }
//            System.out.println("Enter in a number: (-1 to stop)");
//            x = scan.nextInt();
//            ctr++;
//        }
//        if(smallest == null && largest == null){
//            System.out.println("No numbers were entered");
//        }
//        else{
//            System.out.println("Smallest is : " + smallest);
//            System.out.println("Largest is: " + largest);
//        }
//    }
//}
//
////_______________________________________________________________________________
//
////problem 2
//import java.util.Scanner;
//
//public class problem {
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int aCount, cCount, eCount;
//        aCount = cCount = eCount = 0;
//        System.out.println("Enter a word or sentence: ");
//        String word = scan.nextLine();
//        System.out.println(word);
//        for(int i = 0; i < word.length(); i++){
//            if(word.charAt(i) == 'a' || word.charAt(i) == 'A')
//                aCount++;
//            else if(word.charAt(i) == 'c' || word.charAt(i) == 'C')
//                cCount++;
//            else if(word.charAt(i) == 'e' || word.charAt(i) == 'E')
//                eCount++;
//        }
//        System.out.println(aCount + " a\n" + cCount + " c\n" + eCount + " e" );
//    }
//}
//
////_______________________________________________________________________
//
////problem 3
//import java.util.Scanner;
//
//public class problem3 {
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        System.out.println("Enter a palindrome: ");
//        String input = scan.nextLine();
//        String inputNoSpecials = "";
//        String palindrome = "";
//        for(int i = input.length() - 1; i >= 0; i--){
//            if(Character.isAlphabetic(input.charAt(i))){
//                input = input.toLowerCase();
//                inputNoSpecials = input.charAt(i) + inputNoSpecials;
//                palindrome += input.charAt(i);
//            }
//        }
//        if(inputNoSpecials.equals(palindrome))
//            System.out.println(input + " is a palindrome");
//
//        else
//            System.out.println(input + " is not a palindrome");
//    }
//}
//
////___________________________________________________________________________________
//
////problem 4
//import java.util.ArrayList;
//import java.util.Scanner;
//
//public class problem4 {
//    public static void main(String[] args){
//        Scanner scan = new Scanner(System.in);
//        int input;
//        ArrayList<Integer> nums = new ArrayList<>();
//        System.out.println("Enter in any positive number: (-1 to end) ");
//        input = scan.nextInt();
//        while(input != -1){
//            if(input < -1)
//                System.out.println("Invalid number");
//            else
//                nums.add(input);
//            System.out.println("Enter in any positive number: (-1 to end) ");
//            input = scan.nextInt();
//        }
//        for(int i = 0; i < nums.size() - 1; i++){
//            for(int j = i + 1; j < nums.size(); j++){
//                int temp;
//                if(nums.get(j) < nums.get(i)){
//                    temp = nums.get(i);
//                    nums.set(i, nums.get(j));
//                    nums.set(j, temp);
//                }
//            }
//        }
//        for(int i = 0; i < nums.size(); i++){
//            System.out.println(nums.get(i));
//        }
//    }
//}
//
