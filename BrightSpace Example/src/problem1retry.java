import java.util.Scanner;

public class problem1retry {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        System.out.println("Enter in a number: (-1 to stop)");
        Integer largest, smallest;
        int ctr = 0;
        largest = smallest = null;
        int x = scan.nextInt();
        while(x != -1){
            if(ctr == 0)
                largest = smallest = x;
            else{
                if(x > largest)
                    largest = x;
                else if (x < smallest)
                    smallest = x;
            }
            System.out.println("Enter in a number: (-1 to stop)");
            x = scan.nextInt();
            ctr++;
        }
        if(smallest == null && largest == null){
            System.out.println("No numbers were entered");
        }
        else{
            System.out.println("Smallest is : " + smallest);
            System.out.println("Largest is: " + largest);
        }
    }
}
