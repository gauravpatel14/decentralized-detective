package defpackage;

import androidx.appcompat.widget.Toolbar;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class bb2 implements Runnable {
    public final /* synthetic */ Toolbar t;

    public bb2(Toolbar toolbar) {
        this.t = toolbar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        this.t.I();
    }
}
