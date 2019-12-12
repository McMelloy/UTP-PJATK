import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.nio.file.Path;
import java.util.List;
import java.util.Scanner;
import java.util.jar.JarFile;
import java.util.zip.ZipFile;

import static org.hamcrest.CoreMatchers.containsString;

public class T_File {

    @Test
    public void findSequential() throws IOException {
        List<File> result = C_File.findSequential(new File("C:\\Study\\PJATK\\UTP\\assigment_7\\files"),"Class.sql");
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void findContent() throws IOException {
        List<File> result = C_File.findContent(new File("C:\\Study\\PJATK\\UTP\\assigment_7\\files"), "NOW");
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void findParallel() throws IOException {
        List<File> result = C_File.findParallel(new File("C:\\Study\\PJATK\\UTP\\assigment_7\\files"),"Class.sql");
        Assert.assertEquals(1, result.size());
    }

}