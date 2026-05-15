package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Looper;
import org.chromium.net.ProxyChangeListener;

/* JADX INFO: renamed from: ln1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1048ln1 extends BroadcastReceiver {
    public final ProxyChangeListener a;

    public C1048ln1(ProxyChangeListener proxyChangeListener) {
        this.a = proxyChangeListener;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.PROXY_CHANGE")) {
            ProxyChangeListener proxyChangeListener = this.a;
            proxyChangeListener.getClass();
            RunnableC1109mn1 runnableC1109mn1 = new RunnableC1109mn1(proxyChangeListener, intent, 0);
            if (proxyChangeListener.a == Looper.myLooper()) {
                runnableC1109mn1.run();
            } else {
                proxyChangeListener.b.post(runnableC1109mn1);
            }
        }
    }
}
