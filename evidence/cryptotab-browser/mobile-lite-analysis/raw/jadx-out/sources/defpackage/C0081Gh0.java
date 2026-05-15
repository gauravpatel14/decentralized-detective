package defpackage;

import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Gh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0081Gh0 extends o4 {
    public final /* synthetic */ AtomicReference a;

    public C0081Gh0(AtomicReference atomicReference) {
        this.a = atomicReference;
    }

    @Override // defpackage.o4
    public final void a(Object obj) {
        o4 o4Var = (o4) this.a.get();
        if (o4Var == null) {
            throw new IllegalStateException("Operation cannot be started before fragment is in created state");
        }
        o4Var.a(obj);
    }
}
