package Chapter11.Item77;// Broken singleton - has nontransient object reference field! - Page 309

import java.io.ObjectStreamException;
import java.io.Serializable;
import java.util.Arrays;

// Broken singleton - has nontransient object reference field!
public class Elvis implements Serializable {
    public static final Elvis INSTANCE = new Elvis();
    private String[] favoriteSongs =
            {"Hound Dog", "Heartbreak Hotel"};

    private Elvis(){
    }

    public void printFavorites(){
        System.out.println(Arrays.toString(favoriteSongs));
    }

    private Object readResolve() throws ObjectStreamException{
        return INSTANCE;
    }
}
