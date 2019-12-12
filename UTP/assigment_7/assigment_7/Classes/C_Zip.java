import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;
import java.util.zip.ZipEntry;
import java.util.zip.ZipFile;

import static java.util.stream.Collectors.toList;

public class C_Zip {

    public static List<ZipEntry> findSequential(ZipFile z, String name) throws IOException {
        Predicate<ZipEntry> isCalled = ze -> ze.getName().endsWith(name);
        List<ZipEntry> zipMatcherSequential = new ArrayList<>();
        zipMatcherSequential = z
                .stream()
                .filter(isCalled)
                .collect(toList());
        return zipMatcherSequential;
    }

    public static List<ZipEntry> findParallel(ZipFile z, String name) {
        Predicate<ZipEntry> isCalled = ze -> ze.getName().endsWith(name);
        List<ZipEntry> zipMatcherParallel = new ArrayList<>();

        zipMatcherParallel = z
                .stream()
                .parallel()
                .filter(isCalled)
                .collect(toList());
        return zipMatcherParallel;
    }

    public static List<ZipEntry> findContent(ZipFile z, String pattern) throws IOException {
        Predicate<ZipEntry> isFile = ze -> !ze.isDirectory();
        List<ZipEntry> zipContentList = new ArrayList<>();

        z.stream()
                .filter(isFile)
                .forEach(currentFile -> {
                            try {
                                if (new Scanner(z.getInputStream(currentFile)).findWithinHorizon(pattern, 0) != null) {
                                    zipContentList.add(currentFile);
                                }
                            } catch (IOException e) {
                                e.printStackTrace();
                            }
                        }
                );
        return zipContentList;
    }

}
