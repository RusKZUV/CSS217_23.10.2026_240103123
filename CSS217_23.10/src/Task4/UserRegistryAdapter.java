package Task4;

public class UserRegistryAdapter implements UserRegistry {
    private LegacyUserFeed feed;

    public UserRegistryAdapter(LegacyUserFeed feed) {
        this.feed = feed;
    }

    public UserProfile fetchUser() {
        String raw = feed.getRawRecord();
        String[] parts = raw.split("#");

        if (parts.length != 3) {
            throw new IllegalArgumentException("Invalid format");
        }

        String id = parts[0];
        String email = parts[1];
        int level;

        try {
            level = Integer.parseInt(parts[2]);
        } catch (NumberFormatException e) {
            throw new IllegalArgumentException("Access level must be a number");
        }

        return new UserProfile(id, email, level);
    }
}