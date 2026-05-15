package defpackage;

import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class jx0 implements Callback {
    public final /* synthetic */ C1056lx0 t;

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        String str = (String) obj;
        C1056lx0 c1056lx0 = this.t;
        c1056lx0.getClass();
        Sj1.b("referrer_pref", str);
        c1056lx0.c = str;
        c1056lx0.b.countDown();
    }
}
