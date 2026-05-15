package defpackage;

import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TN0 implements fF1 {
    public final /* synthetic */ UN0 a;

    public TN0(UN0 un0) {
        this.a = un0;
    }

    @Override // defpackage.fF1
    public final void a(AbstractC0338aF1 abstractC0338aF1) {
        UN0 un0 = this.a;
        SN0 sn0 = un0.p;
        Nt1 nt1 = un0.c;
        nt1.getClass();
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sn0 != null) {
            nt1.h.remove(sn0);
        }
        un0.d = false;
    }

    @Override // defpackage.fF1
    public final /* synthetic */ void b(AbstractC0338aF1 abstractC0338aF1) {
        Ly ly = (Ly) abstractC0338aF1;
        if (ly.f() != null) {
            this.a.c(ly.f());
        }
    }

    @Override // defpackage.fF1
    public final void c(AbstractC0338aF1 abstractC0338aF1) {
        UN0 un0 = this.a;
        SN0 sn0 = un0.p;
        Nt1 nt1 = un0.c;
        nt1.getClass();
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sn0 != null) {
            nt1.h.remove(sn0);
        }
        un0.d = false;
        un0.a();
    }

    @Override // defpackage.fF1
    public final void d(AbstractC0338aF1 abstractC0338aF1) {
        UN0 un0 = this.a;
        SN0 sn0 = un0.p;
        Nt1 nt1 = un0.c;
        nt1.getClass();
        Preconditions.checkMainThread("Must be called from the main thread.");
        if (sn0 != null) {
            nt1.h.remove(sn0);
        }
        un0.d = false;
        un0.a();
    }

    @Override // defpackage.fF1
    public final /* synthetic */ void i(AbstractC0338aF1 abstractC0338aF1, String str) {
        this.a.c(((Ly) abstractC0338aF1).f());
    }

    @Override // defpackage.fF1
    public final /* bridge */ /* synthetic */ void f(AbstractC0338aF1 abstractC0338aF1) {
    }

    @Override // defpackage.fF1
    public final /* bridge */ /* synthetic */ void h(AbstractC0338aF1 abstractC0338aF1) {
    }

    @Override // defpackage.fF1
    public final /* bridge */ /* synthetic */ void j(AbstractC0338aF1 abstractC0338aF1) {
    }

    @Override // defpackage.fF1
    public final /* bridge */ /* synthetic */ void l(AbstractC0338aF1 abstractC0338aF1) {
    }
}
