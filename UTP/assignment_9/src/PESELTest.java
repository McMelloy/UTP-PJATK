import org.junit.Assert;
import org.junit.Test;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PESELTest {

    @Test
    public void validate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {
        Method method = PESEL.class.getDeclaredMethod("validate", String.class);
        method.setAccessible(true);
        Boolean result1 = (Boolean) method.invoke("","20233143600");
        Boolean result2 = (Boolean) method.invoke("", "4405140135");
        Assert.assertTrue(result1);
        Assert.assertFalse(result2);

    }

    @Test
    public void getDate() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException, ParseException {
        Method method = PESEL.class.getDeclaredMethod("getDate", String.class);
        method.setAccessible(true);
        Date exp = new SimpleDateFormat("yyyy-MM-dd").parse("2020-04-31");
        Date dateResult = (Date) method.invoke("", "20233143600");
        Assert.assertEquals(exp, dateResult);
    }

    @Test
    public void getGender() throws NoSuchMethodException, InvocationTargetException, IllegalAccessException {
        Method method = PESEL.class.getDeclaredMethod("getGender",String.class);
        method.setAccessible(true);
        Gender G = (Gender) method.invoke("","20233143600");
        Assert.assertSame(G, Gender.FEMALE);
    }
}
