package defpackage;

import android.os.Handler;
import android.os.Looper;
import android.os.Message;

/* JADX INFO: renamed from: tP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class HandlerC1504tP0 extends Handler {
    public final /* synthetic */ AbstractC1615vP0 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public HandlerC1504tP0(AbstractC1615vP0 abstractC1615vP0, Looper looper) {
        super(looper);
        this.a = abstractC1615vP0;
    }

    @Override // android.os.Handler
    public final void handleMessage(Message message) {
        wP0 wp0;
        AbstractC1615vP0 abstractC1615vP0;
        HandlerC1504tP0 handlerC1504tP0;
        if (message.what == 1) {
            synchronized (this.a.a) {
                wp0 = (wP0) this.a.d.get();
                abstractC1615vP0 = this.a;
                handlerC1504tP0 = abstractC1615vP0.e;
            }
            if (wp0 == null || abstractC1615vP0 != wp0.b() || handlerC1504tP0 == null) {
                return;
            }
            wp0.f((IP0) message.obj);
            this.a.a(wp0, handlerC1504tP0);
            wp0.f(null);
        }
    }
}
