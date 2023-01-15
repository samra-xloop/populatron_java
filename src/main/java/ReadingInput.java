import java.io.IOException;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class ReadingInput {
    ReadingInput(){
    }
    public List<String> ReadLinesFromCSV(String path) throws IOException{
        List<String> lines = Files.readAllLines(Paths.get(path), StandardCharsets.ISO_8859_1);
        if(lines.isEmpty()){
            return new ArrayList<>();
        }
        return lines;
    }
}
