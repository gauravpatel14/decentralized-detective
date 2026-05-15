package defpackage;

import com.android.volley.VolleyError;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class I80 implements Runnable {
    public final AbstractC1701wu1 t;
    public final ov1 u;
    public final RunnableC1115mw v;

    public I80(AbstractC1701wu1 abstractC1701wu1, ov1 ov1Var, RunnableC1115mw runnableC1115mw) {
        this.t = abstractC1701wu1;
        this.u = ov1Var;
        this.v = runnableC1115mw;
    }

    @Override // java.lang.Runnable
    public final void run() {
        mv1 mv1Var;
        if (this.t.i()) {
            this.t.c();
            return;
        }
        ov1 ov1Var = this.u;
        VolleyError volleyError = ov1Var.c;
        if (volleyError == null) {
            this.t.b(ov1Var.a);
        } else {
            AbstractC1701wu1 abstractC1701wu1 = this.t;
            synchronized (abstractC1701wu1.w) {
                mv1Var = abstractC1701wu1.x;
            }
            if (mv1Var != null) {
                mv1Var.c(volleyError);
            }
        }
        if (this.u.d) {
            this.t.getClass();
            int i = AbstractC1528tq2.a;
        } else {
            this.t.c();
        }
        RunnableC1115mw runnableC1115mw = this.v;
        if (runnableC1115mw != null) {
            runnableC1115mw.run();
        }
    }
}
