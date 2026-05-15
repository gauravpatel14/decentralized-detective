package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class RN2 extends AbstractC1852zW2 {
    private static final RN2 zza;
    private int zze;
    private int zzf;
    private String zzg = "";
    private LW2 zzh = C0591eY2.w;
    private boolean zzi;
    private C1148nO2 zzj;
    private boolean zzk;
    private boolean zzl;
    private boolean zzm;

    static {
        RN2 rn2 = new RN2();
        zza = rn2;
        AbstractC1852zW2.j(RN2.class, rn2);
    }

    public static PN2 n() {
        return (PN2) zza.d();
    }

    public static /* synthetic */ void s(RN2 rn2, String str) {
        rn2.zze |= 2;
        rn2.zzg = str;
    }

    public static void t(RN2 rn2, int i, C0350aO2 c0350aO2) {
        LW2 lw2 = rn2.zzh;
        if (!((EU2) lw2).t) {
            rn2.zzh = AbstractC1852zW2.h(lw2);
        }
        rn2.zzh.set(i, c0350aO2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\b\u0000\u0001\u0001\b\b\u0000\u0001\u0000\u0001င\u0000\u0002ဈ\u0001\u0003\u001b\u0004ဇ\u0002\u0005ဉ\u0003\u0006ဇ\u0004\u0007ဇ\u0005\bဇ\u0006", new Object[]{"zze", "zzf", "zzg", "zzh", C0350aO2.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new RN2();
        }
        if (i2 == 4) {
            return new PN2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzh.size();
    }

    public final int m() {
        return this.zzf;
    }

    public final C0350aO2 o(int i) {
        return (C0350aO2) this.zzh.get(i);
    }

    public final C1148nO2 p() {
        C1148nO2 c1148nO2 = this.zzj;
        return c1148nO2 == null ? C1148nO2.l() : c1148nO2;
    }

    public final String q() {
        return this.zzg;
    }

    public final LW2 r() {
        return this.zzh;
    }

    public final boolean u() {
        return this.zzk;
    }

    public final boolean v() {
        return this.zzl;
    }

    public final boolean w() {
        return this.zzm;
    }

    public final boolean x() {
        return (this.zze & 8) != 0;
    }

    public final boolean y() {
        return (this.zze & 1) != 0;
    }

    public final boolean z() {
        return (this.zze & 64) != 0;
    }
}
