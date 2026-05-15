package defpackage;

import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class z80 {
    public static void a(Throwable th, Throwable th2) throws IllegalAccessException, InvocationTargetException {
        Integer num;
        Method method;
        if (th == th2 || (num = AbstractC1365rA0.a) == null || num.intValue() >= 19 || (method = Wg1.a) == null) {
            return;
        }
        method.invoke(th, th2);
    }
}
