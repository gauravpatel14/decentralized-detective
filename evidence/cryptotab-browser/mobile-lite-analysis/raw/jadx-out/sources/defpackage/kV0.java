package defpackage;

import android.os.Build;
import android.view.MotionEvent;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import org.chromium.base.TraceEvent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class kV0 {
    public static Method a;
    public static boolean b;
    public static boolean c;
    public static Method d;

    public static long a(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT >= 34) {
            return motionEvent.getEventTimeNanos();
        }
        if (b) {
            return motionEvent.getEventTime() * 1000000;
        }
        try {
            if (a == null) {
                a = MotionEvent.class.getMethod("getEventTimeNano", null);
            }
            return ((Long) a.invoke(motionEvent, null)).longValue();
        } catch (IllegalAccessException e) {
            e = e;
            TraceEvent.e("MotionEventUtils::getEventTimeNano error", e.toString());
            b = true;
            return motionEvent.getEventTime() * 1000000;
        } catch (NoSuchMethodException e2) {
            e = e2;
            TraceEvent.e("MotionEventUtils::getEventTimeNano error", e.toString());
            b = true;
            return motionEvent.getEventTime() * 1000000;
        } catch (InvocationTargetException e3) {
            e = e3;
            TraceEvent.e("MotionEventUtils::getEventTimeNano error", e.toString());
            b = true;
            return motionEvent.getEventTime() * 1000000;
        }
    }

    public static long b(MotionEvent motionEvent) {
        if (Build.VERSION.SDK_INT >= 34) {
            return motionEvent.getHistoricalEventTimeNanos(0);
        }
        if (c) {
            return motionEvent.getHistoricalEventTime(0) * 1000000;
        }
        try {
            if (d == null) {
                Method method = (Method) Class.class.getDeclaredMethod("getDeclaredMethod", String.class, Class[].class).invoke(motionEvent.getClass(), "getHistoricalEventTimeNano", new Class[]{Integer.TYPE});
                method.setAccessible(true);
                d = method;
            }
            return ((Long) d.invoke(motionEvent, 0)).longValue();
        } catch (Exception e) {
            TraceEvent.e("MotionEventUtils::getHistoricalEventTimeNanos error", e.toString());
            c = true;
            return motionEvent.getHistoricalEventTime(0) * 1000000;
        }
    }
}
