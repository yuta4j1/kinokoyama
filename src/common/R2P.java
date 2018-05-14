package common;

import java.lang.reflect.Field;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;

/**
 * リクエストパラメータからPOJOへのデータバインディング処理を行うクラス
 */
public class R2P {

     /**
     * リクエストパラメータからPOJOへのデータバインドを行う。
     *
     * @param request リクエストパラメータ
     * @param modelName POJOクラス名
     * @return POJOインスタンス
     */
    public static Object request2Pojo(HttpServletRequest request, Class<?> clazz) {

        try{
            Field[] fields = clazz.getDeclaredFields();
            Object instance = clazz.newInstance();

            for(Field field : fields) {
                String data = request.getParameter(field.getName());
                if(data != null) {
                  try {
                      Method setter = clazz.getMethod(createSetterName(field.getName()), field.getType());
                      setter.invoke(instance, data);
                  } catch (NoSuchMethodException | SecurityException e) {
                      throw new RuntimeException(e);
                  } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
                      throw new RuntimeException(e);
                  }

              }
            }
//            Arrays.stream(fields).forEach(field -> {
//            	String data = request.getParameter(field.getName());
//                if(data != null) {
//                    try {
//                        Method setter = clazz.getMethod(createSetterName(data));
//                        setter.invoke(data);
//                    } catch (NoSuchMethodException | SecurityException e) {
//                        throw new RuntimeException(e);
//                    } catch (IllegalAccessException | IllegalArgumentException | InvocationTargetException e) {
//                        throw new RuntimeException(e);
//                    }
//
//                }
//            });

            return instance;

        }catch(IllegalAccessException | InstantiationException e) {
            throw new RuntimeException(e);
        }
    }

    /**
     * フィールド名からセッターメソッド名を生成する。
     *
     * @param fieldName フィールド名
     * @return セッターメソッド名
     */
    public static String createSetterName(String fieldName) {
        StringBuilder sb = new StringBuilder(fieldName);
        Character iniChar = sb.charAt(0);
        sb.replace(0, 1, iniChar.toString().toUpperCase());
        sb.insert(0, "set");
        return sb.toString();
    }

}
