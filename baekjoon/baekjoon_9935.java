import java.util.Scanner;

public class Main {
    static String origin;
    static String boom;
    static int originSize, boomSize;

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        origin = sc.next();
        boom = sc.next();

        originSize = origin.length();
        boomSize = boom.length();


    }
}
