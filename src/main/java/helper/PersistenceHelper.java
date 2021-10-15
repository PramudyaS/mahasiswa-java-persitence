package helper;

import jakarta.persistence.EntityManagerFactory;
import jakarta.persistence.Persistence;

public class PersistenceHelper {
    private static final EntityManagerFactory factory;

    static {
        factory = Persistence.createEntityManagerFactory("tugasBesar1");
    }

    public static EntityManagerFactory getFactory() {
        return factory;
    }
}
