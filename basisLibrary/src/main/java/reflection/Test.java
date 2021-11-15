package reflection;

import java.beans.IntrospectionException;
import java.beans.PropertyDescriptor;
import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/**
 * @author huangtengfei
 * @description
 * @time 2021/6/17 9:54
 */
public class Test {
    public static void main(String[] args) {
        Person person =new Person("213",1);
        Class<? extends Person> aClass = person.getClass();
        // 获得属性
        Field[] declaredFields = aClass.getDeclaredFields();
        for (Field declaredField : declaredFields) {
            try {
                // 获取get方法
                PropertyDescriptor propertyDescriptor = new PropertyDescriptor(declaredField.getName(), aClass);
                Method readMethod = propertyDescriptor.getReadMethod();
                // 执行get方法
                Object invoke = readMethod.invoke(person);
                System.out.println(invoke);
            } catch (IntrospectionException | IllegalAccessException | InvocationTargetException e) {
                e.printStackTrace();
            }
        }
    }
}
