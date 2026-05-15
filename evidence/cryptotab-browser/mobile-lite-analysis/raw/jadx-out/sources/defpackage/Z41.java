package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Z41 implements Callback {
    public final /* synthetic */ C0331a51 t;

    public Z41(C0331a51 c0331a51) {
        this.t = c0331a51;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        C0331a51 c0331a51 = this.t;
        c0331a51.c.a0(obj);
        ((F21) c0331a51.b.get()).b(c0331a51.a);
    }
}
