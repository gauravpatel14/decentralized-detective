package defpackage;

import org.chromium.mojo.system.impl.CoreImpl;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gn {
    public final CoreImpl a;
    public final KS0 b;
    public final long c;

    public gn(CoreImpl coreImpl, KS0 ks0, long j) {
        this.a = coreImpl;
        this.b = ks0;
        this.c = j;
    }

    public final void a(C0435bn[] c0435bnArr) {
        en enVar = new en(0);
        enVar.b = c0435bnArr;
        this.b.g(enVar.c(this.a, new wS0(0, 2, this.c)));
    }
}
