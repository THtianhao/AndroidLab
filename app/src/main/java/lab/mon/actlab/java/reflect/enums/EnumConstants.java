package lab.mon.actlab.java.reflect.enums;

import java.util.Arrays;
import static java.lang.System.out;

enum Eon { HADEAN, ARCHAEAN, PROTEROZOIC, PHANEROZOIC }

public class EnumConstants {
    public static void main(String... args) {
        try {
            Class<?> c = (args.length == 0 ? Eon.class : Class.forName(args[0]));
            out.format("Enum name:  %s%nEnum constants:  %s%n", c.getName(), Arrays.asList(c.getEnumConstants()));
            if (c == Eon.class)
                out.format("  Eon.values():  %s%n", Arrays.asList(Eon.values()));

        } catch (ClassNotFoundException x) {
            x.printStackTrace();
        }
    }
}