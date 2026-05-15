package defpackage;

import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class J72 {
    public final CoreImpl a;
    public final KS0 b;
    public final long c;

    public J72(CoreImpl coreImpl, KS0 ks0, long j) {
        this.a = coreImpl;
        this.b = ks0;
        this.c = j;
    }

    public final void a(C72[] c72Arr) {
        H72 h72 = new H72(0);
        h72.b = c72Arr;
        this.b.g(h72.c(this.a, new wS0(0, 2, this.c)));
    }
}
