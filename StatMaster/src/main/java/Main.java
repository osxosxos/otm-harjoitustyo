
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);

        while (true) {
            System.out.println("1 = aloita, 2 = lopeta");
            int kasky = Integer.parseInt(scanner.nextLine());
            if (kasky == 1) {
                PearsonKorrelaatioTehtava tehtava = new PearsonKorrelaatioTehtava();
                tehtava.luoUusiTehtava();
                //Kommenttien poisto antaa oikean vastauksen tehtävään!
                //System.out.println(tehtava.r.cor);
                //System.out.println(tehtava.r.t);
                //System.out.println(tehtava.r.pArvo);
                tehtava.suorita();
            } else if (kasky == 2) {
                break;
            }

        }

    }

}
