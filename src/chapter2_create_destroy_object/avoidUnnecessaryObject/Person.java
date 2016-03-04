package chapter2_create_destroy_object.avoidUnnecessaryObject;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;


//每次调用不会产生新的对象,只在初始化时创建
public class Person {
    private static final Date BOOM_START;
    private static final Date BOOM_END;

    //延迟加载
    static{
        Calendar gmtCal = Calendar.getInstance(TimeZone.getTimeZone("GMT"));
        gmtCal.set(1964, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_START = gmtCal.getTime();
        gmtCal.set(1965, Calendar.JANUARY, 1, 0, 0, 0);
        BOOM_END = gmtCal.getTime();
    }

    private final Date birthDay;

    public Person(Date birthDay){
        this.birthDay = birthDay;
    }

    public boolean isBabyBoomer(){
        return birthDay.compareTo(BOOM_START) >= 0 && birthDay.compareTo(BOOM_END) < 0;
    }

}
