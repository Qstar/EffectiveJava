package chapter2_create_destroy_object.strengthSingleton;

/**
 * 优势:
 * 1.无偿提供了序列化机制,防止多次实例化,即使面对复杂的序列化或者反射攻击
 * 2.实现Singleton的最佳方法
 */

public enum Elvis2 {
    INSTANCE;

    public void leaveTheBuilding(){
    }
}
