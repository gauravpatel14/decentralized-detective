package defpackage;

import java.util.List;

/* JADX INFO: renamed from: pR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1274pR2 extends AbstractC1852zW2 {
    private static final C1274pR2 zza;
    private int zze;
    private int zzf;
    private JW2 zzg = C0847iX2.w;

    static {
        C1274pR2 c1274pR2 = new C1274pR2();
        zza = c1274pR2;
        AbstractC1852zW2.j(C1274pR2.class, c1274pR2);
    }

    public static nR2 o() {
        return (nR2) zza.d();
    }

    public static /* synthetic */ void p(C1274pR2 c1274pR2, int i) {
        c1274pR2.zze |= 1;
        c1274pR2.zzf = i;
    }

    /* JADX WARN: Multi-variable type inference failed */
    public static void q(C1274pR2 c1274pR2, List list) {
        JW2 jw2 = c1274pR2.zzg;
        if (!((EU2) jw2).t) {
            c1274pR2.zzg = AbstractC1852zW2.g(jw2);
        }
        CU2.a(list, c1274pR2.zzg);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001င\u0000\u0002\u0014", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new C1274pR2();
        }
        if (i2 == 4) {
            return new nR2(zza);
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
        return this.zzf;
    }

    public final long n(int i) {
        C0847iX2 c0847iX2 = (C0847iX2) this.zzg;
        c0847iX2.h(i);
        return c0847iX2.u[i];
    }

    public final boolean r() {
        return (this.zze & 1) != 0;
    }
}
