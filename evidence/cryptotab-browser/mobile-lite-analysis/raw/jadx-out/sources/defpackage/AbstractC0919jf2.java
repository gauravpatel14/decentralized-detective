package defpackage;

import android.content.res.Resources;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: jf2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0919jf2 {
    public static C0989kn2 a(Resources resources, int i, Resources.Theme theme) {
        TraceEvent traceEventJ = TraceEvent.j("VectorDrawableCompat.create", null);
        try {
            C0989kn2 c0989kn2 = new C0989kn2();
            ThreadLocal threadLocal = kv1.a;
            c0989kn2.t = resources.getDrawable(i, theme);
            if (traceEventJ != null) {
                traceEventJ.close();
            }
            return c0989kn2;
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }
}
