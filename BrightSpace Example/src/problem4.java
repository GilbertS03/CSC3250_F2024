import java.util.ArrayList;
import java.util.Scanner;

public class problem4 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int input;
        ArrayList <Integer> nums = new ArrayList<>();
        System.out.println("Enter in any positive number: (-1 to end) ");
        input = scan.nextInt();
        while(input != -1){
            if(input < -1)
                System.out.println("Invalid number");
            else
                nums.add(input);
            System.out.println("Enter in any positive number: (-1 to end) ");
            input = scan.nextInt();
        }
        for(int i = 0; i < nums.size() - 1; i++){
            for(int j = i + 1; j < nums.size(); j++){
                int temp;
                if(nums.get(j) < nums.get(i)){
                    temp = nums.get(i);
                    nums.set(i, nums.get(j));
                    nums.set(j, temp);
                }
            }
        }
        for(int i = 0; i < nums.size(); i++){
            System.out.println(nums.get(i));
        }
    }
}
