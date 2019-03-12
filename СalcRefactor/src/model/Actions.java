package model;

import java.util.HashMap;

public class Actions {
    public static HashMap<Integer, Calc<Object>> actions = new HashMap<>();

    static {
        actions.put(0, new Calc<>() {
            @Override
            public Object add(Object a, Object b) {
                if (a instanceof Integer || b instanceof Integer) {
                    return (Integer) a + (Integer) b;
                } else if (a instanceof String || b instanceof String) {
                    return (String) a + b;
                }
                throw new IllegalArgumentException("Wrong types");
            }

            @Override
            public Object subtract(Object a, Object b) {
                if (a instanceof Integer || b instanceof Integer) {
                    return (Integer) a - (Integer) b;
                }
                throw new IllegalArgumentException("Wrong types");
            }

            @Override
            public Object multiply(Object a, Object b) {
                if (a instanceof Integer || b instanceof Integer) {
                    return (Integer) a * (Integer) b;
                }
                throw new IllegalArgumentException("Wrong types");
            }

            @Override
            public Object divide(Object a, Object b) {
                if (a instanceof Integer || b instanceof Integer) {
                    return (Integer) a / (Integer) b;
                }
                throw new IllegalArgumentException("Wrong types");
            }
        });
    }

}
