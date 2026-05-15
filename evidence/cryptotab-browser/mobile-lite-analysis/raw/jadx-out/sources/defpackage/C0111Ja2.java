package defpackage;

import android.os.Handler;

/* JADX INFO: renamed from: Ja2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0111Ja2 implements InterfaceC0099Ia2 {
    public final Handler a = new Handler();
    public final RunnableC0089Ha2 b;
    public final /* synthetic */ C0154Na2 c;

    public C0111Ja2(C0154Na2 c0154Na2, RunnableC0089Ha2 runnableC0089Ha2) {
        this.c = c0154Na2;
        this.b = runnableC0089Ha2;
    }

    @Override // defpackage.InterfaceC0099Ia2
    public final void a() {
        Handler handler = this.a;
        RunnableC0089Ha2 runnableC0089Ha2 = this.b;
        handler.removeCallbacks(runnableC0089Ha2);
        runnableC0089Ha2.run();
    }

    @Override // defpackage.InterfaceC0099Ia2
    public final void b(C0064Fa2 c0064Fa2) {
        this.a.postDelayed(this.b, this.c.c.a.getDuration() == 0 ? 2000 : 3500);
    }
}
