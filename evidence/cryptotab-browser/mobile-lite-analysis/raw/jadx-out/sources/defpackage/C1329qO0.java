package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: qO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1329qO0 extends BroadcastReceiver {
    public final /* synthetic */ DialogC1385rO0 a;

    public C1329qO0(DialogC1385rO0 dialogC1385rO0) {
        this.a = dialogC1385rO0;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if ("android.intent.action.SCREEN_OFF".equals(intent.getAction())) {
            this.a.dismiss();
        }
    }
}
