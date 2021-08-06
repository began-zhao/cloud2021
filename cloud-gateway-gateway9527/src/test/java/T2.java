import org.junit.jupiter.api.Test;

import java.time.ZonedDateTime;

public class T2 {

    @Test
    public void test1()
    {
        ZonedDateTime zbj=ZonedDateTime.now();//默认时区
        System.out.println(zbj);
    }
}
