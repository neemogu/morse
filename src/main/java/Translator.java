import java.io.*;

public class Translator {
    private static final String statFileName = "stat.txt";
    private static final String abcFilePath = "morse.csv";

    public static void main(String[] args) {
        Coder cd = parseArguments(args);
        if (cd == null) {
            System.err.println("Usage: filename [code/decode]");
            return;
        }
        Alphabet abc = new FileAlphabet(abcFilePath);
        StatisticsCounter stat = new StatisticsCounter();
        System.out.println(cd.translate(abc, stat));
        Utils.writeToFile(stat.toString(), statFileName);
    }

    private static Coder parseArguments(String[] args) {
        if (args.length != 2) {
            return null;
        }
        String in = Utils.readFile(args[1]);
        if (in.isEmpty()) {
            return null;
        }
        Coder cd;
        if (args[0].equals("code")) {
            return new Encoder(in);
        }
        else if (args[0].equals("decode")) {
            return new Decoder(in);
        }
        else {
            return null;
        }
    }
}
