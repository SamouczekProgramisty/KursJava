package pl.samouczekprogramisty.kursjava.enums.withinlinemethods;

public enum Formatter {
    CALM {
        public String format(String message) {
            return "Here is your message: " + message;
        }
    },
    NERVOUS {
        public String format(String message) {
            return "ARGH! STOP BOTHERING ME WITH YOUR MESSAGE! " + message + " I'M NOT GOING TO ACCEPT ANYTHING MORE!";
        }
    };

    public abstract String format(String message);

    public static void main(String[] args) {
        System.out.println(Formatter.CALM.format("I'm calm :)"));
        System.out.println(Formatter.NERVOUS.format("I'm nervous :["));
    }
}
