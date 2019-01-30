package lab.mon.actlab.java.reflect.array;

import java.io.BufferedReader;
import java.io.CharArrayReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.lang.reflect.Field;
import java.util.Arrays;
import static java.lang.System.out;

public class GrowBufferedReader {
    private static final int srcBufSize = 10 * 1024;
    private static char[] src = new char[srcBufSize];
    static {
        src[srcBufSize - 1] = 'x';
    }
    private static CharArrayReader car = new CharArrayReader(src);

    public static void main(String... args) {
        try {
            //创建一个rander
            BufferedReader br = new BufferedReader(car);
            //获取cb
            Class<?> c = br.getClass();
            Field f = c.getDeclaredField("cb");
            //因为字段cb是private所以获取权限
            f.setAccessible(true);
            //转换
            char[] cbVal = char[].class.cast(f.get(br));
            //将数组替换为更大的数组
            char[] newVal = Arrays.copyOf(cbVal, cbVal.length * 2);
            if (args.length > 0 && args[0].equals("grow"))
                f.set(br, newVal);

            for (int i = 0; i < srcBufSize; i++)
                br.read();

            if (newVal[srcBufSize - 1] == src[srcBufSize - 1])
                out.format("新的数组, size=%d%n", newVal.length);
            else
                out.format("原始数组, size=%d%n", cbVal.length);

        } catch (FileNotFoundException x) {
            x.printStackTrace();
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        } catch (IOException x) {
            x.printStackTrace();
        }
    }
}