package defpackage;

import android.content.ComponentName;

/* JADX INFO: renamed from: bW2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RunnableC0419bW2 implements Runnable {
    public final /* synthetic */ ComponentName t;
    public final /* synthetic */ AW2 u;

    public RunnableC0419bW2(AW2 aw2, ComponentName componentName) {
        this.u = aw2;
        this.t = componentName;
    }

    @Override // java.lang.Runnable
    public final void run() {
        CW2.u(this.u.v, this.t);
    }
}
