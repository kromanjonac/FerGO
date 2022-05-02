package Utils;

import CustomClasses.RaceEvent;
import MainPackage.Main;

import java.io.FileWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;

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
        Path newFile = Paths.get(Main.finalResPath.toString().concat("_formated_").concat(name));
        try {
            FileWriter myWriter = new FileWriter(newFile.toString());
            Files.readAllLines(path).stream().filter(o -> {//lambda that filters actual (usable) data from description
                if( o.split("\\,").length == 7 && !o.startsWith("Place")){
                    return true;
                }
                return false;
            }).forEach(o -> { //lambda that writes all the lines to the created txt file
                try {
                    System.out.println(newFormattedLine(o));
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
    public static void updateRaceEventFromFile(RaceEvent raceEvent, String pathname) throws IOException {
        Path raceResultFile = Paths.get(pathname);
        List<String> lines = Files.readAllLines(raceResultFile);
        for (var s : lines){
            String[] parsedLine = s.split("   ");
            String[] timeStringArr = parsedLine[2].split(":");
            double time = 0.;
            time += Double.parseDouble(timeStringArr[0]);
            time += Double.parseDouble(timeStringArr[1]);
            String sName = parsedLine[1].split(" - ")[1];
            String rowerName = parsedLine[1].split(" - ")[0];
            for (var x : raceEvent.getTeamList()){
                if(x.getShortName().equals(sName)){
                    x.setTotalTime(x.getTotalTime() + time);
                    for(var rower : x.getRowers()){
                        if (rower.getName().equals(rowerName)){rower.setTime(time);}
                    }

                }
            }
        }
    }
}
