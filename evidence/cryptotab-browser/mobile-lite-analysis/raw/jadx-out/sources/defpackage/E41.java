package defpackage;

import android.window.BackEvent;
import android.window.OnBackAnimationCallback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class E41 implements OnBackAnimationCallback {
    public final /* synthetic */ A41 a;
    public final /* synthetic */ A41 b;
    public final /* synthetic */ B41 c;
    public final /* synthetic */ B41 d;

    public E41(A41 a41, A41 a412, B41 b41, B41 b412) {
        this.a = a41;
        this.b = a412;
        this.c = b41;
        this.d = b412;
    }

    public final void onBackCancelled() {
        this.d.c();
    }

    public final void onBackInvoked() {
        this.c.c();
    }

    public final void onBackProgressed(BackEvent backEvent) {
        this.b.j(new C0375am(backEvent));
    }

    public final void onBackStarted(BackEvent backEvent) {
        this.a.j(new C0375am(backEvent));
    }
}
