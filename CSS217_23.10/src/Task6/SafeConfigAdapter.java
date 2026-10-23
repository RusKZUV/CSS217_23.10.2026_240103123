package Task6;

public class SafeConfigAdapter implements ConfigService {
    private FlakyConfig flakyConfig;

    public SafeConfigAdapter(FlakyConfig flakyConfig) {
        this.flakyConfig = flakyConfig;
    }


    public String readKey(String key) {
        try {
            return flakyConfig.getRaw(key);
        } catch (java.io.IOException | java.sql.SQLException e) {
            throw new ConfigNotFoundException("Failed to read key: " + key, e);
        }
    }
}