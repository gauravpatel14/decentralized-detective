package defpackage;

import com.google.android.play.core.splitinstall.internal.zzbl;
import java.lang.reflect.Array;
import java.lang.reflect.Field;
import java.lang.reflect.Method;
import java.util.Arrays;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class TG2 {
    public static LG2 a(Object obj, String str, Class cls) {
        return new LG2(obj, c(obj, str), Array.newInstance((Class<?>) cls, 0).getClass());
    }

    public static Object b(Object obj, String str, Class cls, Class cls2, Object obj2) {
        try {
            return cls.cast(d(obj.getClass(), str, cls2).invoke(obj, obj2));
        } catch (Exception e) {
            throw new zzbl("Failed to invoke method " + str + " on an object of type " + obj.getClass(), e);
        }
    }

    public static Field c(Object obj, String str) {
        for (Class<?> superclass = obj.getClass(); superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Field declaredField = superclass.getDeclaredField(str);
                if (!declaredField.isAccessible()) {
                    declaredField.setAccessible(true);
                }
                return declaredField;
            } catch (NoSuchFieldException unused) {
            }
        }
        throw new zzbl("Failed to find a field named " + str + " on an object of instance " + obj.getClass().getName());
    }

    public static Method d(Class cls, String str, Class... clsArr) {
        for (Class superclass = cls; superclass != null; superclass = superclass.getSuperclass()) {
            try {
                Method declaredMethod = superclass.getDeclaredMethod(str, clsArr);
                if (!declaredMethod.isAccessible()) {
                    declaredMethod.setAccessible(true);
                }
                return declaredMethod;
            } catch (NoSuchMethodException unused) {
            }
        }
        throw new zzbl(String.format("Could not find a method named %s with parameters %s in type %s", str, Arrays.asList(clsArr), cls));
    }
}
