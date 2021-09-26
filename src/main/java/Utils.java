import java.io.*;

public class Utils {
    public static String readFile(String filename) {
        StringBuilder result = new StringBuilder();
        try (Reader rd = new InputStreamReader(new FileInputStream(filename))) {
            int next;
            while ((next = rd.read()) != -1) {
                result.append(Character.toString(next));
            }
        }
        catch (IOException e) {
            System.err.println("Reading file error: " + e.getMessage());
        }
        return result.toString();
    }

    public static void writeToFile(String str, String filename) {
        try (BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream(filename)))) {
            writer.write(str);
        } catch (FileNotFoundException e) {
            System.err.println("File " + filename + " not found");
        } catch (IOException e) {
            System.err.println("Reading file error: " + e.getMessage());
        }
    }
}
