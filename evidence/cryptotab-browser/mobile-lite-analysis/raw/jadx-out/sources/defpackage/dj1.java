package defpackage;

import J.N;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import org.chromium.base.PowerMonitor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class dj1 extends BroadcastReceiver {
    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        PowerMonitor.b = intent.getAction().equals("android.intent.action.ACTION_POWER_DISCONNECTED") ? 1 : 2;
        N._V(2);
    }
}
