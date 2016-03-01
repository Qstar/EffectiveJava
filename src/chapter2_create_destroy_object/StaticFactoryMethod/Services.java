package chapter2_create_destroy_object.StaticFactoryMethod;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

/**
 * 静态工厂方法代替构造器
 * 优势
 * 1. 有适当的名称
 * 2. 不用每次新建一个对象
 * 3. 可以返回任何子类型的对象
 * 4. 代码更简洁
 * <p/>
 * 劣势
 * 1. 类如果不含有公有或者受保护的构造器就不能子类化
 * 2. 与其它静态方法没有区别
 */

public class Services {
    public static final String DEFAULT_PROVIDER_NAME = "<def>";
    private static final Map<String, Provider> providers =
            new ConcurrentHashMap<String, Provider>();

    public Services(){
    }

    //Provider registration API
    public static void registerDefaultProvider(Provider p){
        registerProvider(DEFAULT_PROVIDER_NAME, p);
    }

    public static void registerProvider(String name, Provider p){
        providers.put(name, p);
    }

    //Service access API
    public static Service newInstance(){
        return newInstance(DEFAULT_PROVIDER_NAME);
    }

    public static Service newInstance(String name){
        Provider p = providers.get(name);
        if (null == p) {
            throw new IllegalArgumentException(
                    "No provider registered with name: " + name);
        }
        return p.newService();
    }
}
