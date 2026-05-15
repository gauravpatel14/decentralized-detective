package defpackage;

import android.content.Context;
import com.google.android.gms.common.util.concurrent.NamedThreadFactory;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Q13 {
    public final Context a;
    public final ScheduledExecutorService b;
    public ServiceConnectionC1305q23 c;
    public int d;

    public Q13(Context context) {
        ScheduledExecutorService scheduledExecutorServiceUnconfigurableScheduledExecutorService = Executors.unconfigurableScheduledExecutorService(Executors.newScheduledThreadPool(1, new NamedThreadFactory("MessengerIpcClient")));
        this.c = new ServiceConnectionC1305q23(this);
        this.d = 1;
        this.a = context.getApplicationContext();
        this.b = scheduledExecutorServiceUnconfigurableScheduledExecutorService;
    }
}
