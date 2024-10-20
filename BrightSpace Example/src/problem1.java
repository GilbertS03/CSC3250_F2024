import java.util.ArrayList;
import java.util.Scanner;

public class problem1 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        ArrayList<Integer> nums = new ArrayList<>();
        System.out.println("Enter in a number: (-1 to stop)");
        int largest, smallest;
        int x = scan.nextInt();
        while(x != -1){
            nums.add(x);
            System.out.println("Enter in a number: (-1 to stop)");
            x = scan.nextInt();
        }
        smallest = largest = nums.get(0);
        for(int i = 0; i < nums.size(); i++){

            if(nums.get(i) > largest)
                largest = nums.get(i);
            if(nums.get(i) < smallest)
                smallest = nums.get(i);
        }
        System.out.println("Smallest is : " + smallest);
        System.out.println("Largest is: " + largest);
    }
}
