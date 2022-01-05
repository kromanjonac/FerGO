package Utils;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;

public class RaceResultParserUtilities {

    public static String newFormattedLine(String input){ // formats txt output from ergrace
        StringBuilder sb = new StringBuilder();
        String[] arr = input.split("\\,");
        int[] indices = {0,3,1,4};
        for (int i = 0; i < 4; i++) {
            sb.append(arr[indices[i]].trim()).append("   ");
            //System.out.println(arr[indices[i]]);
        }
        return sb.append("\n").toString();
    }

    public static String createFormattedFile(String paths, String name){ //creates excel ready file
        if (paths == null) {return "false";} //should never happen
        Path path = Paths.get(paths);
        Path newFile = Paths.get("C:\\Users\\dobar\\OneDrive\\Radna površina\\Coding\\test_map\\".concat(name));
        try {
            FileWriter myWriter = new FileWriter("C:\\Users\\dobar\\OneDrive\\Radna površina\\Coding\\test_map\\".concat(name));
            Files.readAllLines(path).stream().filter(o -> {//lambda that filters actual (usable) data from description
                if( o.split("\\,").length == 7 && !o.startsWith("Place")){
                    return true;
                }
                return false;
            }).forEach(o -> { //lambda that writes all the lines to the created txt file
                try {
                    myWriter.write(newFormattedLine(o));
                } catch (IOException e) {
                    e.printStackTrace();
                }
            });
            myWriter.close();
            return "C:\\Users\\dobar\\OneDrive\\Radna površina\\Coding\\test_map\\".concat(name);
        } catch (IOException e) {
            e.printStackTrace();
        }
        return "false";

    }
}
