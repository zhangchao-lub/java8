package java.util;

import org.junit.Test;

/**
 * @author czhang@mindpointeye.com
 * @version 1.0
 * @Date 2020/7/7 15:06
 * @descrption
 */
public class StringTest {

    @Test
    public void test() {
        char data[] = {'a', 'b', 'c'};
        String str = "abc";
        String str2= new String(data);
        System.out.println(str.equals(str2));
    }
}
