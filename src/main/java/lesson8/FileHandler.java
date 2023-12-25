package lesson8;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;

class UncheckedException extends RuntimeException {
    public UncheckedException(String message) {
        super(message);
    }
}

public class FileHandler {

    private static final Logger LOGGER = Logger.getLogger(FileHandler.class.getName());

    public void readFileAndThrowException(String filePath) {
        try (BufferedReader reader = new BufferedReader(new FileReader(filePath))) {
            String line = reader.readLine();
            if (line == null || line.isEmpty()) {
                throw new UncheckedException("Custom Unchecked Exception: Empty file or line.");
            }
        } catch (IOException e) {
            LOGGER.log(Level.SEVERE, "IOException occurred while reading the file", e);
        }
    }

    public static void main(String[] args) {
        FileHandler fileHandler = new FileHandler();
        String filePath = "path/to/file.txt";
        try {
            fileHandler.readFileAndThrowException(filePath);
        } catch (UncheckedException e) {
            LOGGER.log(Level.SEVERE, "Custom Unchecked Exception caught: " + e.getMessage(), e);
        }
    }
}