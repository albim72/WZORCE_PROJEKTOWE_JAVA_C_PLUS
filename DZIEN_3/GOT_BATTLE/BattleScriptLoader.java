package utils;

import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;

public class BattleScriptLoader {
    public static List<String> loadScript(String path) throws Exception {
        return Files.readAllLines(Paths.get(path));
    }
}
