package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class G10 extends BroadcastReceiver {
    public final /* synthetic */ J10 a;

    public G10(J10 j10) {
        this.a = j10;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        if (intent.getAction().equals("android.intent.action.MEDIA_REMOVED") || intent.getAction().equals("android.intent.action.MEDIA_MOUNTED") || intent.getAction().equals("android.intent.action.MEDIA_EJECT")) {
            this.a.b = true;
        }
    }
}
