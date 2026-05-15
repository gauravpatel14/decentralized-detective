package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import java.util.concurrent.TimeUnit;

/* JADX INFO: renamed from: Od2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0170Od2 extends BroadcastReceiver {
    public RunnableC0184Pd2 a;

    @Override // android.content.BroadcastReceiver
    public final synchronized void onReceive(Context context, Intent intent) {
        RunnableC0184Pd2 runnableC0184Pd2 = this.a;
        if (runnableC0184Pd2 == null) {
            return;
        }
        if (runnableC0184Pd2.c()) {
            RunnableC0184Pd2 runnableC0184Pd22 = this.a;
            runnableC0184Pd22.w.f.schedule(runnableC0184Pd22, 0L, TimeUnit.SECONDS);
            context.unregisterReceiver(this);
            this.a = null;
        }
    }
}
