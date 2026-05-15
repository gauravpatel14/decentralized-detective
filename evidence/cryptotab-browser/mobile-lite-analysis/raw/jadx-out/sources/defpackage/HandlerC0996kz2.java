package defpackage;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import com.google.android.gms.common.api.internal.zabi;

/* JADX INFO: renamed from: kz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC0996kz2 extends GA2 {
    public final /* synthetic */ zabi a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC0996kz2(zabi zabiVar, Looper looper) {
        super(looper);
        this.a = zabiVar;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        int i = message.what;
        if (i != 1) {
            if (i == 2) {
                throw ((RuntimeException) message.obj);
            }
            Log.w("GACStateManager", "Unknown message id: " + i);
            return;
        }
        AbstractC0933jz2 abstractC0933jz2 = (AbstractC0933jz2) message.obj;
        abstractC0933jz2.getClass();
        zabi zabiVar = this.a;
        zabiVar.zai.lock();
        try {
            if (zabiVar.zan == abstractC0933jz2.a) {
                abstractC0933jz2.a();
            }
        } finally {
            zabiVar.zai.unlock();
        }
    }
}
