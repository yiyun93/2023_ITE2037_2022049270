package Week2;

public class Practice2 {

    public static void main(String[] args){
        String input = "Walt Savitch";
        String output = null;

        int space = input.indexOf(" ");
        String word1 = input.substring(0, space);
        String word2 = input.substring(space+1);

        word1 = word1 + word1.charAt(0);
        word2 = word2 + word2.charAt(0);

        word1 = word1.toUpperCase().substring(1) + "ay";
        word2 = word2.toUpperCase().substring(1) + "ay";

        word1 = word1.charAt(0) + word1.substring(1).toLowerCase();
        word2 = word2.charAt(0) + word2.substring(1).toLowerCase();

        output = word1 + " " + word2;
        System.out.println(output);

    }
}
