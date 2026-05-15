package defpackage;

import android.os.Handler;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class J80 {
    public final H80 a;

    public J80(Handler handler) {
        this.a = new H80(handler);
    }

    public final void a(AbstractC1701wu1 abstractC1701wu1, ov1 ov1Var, RunnableC1115mw runnableC1115mw) {
        synchronized (abstractC1701wu1.w) {
            abstractC1701wu1.C = true;
        }
        int i = AbstractC1528tq2.a;
        this.a.execute(new I80(abstractC1701wu1, ov1Var, runnableC1115mw));
    }
}
