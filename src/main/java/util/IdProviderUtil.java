package util;

import java.util.UUID;

public class IdProviderUtil {

    public static String generate() {
        UUID uuid = UUID.randomUUID();
        return uuid.toString();
    }
}
