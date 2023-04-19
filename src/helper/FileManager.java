package helper;

import java.io.File;
import java.io.IOException;

public class FileManager {

    public FileManager(String filename) throws IOException {
        System.out.println(new File(".").getCanonicalPath());
    }
}
