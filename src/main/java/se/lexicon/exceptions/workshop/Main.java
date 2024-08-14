package se.lexicon.exceptions.workshop;

import java.io.IOException;
import java.util.List;

import se.lexicon.exceptions.workshop.data_access.DuplicateNameException;
import se.lexicon.exceptions.workshop.data_access.NameService;
import se.lexicon.exceptions.workshop.domain.Person;
import se.lexicon.exceptions.workshop.fileIO.CSVReader_Writer;

public class Main {

    public static void main(String[] args) {

        try {
            List<String> maleFirstNames = CSVReader_Writer.getMaleFirstNames();
            List<String> femaleFirstNames = CSVReader_Writer.getFemaleFirstNames();
            List<String> lastNames = CSVReader_Writer.getLastNames();

            NameService nameService = new NameService(maleFirstNames, femaleFirstNames, lastNames);

            // Adding a new name (for testing)
            try {
                nameService.addFemaleFirstName("Emma");
            } catch (DuplicateNameException e) {
                System.out.println("Error: " + e.getMessage());
            }

            Person test = nameService.getNewRandomPerson();
            System.out.println(test);

        } catch (IOException e) {
            System.err.println("An error occurred while reading the files: " + e.getMessage());
        }
    }
}