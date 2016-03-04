package Chapter2.Item1;// Service provider framework sketch

// Noninstantiable class for service registration and access - Pages 8-9

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

public class Services {
    public static final String DEFAULT_PROVIDER_NAME = "<def>";
    // Maps service names to services
    private static final Map<String, Provider> providers =
            new ConcurrentHashMap<String, Provider>();

    private Services(){
    }  // Prevents instantiation (Item 4)

    // Provider registration API
    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p){
        providers.put(name, p);
    }

    // Service access API
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if (p == null)
            throw new IllegalArgumentException(
                    "No provider registered with name: " + name);
        return p.newService();
    }
}
