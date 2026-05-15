package defpackage;

/* JADX INFO: renamed from: sO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1446sO2 extends AbstractC1852zW2 {
    private static final C1446sO2 zza;
    private int zze;
    private int zzf;
    private String zzg = "";
    private C0350aO2 zzh;
    private boolean zzi;
    private boolean zzj;
    private boolean zzk;

    static {
        C1446sO2 c1446sO2 = new C1446sO2();
        zza = c1446sO2;
        AbstractC1852zW2.j(C1446sO2.class, c1446sO2);
    }

    public static C1211oO2 n() {
        return (C1211oO2) zza.d();
    }

    public static /* synthetic */ void p(C1446sO2 c1446sO2, String str) {
        c1446sO2.zze |= 2;
        c1446sO2.zzg = str;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0003ဉ\u0002\u0004ဇ\u0003\u0005ဇ\u0004\u0006ဇ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new C1446sO2();
        }
        if (i2 == 4) {
            return new C1211oO2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzf;
    }

    public final C0350aO2 m() {
        C0350aO2 c0350aO2 = this.zzh;
        return c0350aO2 == null ? C0350aO2.l() : c0350aO2;
    }

    public final String o() {
        return this.zzg;
    }

    public final boolean q() {
        return this.zzi;
    }

    public final boolean r() {
        return this.zzj;
    }

    public final boolean s() {
        return this.zzk;
    }

    public final boolean t() {
        return (this.zze & 1) != 0;
    }

    public final boolean u() {
        return (this.zze & 32) != 0;
    }
}
