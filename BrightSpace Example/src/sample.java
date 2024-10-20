import java.util.ArrayList;
import java.util.Scanner;

public class sample {
    public static void main(String[] args){
        ArrayList<Integer> nums = new ArrayList<>();
        Scanner scan = new Scanner(System.in);
        nums.add(19);
        nums.add(7);
        nums.add(23);
        System.out.println(nums);
        for(int i = 0; i < nums.size(); i++){
            System.out.println("Element " + i + " is: " + nums.get(i));
        }
    }
}
