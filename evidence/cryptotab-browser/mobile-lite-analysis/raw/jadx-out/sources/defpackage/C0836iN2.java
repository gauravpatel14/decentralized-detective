package defpackage;

import android.content.Context;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: renamed from: iN2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0836iN2 {
    public static C0836iN2 e;
    public final Context a;
    public final ScheduledExecutorService b;
    public MO2 c = new MO2(this);
    public int d = 1;

    public C0836iN2(Context context, ScheduledExecutorService scheduledExecutorService) {
        this.b = scheduledExecutorService;
        this.a = context.getApplicationContext();
    }

    public static synchronized C0836iN2 a(Context context) {
        try {
            if (e == null) {
                e = new C0836iN2(context, Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient"))));
            }
        } catch (Throwable th) {
            throw th;
        }
        return e;
    }

    public final synchronized C0939k33 b(AbstractC0999l13 abstractC0999l13) {
        try {
            if (!this.c.b(abstractC0999l13)) {
                MO2 mo2 = new MO2(this);
                this.c = mo2;
                mo2.b(abstractC0999l13);
            }
        } catch (Throwable th) {
            throw th;
        }
        return abstractC0999l13.b.a;
    }
}
