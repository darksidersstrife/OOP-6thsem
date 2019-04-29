import java.io.File;
import java.io.FileNotFoundException;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class IniParser {
    private Map<String, Map<String, String>> data = new HashMap<>();

    public String getAsString(String section, String key) throws EntryNotFoundException {
        Map<String, String> sectionData = data.get(section);
        if(sectionData == null) {
            throw new EntryNotFoundException();
        }
        String value = sectionData.get(key);
        if(value == null) {
            throw new EntryNotFoundException();
        }
        return value;
    }

    public long getAsInteger(String section, String key) throws EntryNotFoundException {
        return Long.parseLong(getAsString(section, key));
    }

    public double getAsDouble(String section, String key) throws EntryNotFoundException {
        return Double.parseDouble(getAsString(section, key));
    }

    public void Parse(String fileName) throws FileNotFoundException, BadFileFormatException {
        Scanner scanner = null;
        if(!fileName.substring(fileName.length() - 4).equals(".ini")){
            throw  new BadExtensionException();
        }
        scanner = new Scanner(new File(fileName));
        String section = null;
        while(scanner.hasNextLine()) {
            String line = scanner.nextLine().replaceFirst("\\s*;.*", "");
            if(line.length() == 0)
                continue;
            if(line.matches("\\[\\w+\\]")){
                section = line.substring(1, line.length() - 1);
            } else if (line.matches("\\w+\\s*=\\s*[\\w./]+")) {
                if(section == null)
                    throw new BadFileFormatException();
                Scanner lineScanner = new Scanner(line);
                lineScanner.useDelimiter("\\s*=\\s*");
                String key = lineScanner.next();
                String value = lineScanner.next();
                data.computeIfAbsent(section, k -> new HashMap<>());
                data.get(section).put(key, value);
            } else
                throw new BadFileFormatException();
        }
    }
}
