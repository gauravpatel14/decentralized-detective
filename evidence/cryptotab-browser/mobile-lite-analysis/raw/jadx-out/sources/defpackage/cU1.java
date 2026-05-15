package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import com.google.firebase.iid.FirebaseInstanceId;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class cU1 extends BroadcastReceiver {
    public dU1 a;

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        dU1 du1 = this.a;
        if (du1 == null) {
            return;
        }
        ConnectivityManager connectivityManager = (ConnectivityManager) du1.a().getSystemService("connectivity");
        NetworkInfo activeNetworkInfo = connectivityManager != null ? connectivityManager.getActiveNetworkInfo() : null;
        if (activeNetworkInfo == null || !activeNetworkInfo.isConnected()) {
            return;
        }
        GP1 gp1 = FirebaseInstanceId.i;
        dU1 du12 = this.a;
        du12.v.getClass();
        FirebaseInstanceId.d(du12, 0L);
        this.a.a().unregisterReceiver(this);
        this.a = null;
    }
}
