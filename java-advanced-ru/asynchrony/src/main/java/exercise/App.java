package exercise;

import java.util.concurrent.CompletableFuture;
import java.util.Arrays;
import java.nio.file.Paths;
import java.nio.file.Path;
import java.nio.file.Files;
import java.io.File;
import java.nio.file.StandardOpenOption;

class App {

    // BEGIN
    public static CompletableFuture<String> unionFiles(String source1, String source2, String dest) {

        CompletableFuture<String> content1 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Paths.get(source1).toAbsolutePath());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        CompletableFuture<String> content2 = CompletableFuture.supplyAsync(() -> {
            try {
                return Files.readString(Paths.get(source2).toAbsolutePath());
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        });

        return content1.thenCombine(content2, (cont1, cont2) -> {
            try {
                Files.writeString(Paths.get(dest).toAbsolutePath(), cont1 + cont2, StandardOpenOption.CREATE);
                return "ok!";
            } catch (Exception e) {
                throw new RuntimeException(e);
            }
        }).exceptionally(ex -> {
            System.out.println("Oops! We have an exception - " + ex.getMessage());
            return "Unknown!";
        });
    }
    // END

    public static void main(String[] args) throws Exception {
        // BEGIN
        CompletableFuture<String> result = unionFiles(
                "src/main/resources/file1.txt",
                "src/main/resources/file2.txt",
                "src/main/resources/dest.txt"
        );
        result.get();
        System.out.println("done!");
        // END
    }
}