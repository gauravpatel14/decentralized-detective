package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class TS2 extends LJ2 {
    private static final TS2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private VR2 zzg;
    private C0643fS2 zzh;

    static {
        TS2 ts2 = new TS2();
        zzb = ts2;
        LJ2.g(TS2.class, ts2);
    }

    public static /* synthetic */ void l(TS2 ts2, C1029lT2 c1029lT2) {
        ts2.zzf = c1029lT2;
        ts2.zze = 4;
    }

    public static /* synthetic */ void m(TS2 ts2, VR2 vr2) {
        vr2.getClass();
        ts2.zzg = vr2;
        ts2.zzd |= 1;
    }

    public static /* synthetic */ void n(TS2 ts2, OQ2 oq2) {
        ts2.zzf = oq2;
        ts2.zze = 2;
    }

    public static /* synthetic */ void o(TS2 ts2, C0412bR2 c0412bR2) {
        ts2.zzf = c0412bR2;
        ts2.zze = 3;
    }

    public static PS2 p() {
        return (PS2) zzb.c();
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0006\u0001\u0001\u0001\u0006\u0006\u0000\u0000\u0000\u0001ဉ\u0000\u0002<\u0000\u0003<\u0000\u0004<\u0000\u0005<\u0000\u0006ဉ\u0001", new Object[]{"zzf", "zze", "zzd", "zzg", OQ2.class, C0412bR2.class, C1029lT2.class, LR2.class, "zzh"});
        }
        if (i2 == 3) {
            return new TS2();
        }
        if (i2 == 4) {
            return new PS2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
