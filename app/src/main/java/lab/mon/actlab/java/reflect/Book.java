package lab.mon.actlab.java.reflect;
import java.lang.reflect.Field;
import java.util.Arrays;
import static java.lang.System.out;

enum Tweedle { DEE, DUM }

public class Book {
    public long chapters = 0;
    public String[] characters = { "Alice", "White Rabbit" };
    public Tweedle twin = Tweedle.DEE;

    public void main(String... args) {
        Book book = new Book();
        String fmt = "%6S:  %-12s = %s%n";

        try {
            //拿到book类
            Class<?> c = book.getClass();
            //拿到chapters
            Field chap = c.getDeclaredField("chapters");
            out.format(fmt, "before", "chapters", book.chapters);
            //设置chapters的值
            chap.setLong(book, 12);
            out.format(fmt, "after", "chapters", chap.getLong(book));
            //拿到数组characters的值
            Field chars = c.getDeclaredField("characters");
            out.format(fmt, "before", "characters",
                    Arrays.asList(book.characters));
            //设置数组的值
            String[] newChars = { "Queen", "King" };
            chars.set(book, newChars);
            out.format(fmt, "after", "characters",
                    Arrays.asList(book.characters));
            //拿到枚举twin的值
            Field t = c.getDeclaredField("twin");
            out.format(fmt, "before", "twin", book.twin);
            //设置枚举twin的值
            t.set(book, Tweedle.DUM);
            out.format(fmt, "after", "twin", t.get(book));

            // production code should handle these exceptions more gracefully
        } catch (NoSuchFieldException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        }
    }
}