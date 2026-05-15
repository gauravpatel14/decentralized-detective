package org.chromium.net;

import J.N;
import android.net.ConnectivityManager;
import defpackage.AbstractC1499tM;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class NetworkActiveNotifier implements ConnectivityManager.OnNetworkActiveListener {
    public final ConnectivityManager a = (ConnectivityManager) AbstractC1499tM.a.getSystemService("connectivity");
    public final long b;
    public boolean c;

    public NetworkActiveNotifier(long j) {
        this.b = j;
    }

    public static NetworkActiveNotifier build(long j) {
        return new NetworkActiveNotifier(j);
    }

    public void disableNotifications() {
        this.c = false;
        this.a.removeDefaultNetworkActiveListener(this);
    }

    public void enableNotifications() {
        this.c = true;
        this.a.addDefaultNetworkActiveListener(this);
    }

    public void fakeDefaultNetworkActive() {
        if (this.c) {
            onNetworkActive();
        }
    }

    public boolean isDefaultNetworkActive() {
        return this.a.isDefaultNetworkActive();
    }

    @Override // android.net.ConnectivityManager.OnNetworkActiveListener
    public final void onNetworkActive() {
        N._V_J(206, this.b);
    }
}
