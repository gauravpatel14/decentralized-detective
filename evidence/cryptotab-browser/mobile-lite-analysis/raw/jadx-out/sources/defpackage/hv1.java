package defpackage;

import android.graphics.Typeface;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class hv1 implements Runnable {
    public final /* synthetic */ jv1 t;
    public final /* synthetic */ Typeface u;

    public /* synthetic */ hv1(jv1 jv1Var, Typeface typeface) {
        this.t = jv1Var;
        this.u = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.c(this.u);
    }
}
