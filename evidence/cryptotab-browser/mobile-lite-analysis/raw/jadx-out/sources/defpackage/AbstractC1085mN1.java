package defpackage;

import android.content.Context;

/* JADX INFO: renamed from: mN1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1085mN1 {
    public static InterfaceC1023lN1 a(Context context) {
        C0637fN2 c0637fN2;
        synchronized (B23.class) {
            try {
                if (B23.a == null) {
                    Context applicationContext = context.getApplicationContext();
                    if (applicationContext != null) {
                        context = applicationContext;
                    }
                    B23.a = new C0637fN2(new C1715xC2(context));
                }
                c0637fN2 = B23.a;
            } catch (Throwable th) {
                throw th;
            }
        }
        return (InterfaceC1023lN1) c0637fN2.a.zza();
    }
}
