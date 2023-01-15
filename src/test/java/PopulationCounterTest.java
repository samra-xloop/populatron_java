import static org.junit.jupiter.api.Assertions.*;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.PrintStream;
import java.util.List;

import org.junit.jupiter.api.Test;




public class PopulationCounterTest {
    @Test
    public void testSomeLibraryMethod() throws Exception {

        // Setup
        String expected = "World population is: 1,347,982,728\n";

        // https://stackoverflow.com/questions/8708342/redirect-console-output-to-string-in-java
        ByteArrayOutputStream baos = new ByteArrayOutputStream();
        PrintStream ps = new PrintStream(baos);
        PrintStream old = System.out;
        System.setOut(ps);

        // Exercise
        PopulationCounter.main(new String[] {"./data/worldcitiespop.csv"});

        // Assert
        System.out.flush();
        String output = baos.toString();
        assertEquals(expected, output );

        // Teardown
        System.setOut(old);
    }

    
    @Test
    public void testValidFilePath() throws IOException {
        // Arrange
        ReadingInput readingInput = new ReadingInput();
        String filePath = "./data/worldcitiespop.csv";

        // Act
        List<String> lines = readingInput.ReadLinesFromCSV(filePath);

        // Assert
        assertFalse(lines.isEmpty(), "The file should contain some data");
    }
    @Test
    public void testEmptyFile() throws IOException {
        // Arrange
        ReadingInput readingInput = new ReadingInput();
        String filePath = "./data/emptyFile.csv";
        


        // Act
        List<String> lines = readingInput.ReadLinesFromCSV(filePath);

        // Assert
        assertTrue(lines.isEmpty(), "The file should be empty, but it contains some data");
    }

    @Test
    public void testParsedData() throws Exception{
        //Arrange
        ReadingInput readingInput = new ReadingInput();
        String filePath = "./data/dataOfTwoCitites.csv";
        List<String> lines = readingInput.ReadLinesFromCSV(filePath);
        Parsing parsedDataOb= new Parsing();
        

        //Act 
        List<Long> parsedData=parsedDataOb.ParseTheLines(lines);
        
        //Assert

        assertEquals(1, parsedData.size(), "should contain only one population as the population for aixas is empty");
        assertTrue((parsedData.get(0)) instanceof Long, "return type of the parsed data should be long");
    }

    
}
