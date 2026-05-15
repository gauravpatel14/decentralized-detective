package defpackage;

/* JADX INFO: renamed from: tT2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1510tT2 extends LJ2 {
    private static final C1510tT2 zzb;
    private int zzd;
    private int zze;

    static {
        C1510tT2 c1510tT2 = new C1510tT2();
        zzb = c1510tT2;
        LJ2.g(C1510tT2.class, c1510tT2);
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new C1510tT2();
        }
        if (i2 == 4) {
            return new C1334qT2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
