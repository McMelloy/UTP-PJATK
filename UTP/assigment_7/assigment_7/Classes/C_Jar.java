import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.jar.JarEntry;
import java.util.jar.JarFile;
import java.util.zip.ZipEntry;

import static java.util.stream.Collectors.toList;

public class C_Jar {

    public static List<JarEntry> findSequential(JarFile j, String name) throws IOException {
        Predicate<JarEntry> isCalled = p -> p.getName().endsWith(name);
        List<JarEntry> jarMatcherSequential = new ArrayList<>();
        jarMatcherSequential = j.stream()
                .filter(isCalled)
                .collect(toList());
        return jarMatcherSequential;
    }


    public static List<JarEntry> findParallel(JarFile j, String name) throws IOException {
        Predicate<JarEntry> isCalled = p -> p.getName().endsWith(name);
        List<JarEntry> jarMatcherParallel = new ArrayList<>();

        jarMatcherParallel = j.stream()
                .parallel()
                .filter(isCalled)
                .collect(toList());
        return jarMatcherParallel;
    }

    public static List<JarEntry> findContent(JarFile j, String pattern) {
        Predicate<JarEntry> isFile = ze -> !ze.isDirectory();
        List<JarEntry> jarEntryList = new ArrayList<>();

        j.stream()
                .filter(isFile)
                .forEach(currentFile -> {
                            try {
                                if (new Scanner(j.getInputStream(currentFile)).findWithinHorizon(pattern, 0) != null) {
                                    jarEntryList.add(currentFile);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
        return jarEntryList;
    }

}
