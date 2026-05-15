package defpackage;

import android.content.Context;

/* JADX INFO: renamed from: Id, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0100Id {
    public static LQ2 a(Context context) {
        R33 r33;
        synchronized (EF2.class) {
            try {
                if (EF2.a == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    EF2.a = new R33(new ST2(context));
                }
                r33 = EF2.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return (LQ2) r33.a.zza();
    }
}
