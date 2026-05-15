package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: nQ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1149nQ2 extends AbstractC1852zW2 {
    private static final C1149nQ2 zza;
    private int zze;
    private long zzh;
    private float zzi;
    private double zzj;
    private String zzf = "";
    private String zzg = "";
    private LW2 zzk = C0591eY2.w;

    static {
        C1149nQ2 c1149nQ2 = new C1149nQ2();
        zza = c1149nQ2;
        AbstractC1852zW2.j(C1149nQ2.class, c1149nQ2);
    }

    public static void A(C1149nQ2 c1149nQ2, C1149nQ2 c1149nQ22) {
        LW2 lw2 = c1149nQ2.zzk;
        if (!((EU2) lw2).t) {
            c1149nQ2.zzk = AbstractC1852zW2.h(lw2);
        }
        c1149nQ2.zzk.add(c1149nQ22);
    }

    public static void B(C1149nQ2 c1149nQ2, ArrayList arrayList) {
        LW2 lw2 = c1149nQ2.zzk;
        if (!((EU2) lw2).t) {
            c1149nQ2.zzk = AbstractC1852zW2.h(lw2);
        }
        CU2.a(arrayList, c1149nQ2.zzk);
    }

    public static void C(C1149nQ2 c1149nQ2) {
        c1149nQ2.zzk = C0591eY2.w;
    }

    public static C0960kQ2 p() {
        return (C0960kQ2) zza.d();
    }

    public static /* synthetic */ void t(C1149nQ2 c1149nQ2, String str) {
        str.getClass();
        c1149nQ2.zze |= 1;
        c1149nQ2.zzf = str;
    }

    public static /* synthetic */ void u(C1149nQ2 c1149nQ2, String str) {
        str.getClass();
        c1149nQ2.zze |= 2;
        c1149nQ2.zzg = str;
    }

    public static /* synthetic */ void v(C1149nQ2 c1149nQ2) {
        c1149nQ2.zze &= -3;
        c1149nQ2.zzg = zza.zzg;
    }

    public static /* synthetic */ void w(C1149nQ2 c1149nQ2, long j) {
        c1149nQ2.zze |= 4;
        c1149nQ2.zzh = j;
    }

    public static /* synthetic */ void x(C1149nQ2 c1149nQ2) {
        c1149nQ2.zze &= -5;
        c1149nQ2.zzh = 0L;
    }

    public static /* synthetic */ void y(C1149nQ2 c1149nQ2, double d) {
        c1149nQ2.zze |= 16;
        c1149nQ2.zzj = d;
    }

    public static /* synthetic */ void z(C1149nQ2 c1149nQ2) {
        c1149nQ2.zze &= -17;
        c1149nQ2.zzj = 0.0d;
    }

    public final boolean D() {
        return (this.zze & 16) != 0;
    }

    public final boolean E() {
        return (this.zze & 8) != 0;
    }

    public final boolean F() {
        return (this.zze & 4) != 0;
    }

    public final boolean G() {
        return (this.zze & 2) != 0;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဂ\u0002\u0004ခ\u0003\u0005က\u0004\u0006\u001b", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk", C1149nQ2.class});
        }
        if (i2 == 3) {
            return new C1149nQ2();
        }
        if (i2 == 4) {
            return new C0960kQ2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final double l() {
        return this.zzj;
    }

    public final float m() {
        return this.zzi;
    }

    public final int n() {
        return this.zzk.size();
    }

    public final long o() {
        return this.zzh;
    }

    public final String q() {
        return this.zzf;
    }

    public final String r() {
        return this.zzg;
    }

    public final LW2 s() {
        return this.zzk;
    }
}
