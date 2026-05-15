package defpackage;

import android.net.TrafficStats;
import java.lang.reflect.Method;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class b92 {
    public static final Method a;
    public static final Method b;

    static {
        try {
            a = TrafficStats.class.getMethod("setThreadStatsUid", Integer.TYPE);
            b = TrafficStats.class.getMethod("clearThreadStatsUid", null);
        } catch (NoSuchMethodException | SecurityException e) {
            throw new RuntimeException("Unable to get TrafficStats methods", e);
        }
    }
}
