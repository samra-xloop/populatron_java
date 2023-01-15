import java.nio.charset.StandardCharsets;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;


public class Parsing {
    Parsing(){
    }

    public List<Long> ParseTheLines(List<String> lines){
        List<Long> listOfCityPopulation=new ArrayList<>();
        for(int i = 1; i < lines.size(); i++) {
            String line = lines.get(i);
            String[] terms = line.split(",");   
            String popText = terms[4];
                if(popText.length() == 0) {
                    continue;
                }
            Long population = (long) Integer.parseInt(popText);
            listOfCityPopulation.add(population);
            
        }
        return listOfCityPopulation;
    }
        
}
