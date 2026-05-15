package defpackage;

/* JADX INFO: renamed from: vR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1618vR2 extends AbstractC1852zW2 {
    private static final C1618vR2 zza;
    private int zze;
    private long zzf;
    private String zzg = "";
    private String zzh = "";
    private long zzi;
    private float zzj;
    private double zzk;

    static {
        C1618vR2 c1618vR2 = new C1618vR2();
        zza = c1618vR2;
        AbstractC1852zW2.j(C1618vR2.class, c1618vR2);
    }

    public static C1448sR2 o() {
        return (C1448sR2) zza.d();
    }

    public static /* synthetic */ void r(C1618vR2 c1618vR2, long j) {
        c1618vR2.zze |= 1;
        c1618vR2.zzf = j;
    }

    public static /* synthetic */ void s(C1618vR2 c1618vR2, String str) {
        str.getClass();
        c1618vR2.zze |= 2;
        c1618vR2.zzg = str;
    }

    public static /* synthetic */ void t(C1618vR2 c1618vR2, String str) {
        str.getClass();
        c1618vR2.zze |= 4;
        c1618vR2.zzh = str;
    }

    public static /* synthetic */ void u(C1618vR2 c1618vR2) {
        c1618vR2.zze &= -5;
        c1618vR2.zzh = zza.zzh;
    }

    public static /* synthetic */ void v(C1618vR2 c1618vR2, long j) {
        c1618vR2.zze |= 8;
        c1618vR2.zzi = j;
    }

    public static /* synthetic */ void w(C1618vR2 c1618vR2) {
        c1618vR2.zze &= -9;
        c1618vR2.zzi = 0L;
    }

    public static /* synthetic */ void x(C1618vR2 c1618vR2, double d) {
        c1618vR2.zze |= 32;
        c1618vR2.zzk = d;
    }

    public static /* synthetic */ void y(C1618vR2 c1618vR2) {
        c1618vR2.zze &= -33;
        c1618vR2.zzk = 0.0d;
    }

    public final boolean A() {
        return (this.zze & 8) != 0;
    }

    public final boolean B() {
        return (this.zze & 1) != 0;
    }

    public final boolean C() {
        return (this.zze & 4) != 0;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003ဈ\u0002\u0004ဂ\u0003\u0005ခ\u0004\u0006က\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new C1618vR2();
        }
        if (i2 == 4) {
            return new C1448sR2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final double l() {
        return this.zzk;
    }

    public final long m() {
        return this.zzi;
    }

    public final long n() {
        return this.zzf;
    }

    public final String p() {
        return this.zzg;
    }

    public final String q() {
        return this.zzh;
    }

    public final boolean z() {
        return (this.zze & 32) != 0;
    }
}
