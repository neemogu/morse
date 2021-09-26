import java.io.*;
import java.util.Scanner;

public class FileAlphabet extends Alphabet {
    public FileAlphabet(String filename) {
        super();
        InputStream fileStream = Utils.class.getClassLoader().getResourceAsStream(filename);
        if (fileStream == null) {
            System.err.println("Cannot open an alphabet file with name " + filename);
            return;
        }
        Scanner rd = new Scanner(new BufferedInputStream(fileStream));
        String[] nextLine;
        while (rd.hasNextLine()) {
            nextLine = rd.nextLine().split(" ");
            putToAlphabet(nextLine[0], nextLine[1]);
        }
    }
}
