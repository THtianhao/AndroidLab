package lab.mon.actlab.java.reflect.construct;


import java.lang.reflect.Constructor;
import java.lang.reflect.InvocationTargetException;
import java.util.HashMap;
import java.util.Map;
import java.util.Set;

import static java.lang.System.out;

class EmailAliases {
    private Set<String> aliases;

    private EmailAliases(HashMap<String, String> h) {
        aliases = h.keySet();
    }

    public void printKeys() {
        out.format("Mail keys:%n");
        for (String k : aliases)
            out.format("  %s%n", k);
    }
}

public class RestoreAliases {

    private static Map<String, String> defaultAliases = new HashMap<String, String>();

    static {
        defaultAliases.put("Duke", "duke@i-love-java");
        defaultAliases.put("Fang", "fang@evil-jealous-twin");
    }

    public void main(String... args) {
        try {
            //获取构造函数
            Constructor ctor = EmailAliases.class.getDeclaredConstructor(HashMap.class);
            //获取构造函数的访问权限
            ctor.setAccessible(true);
            //创建构造函数
            EmailAliases email = (EmailAliases) ctor.newInstance(defaultAliases);
            email.printKeys();
        } catch (InstantiationException x) {
            x.printStackTrace();
        } catch (IllegalAccessException x) {
            x.printStackTrace();
        } catch (InvocationTargetException x) {
            x.printStackTrace();
        } catch (NoSuchMethodException x) {
            x.printStackTrace();
        }
    }
}