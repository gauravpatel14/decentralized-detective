package defpackage;

import android.os.Handler;
import android.view.ViewGroup;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Qf {
    public Mf a;
    public Handler b;
    public Of c;

    public final void a(int i, ViewGroup viewGroup, Pf pf) {
        Mf mf = this.a;
        if (pf == null) {
            throw new NullPointerException("callback argument may not be null!");
        }
        Of of = this.c;
        Nf nf = (Nf) of.u.a();
        if (nf == null) {
            nf = new Nf();
        }
        nf.a = mf;
        nf.b = this.b;
        nf.d = i;
        nf.c = viewGroup;
        nf.f = pf;
        try {
            of.t.put(nf);
        } catch (InterruptedException e) {
            throw new RuntimeException("Failed to enqueue async inflate request", e);
        }
    }
}
