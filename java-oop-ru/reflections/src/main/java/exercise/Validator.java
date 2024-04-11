package exercise;

import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.ArrayList;
import java.util.List;

// BEGIN
public class Validator {
    public static List validate(Address address) {
        var resultList = new ArrayList<>();
        for (Field field : address.getClass().getDeclaredFields()) {
            field.setAccessible(true);
            if (field.isAnnotationPresent(NotNull.class)) {
                try {
                    field.setAccessible(true);
                    if (field.get(address) == null) {
                        resultList.add(field.getName());
                    }
                } catch (IllegalAccessException e) {
                    throw new RuntimeException();
                }
            }
        }
        return resultList;
    }
}
// END
