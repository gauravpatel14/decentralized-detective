package defpackage;

import java.util.Calendar;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.TimeoutException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Sw {
    public static final Rw a;
    public static Calendar b;

    static {
        Rw rw = new Rw();
        rw.e(5);
        a = rw;
    }

    public static Calendar a() {
        if (b == null) {
            try {
                b = (Calendar) a.h(1L, TimeUnit.MILLISECONDS);
            } catch (InterruptedException | ExecutionException | TimeoutException unused) {
                b = Calendar.getInstance();
            }
        }
        Calendar calendar = (Calendar) b.clone();
        calendar.clear();
        return calendar;
    }

    public static void b() {
    }
}
