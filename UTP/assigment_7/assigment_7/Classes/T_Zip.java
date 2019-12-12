import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

public class T_Zip {

    @Test
    public void findSequential() throws IOException {
        List<ZipEntry> result = C_Zip.findSequential(new ZipFile("C:\\Study\\PJATK\\UTP\\assigment_7\\files\\files.zip"),"Class.sql");
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void findContent() throws IOException {
        List<ZipEntry> result = C_Zip.findContent(new ZipFile("C:\\Study\\PJATK\\UTP\\assigment_7\\files\\files.zip"), "NOW");
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void findParallel() throws IOException {
        List<ZipEntry> result = C_Zip.findParallel(new ZipFile("C:\\Study\\PJATK\\UTP\\assigment_7\\files\\files.zip"),"Class.sql");
        Assert.assertEquals(1, result.size());
    }

}