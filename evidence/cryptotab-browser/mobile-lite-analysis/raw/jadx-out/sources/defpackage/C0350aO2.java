package defpackage;

/* JADX INFO: renamed from: aO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0350aO2 extends AbstractC1852zW2 {
    private static final C0350aO2 zza;
    private int zze;
    private BO2 zzf;
    private C1148nO2 zzg;
    private boolean zzh;
    private String zzi = "";

    static {
        C0350aO2 c0350aO2 = new C0350aO2();
        zza = c0350aO2;
        AbstractC1852zW2.j(C0350aO2.class, c0350aO2);
    }

    public static C0350aO2 l() {
        return zza;
    }

    public static /* synthetic */ void p(C0350aO2 c0350aO2, String str) {
        c0350aO2.zze |= 8;
        c0350aO2.zzi = str;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003ဇ\u0002\u0004ဈ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new C0350aO2();
        }
        if (i2 == 4) {
            return new VN2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final C1148nO2 m() {
        C1148nO2 c1148nO2 = this.zzg;
        return c1148nO2 == null ? C1148nO2.l() : c1148nO2;
    }

    public final BO2 n() {
        BO2 bo2 = this.zzf;
        return bo2 == null ? BO2.m() : bo2;
    }

    public final String o() {
        return this.zzi;
    }

    public final boolean q() {
        return this.zzh;
    }

    public final boolean r() {
        return (this.zze & 4) != 0;
    }

    public final boolean s() {
        return (this.zze & 2) != 0;
    }

    public final boolean t() {
        return (this.zze & 1) != 0;
    }
}
