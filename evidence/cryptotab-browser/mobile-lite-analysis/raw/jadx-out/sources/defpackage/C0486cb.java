package defpackage;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;

/* JADX INFO: renamed from: cb, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0486cb extends BroadcastReceiver {
    public final /* synthetic */ C0425bb a;

    public C0486cb(C0425bb c0425bb) {
        this.a = c0425bb;
    }

    @Override // android.content.BroadcastReceiver
    public final void onReceive(Context context, Intent intent) {
        C0425bb c0425bb = this.a;
        switch (c0425bb.c) {
            case 0:
                c0425bb.d.o(true, true);
                break;
            default:
                c0425bb.d.o(true, true);
                break;
        }
    }
}
