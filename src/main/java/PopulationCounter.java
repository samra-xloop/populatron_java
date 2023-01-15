import java.text.NumberFormat;
import java.util.List;
import java.util.Locale;

public class PopulationCounter {
    public static void main(String[] args) throws Exception {  

        String path = args[0];
        
        ReadingInput Alllines = new ReadingInput();
        Parsing parsedDataOb= new Parsing();
        List<Long> parsedData=parsedDataOb.ParseTheLines(Alllines.ReadLinesFromCSV(path));
        Long summedPopulation=Sum.SumTheData(parsedData);


        String num = NumberFormat.getInstance(Locale.getDefault()).format(summedPopulation);
        System.out.printf("World population is: %s\n", num);
        
    }
    
}
