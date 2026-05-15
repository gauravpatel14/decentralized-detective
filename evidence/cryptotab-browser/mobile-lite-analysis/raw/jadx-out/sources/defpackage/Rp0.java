package defpackage;

import android.accounts.AccountManagerCallback;
import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Rp0 extends BroadcastReceiver {
    public final /* synthetic */ Context a;
    public final /* synthetic */ Qp0 b;

    public Rp0(Qp0 qp0, Context context) {
        this.b = qp0;
        this.a = context;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        this.a.unregisterReceiver(this);
        Qp0 qp0 = this.b;
        Sp0 sp0 = qp0.b;
        sp0.b.getAuthToken(sp0.e, sp0.d, sp0.c, true, (AccountManagerCallback<Bundle>) new Qp0(qp0.c, sp0, 1), (Handler) null);
    }
}
