package defpackage;

import android.os.Bundle;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.measurement.internal.zzlo;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CB2 extends AbstractC1834zK2 {
    public final C1391rR2 a;
    public final IU2 b;

    public CB2(C1391rR2 c1391rR2) {
        Preconditions.checkNotNull(c1391rR2);
        this.a = c1391rR2;
        IU2 iu2 = c1391rR2.p;
        C1391rR2.j(iu2);
        this.b = iu2;
    }

    @Override // defpackage.KU2
    public final void a(String str) {
        C1391rR2 c1391rR2 = this.a;
        c1391rR2.m().h(c1391rR2.n.elapsedRealtime(), str);
    }

    @Override // defpackage.KU2
    public final String b() {
        return this.b.A();
    }

    @Override // defpackage.KU2
    public final void c(String str, String str2, Bundle bundle) {
        IU2 iu2 = this.a.p;
        C1391rR2.j(iu2);
        iu2.k(str, str2, bundle);
    }

    @Override // defpackage.KU2
    public final List d(String str, String str2) {
        IU2 iu2 = this.b;
        C1391rR2 c1391rR2 = iu2.a;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        boolean zQ = c0899jR2.q();
        WO2 wo2 = c1391rR2.i;
        if (zQ) {
            C1391rR2.k(wo2);
            wo2.f.a("Cannot get conditional user properties from analytics worker thread");
            return new ArrayList(0);
        }
        if (C1070mC2.a()) {
            C1391rR2.k(wo2);
            wo2.f.a("Cannot get conditional user properties from main thread");
            return new ArrayList(0);
        }
        AtomicReference atomicReference = new AtomicReference();
        C0899jR2 c0899jR22 = c1391rR2.j;
        C1391rR2.k(c0899jR22);
        c0899jR22.l(atomicReference, 5000L, "get conditional user properties", new RunnableC0844iU2(iu2, atomicReference, str, str2));
        List list = (List) atomicReference.get();
        if (list != null) {
            return C0653fY2.p(list);
        }
        C1391rR2.k(wo2);
        wo2.f.b(null, "Timed out waiting for get conditional user properties");
        return new ArrayList();
    }

    @Override // defpackage.KU2
    public final Map e(String str, String str2, boolean z) {
        IU2 iu2 = this.b;
        C1391rR2 c1391rR2 = iu2.a;
        C0899jR2 c0899jR2 = c1391rR2.j;
        C1391rR2.k(c0899jR2);
        boolean zQ = c0899jR2.q();
        WO2 wo2 = c1391rR2.i;
        if (zQ) {
            C1391rR2.k(wo2);
            wo2.f.a("Cannot get user properties from analytics worker thread");
            return Collections.emptyMap();
        }
        if (C1070mC2.a()) {
            C1391rR2.k(wo2);
            wo2.f.a("Cannot get user properties from main thread");
            return Collections.emptyMap();
        }
        AtomicReference atomicReference = new AtomicReference();
        C0899jR2 c0899jR22 = c1391rR2.j;
        C1391rR2.k(c0899jR22);
        c0899jR22.l(atomicReference, 5000L, "get user properties", new RunnableC1030lU2(iu2, atomicReference, str, str2, z));
        List<zzlo> list = (List) atomicReference.get();
        if (list == null) {
            C1391rR2.k(wo2);
            wo2.f.b(Boolean.valueOf(z), "Timed out waiting for handle get user properties, includeInternal");
            return Collections.emptyMap();
        }
        gf gfVar = new gf(list.size());
        for (zzlo zzloVar : list) {
            Object objF2 = zzloVar.f2();
            if (objF2 != null) {
                gfVar.put(zzloVar.u, objF2);
            }
        }
        return gfVar;
    }

    @Override // defpackage.KU2
    public final void f(String str) {
        C1391rR2 c1391rR2 = this.a;
        c1391rR2.m().i(c1391rR2.n.elapsedRealtime(), str);
    }

    @Override // defpackage.KU2
    public final int g(String str) {
        IU2 iu2 = this.b;
        iu2.getClass();
        Preconditions.checkNotEmpty(str);
        iu2.a.getClass();
        return 25;
    }

    @Override // defpackage.KU2
    public final String h() {
        C1791yV2 c1791yV2 = this.b.a.o;
        C1391rR2.j(c1791yV2);
        TU2 tu2 = c1791yV2.c;
        if (tu2 != null) {
            return tu2.a;
        }
        return null;
    }

    @Override // defpackage.KU2
    public final void i(Bundle bundle) {
        IU2 iu2 = this.b;
        iu2.r(bundle, iu2.a.n.currentTimeMillis());
    }

    @Override // defpackage.KU2
    public final void j(String str, String str2, Bundle bundle) {
        IU2 iu2 = this.b;
        iu2.m(str, str2, bundle, true, true, iu2.a.n.currentTimeMillis());
    }

    @Override // defpackage.KU2
    public final String k() {
        return this.b.A();
    }

    @Override // defpackage.KU2
    public final long zzb() {
        C0653fY2 c0653fY2 = this.a.l;
        C1391rR2.i(c0653fY2);
        return c0653fY2.f0();
    }

    @Override // defpackage.KU2
    public final String zzi() {
        C1791yV2 c1791yV2 = this.b.a.o;
        C1391rR2.j(c1791yV2);
        TU2 tu2 = c1791yV2.c;
        if (tu2 != null) {
            return tu2.b;
        }
        return null;
    }
}
