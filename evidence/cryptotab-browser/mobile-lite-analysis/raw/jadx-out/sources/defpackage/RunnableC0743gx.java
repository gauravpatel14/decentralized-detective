package defpackage;

import android.graphics.Typeface;

/* JADX INFO: renamed from: gx, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0743gx implements Runnable {
    public final /* synthetic */ C0269Wi2 t;
    public final /* synthetic */ Typeface u;

    public RunnableC0743gx(C0269Wi2 c0269Wi2, Typeface typeface) {
        this.t = c0269Wi2;
        this.u = typeface;
    }

    @Override // java.lang.Runnable
    public final void run() {
        jv1 jv1Var = this.t.a;
        if (jv1Var != null) {
            jv1Var.c(this.u);
        }
    }
}
