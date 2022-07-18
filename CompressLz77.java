import java.util.ArrayList;
import java.util.Scanner;

public class CompressLz77 {
    public static void main(String[] args) {

        Scanner input = new Scanner(System.in);
        System.out.println("Enter Text do you need compress");
        String Text = input.nextLine();

        ArrayList<Integer> position = new ArrayList<Integer>();
        ArrayList<Integer> length = new ArrayList<Integer>();
        ArrayList<Character> NextSymbol = new ArrayList<Character>();

        String temp = "";
        for (int i = 0; i < Text.length(); i++) {
            temp = Text.substring(i, i + 1);
            int counter = i;
            for (int j = 0; j <= i; j++) {
                if (Text.substring(0, i).contains(temp)) {
                    if (counter + 1 < Text.length()) {
                        counter++;
                        temp = temp + Text.substring(counter, counter + 1);
                        continue;
                    }
                }
                if (j == 0) {
                    position.add(j);
                    length.add(j);
                    NextSymbol.add(temp.charAt(j));
                    break;
                } else if (Text.substring(0, i).contains(temp)) {
                    position.add(i - Text.indexOf(temp.substring(0, temp.length() - 1)));
                    length.add(j + 1);
                    NextSymbol.add(null);
                    break;
                } else {
                    position.add(i - Text.indexOf(temp.substring(0, temp.length() - 1)));
                    length.add(j);
                    NextSymbol.add(temp.charAt(j));
                    break;
                }
            }
            i = counter;
        }
        input.close();
        for (int i = 0; i < position.size(); i++)
            System.out.println("<" + position.get(i) + "," + length.get(i) + "," + NextSymbol.get(i) + ">");
    }
}
