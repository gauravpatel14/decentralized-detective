package defpackage;

/* JADX INFO: renamed from: bR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0412bR2 extends LJ2 {
    private static final C0412bR2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        C0412bR2 c0412bR2 = new C0412bR2();
        zzb = c0412bR2;
        LJ2.g(C0412bR2.class, c0412bR2);
    }

    public static /* synthetic */ void l(C0412bR2 c0412bR2, JS2 js2) {
        c0412bR2.zzf = js2;
        c0412bR2.zze = 2;
    }

    public static /* synthetic */ void m(C0412bR2 c0412bR2, int i) {
        c0412bR2.zzg = i - 1;
        c0412bR2.zzd |= 1;
    }

    public static YQ2 n() {
        return (YQ2) zzb.c();
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", SQ2.a, JS2.class, C1510tT2.class});
        }
        if (i2 == 3) {
            return new C0412bR2();
        }
        if (i2 == 4) {
            return new YQ2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
