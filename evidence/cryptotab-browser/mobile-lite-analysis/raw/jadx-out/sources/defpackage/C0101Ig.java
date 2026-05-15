package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: Ig, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0101Ig extends BroadcastReceiver {
    public final /* synthetic */ Jg a;

    public C0101Ig(Jg jg) {
        this.a = jg;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        int intExtra = intent.getIntExtra("android.media.extra.SCO_AUDIO_STATE", 0);
        Jg jg = this.a;
        if (intExtra != 0) {
            if (intExtra != 1) {
                return;
            }
            jg.d = 1;
        } else {
            if (jg.d != 3) {
                jg.e();
            }
            jg.d = 0;
        }
    }
}
