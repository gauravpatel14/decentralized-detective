package defpackage;

import androidx.fragment.app.n;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Jh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0112Jh0 extends AbstractC0128Lh0 {
    public final /* synthetic */ Gk0 a;
    public final /* synthetic */ AtomicReference b;
    public final /* synthetic */ AbstractC1065m4 c;
    public final /* synthetic */ k4 d;
    public final /* synthetic */ n e;

    public C0112Jh0(n nVar, Gk0 gk0, AtomicReference atomicReference, AbstractC1065m4 abstractC1065m4, k4 k4Var) {
        this.e = nVar;
        this.a = gk0;
        this.b = atomicReference;
        this.c = abstractC1065m4;
        this.d = k4Var;
    }

    @Override // defpackage.AbstractC0128Lh0
    public final void a() {
        n nVar = this.e;
        this.b.set(this.a.apply().d(nVar.generateActivityResultKey(), nVar, this.c, this.d));
    }
}
