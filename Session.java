package clinic.util;

public class Session {
    public static int accountId;
    public static String username;
    public static String fullName;
    public static String role;

    public static void clear() {
        accountId = 0;
        username = null;
        fullName = null;
        role = null;
    }
}
