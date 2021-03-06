package Chapter2.Item3.enum1;

// Enum singleton - the preferred approach - page 18
public enum Elvis {
    INSTANCE;

    // This code would normally appear outside the class!
    public static void main(String[] args){
        Elvis elvis = Elvis.INSTANCE;
        elvis.leaveTheBuilding();
    }

    public void leaveTheBuilding(){
        System.out.println("Whoa baby, I'm outta here!");
    }
}
