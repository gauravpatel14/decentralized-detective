package defpackage;

import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: renamed from: fa0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0656fa0 {
    public final CoreImpl a;
    public final KS0 b;
    public final long c;

    public C0656fa0(CoreImpl coreImpl, KS0 ks0, long j) {
        this.a = coreImpl;
        this.b = ks0;
        this.c = j;
    }

    public final void a(C0364aa0[] c0364aa0Arr) {
        da0 da0Var = new da0(0);
        da0Var.b = c0364aa0Arr;
        this.b.g(da0Var.c(this.a, new wS0(0, 2, this.c)));
    }
}
