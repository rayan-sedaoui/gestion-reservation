package ma.projet.util;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.util.stream.Collectors;

public class DatabaseMigrationTool {
    
    private final String jdbcUrl;
    private final String username;
    private final String password;
    
    public DatabaseMigrationTool(String jdbcUrl, String username, String password) {
        this.jdbcUrl = jdbcUrl;
        this.username = username;
        this.password = password;
    }
    
    public void executeMigration() throws Exception {
        try (Connection connection = DriverManager.getConnection(jdbcUrl, username, password)) {
            
            InputStream inputStream = new FileInputStream("src/main/resources/migration_v2.sql");
            
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String migrationScript = bufferedReader.lines().collect(Collectors.joining("\n"));
            String[] instructions = migrationScript.split(";");
            
            try (Statement statement = connection.createStatement()) {
                for (String instruction : instructions) {
                    String cleanInstruction = instruction.trim();
                    if (!cleanInstruction.isEmpty() && !cleanInstruction.startsWith("DELIMITER") && !cleanInstruction.startsWith("END //")) {
                        statement.execute(cleanInstruction);
                    }
                }
            }
        }
    }
}