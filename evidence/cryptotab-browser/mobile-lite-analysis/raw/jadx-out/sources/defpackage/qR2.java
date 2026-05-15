package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class qR2 extends LJ2 {
    private static final qR2 zzb;
    private int zzd;
    private int zze;
    private int zzg;
    private String zzf = "";
    private String zzh = "";

    static {
        qR2 qr2 = new qR2();
        zzb = qr2;
        LJ2.g(qR2.class, qr2);
    }

    public static /* synthetic */ void l(qR2 qr2, int i) {
        qr2.zzd |= 1;
        qr2.zze = i;
    }

    public static /* synthetic */ void m(qR2 qr2, String str) {
        str.getClass();
        qr2.zzd |= 2;
        qr2.zzf = str;
    }

    public static /* synthetic */ void n(qR2 qr2, String str) {
        qr2.zzd |= 8;
        qr2.zzh = str;
    }

    public static /* synthetic */ void o(qR2 qr2, int i) {
        qr2.zzg = i - 1;
        qr2.zzd |= 4;
    }

    public static C0708gR2 p() {
        return (C0708gR2) zzb.c();
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0004\u0000\u0001\u0001\u0005\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001\u0004᠌\u0002\u0005ဈ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", C1028lR2.a, "zzh"});
        }
        if (i2 == 3) {
            return new qR2();
        }
        if (i2 == 4) {
            return new C0708gR2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
