import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.io.TempDir;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import static org.junit.jupiter.api.Assertions.*;

class FileWriterTest {

   /* Ensure that the Path given to you by the @TempDir annotation if writable
    Ensure that a appending to a file with FileWriter.appendFile which has not yet been created with FileWriter.createFile throws an exception
    Ensure that you can write to the file once you created it */

    @Test
    void ensureThatPathFromTempDirISWritable(@TempDir Path path) {
        assertTrue(Files.isWritable(path));
        // Check if the path created by the TempDir extension is writable
        // Check `Files` API for this
    }

    @Test
    void ensureThatNonExistingFileThrowsException(@TempDir Path path) {
        Path file = path.resolve("Text.txt");
        assertThrows(IOException.class, ()->{
            FileWriter.appendFile(file, "any thing");

        });


    }

    @Test
    void ensureAppendingWorks(@TempDir Path path) throws IOException {
        Path file = path.resolve("Text.txt");
        FileWriter.createFile(file);
        FileWriter.appendFile(file, "Any Text");

        assertTrue(Files.isReadable(file));

    }




}