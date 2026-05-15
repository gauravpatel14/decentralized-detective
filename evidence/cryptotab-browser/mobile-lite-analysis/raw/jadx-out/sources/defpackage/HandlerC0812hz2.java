package defpackage;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.zabe;

/* JADX INFO: renamed from: hz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC0812hz2 extends GA2 {
    public final /* synthetic */ zabe a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0812hz2(zabe zabeVar, Looper looper) {
        super(looper);
        this.a = zabeVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        zabe zabeVar = this.a;
        if (i == 1) {
            zabe.zaj(zabeVar);
        } else {
            if (i == 2) {
                zabe.zai(zabeVar);
                return;
            }
            Log.w("GoogleApiClientImpl", "Unknown message id: " + i);
        }
    }
}
