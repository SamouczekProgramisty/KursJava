package pl.samouczekprogramisty.commandline;


import java.util.Scanner;
import org.apache.commons.lang3.StringUtils;


public class CheckName {
    public static void main(String ... args) {
        System.out.println("Podaj zdanie");
        Scanner scanner = new Scanner(System.in);
        String sentence = scanner.nextLine();

        if (StringUtils.containsIgnoreCase(sentence, "Marcin")) {
            System.out.println("To zdanie zawiera moje imie!");
        }
        else {
            System.out.println("To zdanie nie zawiera mojego imienia!");
        }
    }
}
