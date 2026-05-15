package defpackage;

import java.util.ArrayList;
import java.util.List;

/* JADX INFO: renamed from: kR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0961kR2 extends AbstractC1852zW2 {
    private static final C0961kR2 zza;
    private JW2 zze;
    private JW2 zzf;
    private LW2 zzg;
    private LW2 zzh;

    static {
        C0961kR2 c0961kR2 = new C0961kR2();
        zza = c0961kR2;
        AbstractC1852zW2.j(C0961kR2.class, c0961kR2);
    }

    public C0961kR2() {
        C0847iX2 c0847iX2 = C0847iX2.w;
        this.zze = c0847iX2;
        this.zzf = c0847iX2;
        C0591eY2 c0591eY2 = C0591eY2.w;
        this.zzg = c0591eY2;
        this.zzh = c0591eY2;
    }

    public static void A(C0961kR2 c0961kR2, ArrayList arrayList) {
        LW2 lw2 = c0961kR2.zzg;
        if (!((EU2) lw2).t) {
            c0961kR2.zzg = AbstractC1852zW2.h(lw2);
        }
        CU2.a(arrayList, c0961kR2.zzg);
    }

    public static void B(C0961kR2 c0961kR2) {
        c0961kR2.zzg = C0591eY2.w;
    }

    public static void C(C0961kR2 c0961kR2, int i) {
        LW2 lw2 = c0961kR2.zzg;
        if (!((EU2) lw2).t) {
            c0961kR2.zzg = AbstractC1852zW2.h(lw2);
        }
        c0961kR2.zzg.remove(i);
    }

    public static void D(C0961kR2 c0961kR2, List list) {
        LW2 lw2 = c0961kR2.zzh;
        if (!((EU2) lw2).t) {
            c0961kR2.zzh = AbstractC1852zW2.h(lw2);
        }
        CU2.a(list, c0961kR2.zzh);
    }

    public static void E(C0961kR2 c0961kR2) {
        c0961kR2.zzh = C0591eY2.w;
    }

    public static void F(C0961kR2 c0961kR2, int i) {
        LW2 lw2 = c0961kR2.zzh;
        if (!((EU2) lw2).t) {
            c0961kR2.zzh = AbstractC1852zW2.h(lw2);
        }
        c0961kR2.zzh.remove(i);
    }

    public static C0840iR2 p() {
        return (C0840iR2) zza.d();
    }

    public static C0961kR2 q() {
        return zza;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void w(C0961kR2 c0961kR2, List list) {
        JW2 jw2 = c0961kR2.zze;
        if (!((EU2) jw2).t) {
            c0961kR2.zze = AbstractC1852zW2.g(jw2);
        }
        CU2.a(list, c0961kR2.zze);
    }

    public static void x(C0961kR2 c0961kR2) {
        c0961kR2.zze = C0847iX2.w;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void y(C0961kR2 c0961kR2, List list) {
        JW2 jw2 = c0961kR2.zzf;
        if (!((EU2) jw2).t) {
            c0961kR2.zzf = AbstractC1852zW2.g(jw2);
        }
        CU2.a(list, c0961kR2.zzf);
    }

    public static void z(C0961kR2 c0961kR2) {
        c0961kR2.zzf = C0847iX2.w;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0004\u0000\u0001\u0015\u0002\u0015\u0003\u001b\u0004\u001b", new Object[]{"zze", "zzf", "zzg", XP2.class, "zzh", C1274pR2.class});
        }
        if (i2 == 3) {
            return new C0961kR2();
        }
        if (i2 == 4) {
            return new C0840iR2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzg.size();
    }

    public final int m() {
        return this.zzh.size();
    }

    public final int n() {
        return this.zze.size();
    }

    public final XP2 o(int i) {
        return (XP2) this.zzg.get(i);
    }

    public final C1274pR2 r(int i) {
        return (C1274pR2) this.zzh.get(i);
    }

    public final LW2 s() {
        return this.zzg;
    }

    public final List t() {
        return this.zzf;
    }

    public final LW2 u() {
        return this.zzh;
    }

    public final List v() {
        return this.zze;
    }
}
