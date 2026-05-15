package defpackage;

import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class WE1 {
    public static final /* synthetic */ int a = 0;

    static {
        new AtomicInteger();
        new AtomicInteger();
        new AtomicBoolean();
        try {
            Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class);
            Class.class.getDeclaredMethod("getMethod", String.class, Class[].class);
            Class.class.getDeclaredMethod("getDeclaredField", String.class);
            Class.class.getDeclaredMethod("getField", String.class);
        } catch (Throwable th) {
            throw new RuntimeException(th);
        }
    }
}
