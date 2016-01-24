package pl.samouczekprogramisty.kursjava;

/**
 * Created by mapi on 09.11.15.
 */
public class Arrays {
    public static void main(String[] args) {
        String[] daysOfWeek = new String[7];
        daysOfWeek[0] = "poniedziałek";
        daysOfWeek[1] = "wtorek";
        daysOfWeek[2] = "środa";
        daysOfWeek[3] = "czwartek";
        daysOfWeek[4] = "piątek";
        daysOfWeek[5] = "sobota";
        daysOfWeek[6] = "niedziela";
        System.out.println(daysOfWeek[2]);
        System.out.println(daysOfWeek.length);

        String[] wintersMonths = new String[] {"grudzień", "styczeń", "luty"};
        System.out.println(wintersMonths[2]);

        int[][] ticTacToeBoard = new int[3][];
        ticTacToeBoard[0] = new int[3];
        ticTacToeBoard[1] = new int[3];
        ticTacToeBoard[2] = new int[3];

        Object[] x = new Object[123];
        x[0] = "";
        x[1] = 1;
        x[2] = 1.23;
    }

    public void methodVarArgs1(int ... days) {
    }

    public void methodVarArgs2(boolean flag, int ... days) {
    }

    public void methodVarArgs3(int flag, int ... days) {
    }
}
