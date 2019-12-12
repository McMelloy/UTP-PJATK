import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.function.Predicate;

import static java.util.stream.Collectors.toList;

public class C_File {

    public static List<File> findSequential(File f, String name) throws IOException {
        Predicate<Path> isCalled = p -> p.endsWith(name);
        List<File> filesMatcherSequential = new ArrayList<>();

        filesMatcherSequential = Files.walk(f.toPath())
                .filter(isCalled)
                .map(Path::toFile)
                .collect(toList());
        return filesMatcherSequential;
    }


    public static List<File> findParallel(File f, String name) throws IOException {
        Predicate<Path> isCalled = p -> p.endsWith(name);
        List<File> filesMatcherParallel = new ArrayList<>();


        filesMatcherParallel = Files.walk(f.toPath())
                .parallel()
                .filter(isCalled)
                .map(Path::toFile)
                .collect(toList());
        return filesMatcherParallel;

    }

    public static List<File> findContent(File f, String pattern) throws IOException {
        List<File> fileContentList = new ArrayList<>();

        Files
                .newDirectoryStream(Paths.get(f.getPath()), path -> path.toFile().isFile())
                .forEach(currentFile -> {
                    try {
                        if(new Scanner(currentFile).findWithinHorizon(pattern, 0) != null)
                            fileContentList.add(currentFile.toFile());
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                })
        ;
        return fileContentList;

    }




}
