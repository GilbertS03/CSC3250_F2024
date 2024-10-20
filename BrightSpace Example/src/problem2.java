import java.util.Scanner;

public class problem2 {
    public static void main(String[] args){
        Scanner scan = new Scanner(System.in);
        int aCount, cCount, eCount;
        aCount = cCount = eCount = 0;
        System.out.println("Enter a word or sentence: ");
        String word = scan.nextLine();
        System.out.println(word);
        for(int i = 0; i < word.length(); i++){
            if(word.charAt(i) == 'a' || word.charAt(i) == 'A')
                aCount++;
            else if(word.charAt(i) == 'c' || word.charAt(i) == 'C')
                cCount++;
            else if(word.charAt(i) == 'e' || word.charAt(i) == 'E')
                eCount++;
        }
        System.out.println(aCount + " a\n" + cCount + " c\n" + eCount + " e" );
    }
}
