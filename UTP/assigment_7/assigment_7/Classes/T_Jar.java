import org.junit.Assert;
import org.junit.Test;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;

public class T_Jar {

    @Test
    public void findSequential() throws IOException {
        List<JarEntry> result = C_Jar.findSequential(new JarFile("C:\\Study\\PJATK\\UTP\\assigment_7\\files\\files.jar"),"Class.sql");
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void findContent() throws IOException {
        List<JarEntry> result = C_Jar.findContent(new JarFile("C:\\Study\\PJATK\\UTP\\assigment_7\\files\\files.jar"), "NOW");
        Assert.assertEquals(1, result.size());
    }

    @Test
    public void findParallel() throws IOException {
        List<JarEntry> result = C_Jar.findParallel(new JarFile("C:\\Study\\PJATK\\UTP\\assigment_7\\files\\files.jar"),"Class.sql");
        Assert.assertEquals(1, result.size());
    }

}