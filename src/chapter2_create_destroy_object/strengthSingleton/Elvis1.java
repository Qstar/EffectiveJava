package chapter2_create_destroy_object.strengthSingleton;

import java.io.Serializable;

/**
 * 保证反序列化时也只生成一个实例
 */

public class Elvis1 implements Serializable {
    private static final Elvis1 INSTANCE = new Elvis1();

    private Elvis1(){
    }

    public static Elvis1 getInstance(){
        return INSTANCE;
    }

    public void leaceTheBuilding(){
    }

    private Object readResolve(){
        return INSTANCE;
    }

}
