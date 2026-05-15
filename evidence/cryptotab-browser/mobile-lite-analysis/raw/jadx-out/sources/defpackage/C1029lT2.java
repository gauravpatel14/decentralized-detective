package defpackage;

/* JADX INFO: renamed from: lT2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1029lT2 extends LJ2 {
    private static final C1029lT2 zzb;
    private int zzd;
    private int zze;

    static {
        C1029lT2 c1029lT2 = new C1029lT2();
        zzb = c1029lT2;
        LJ2.g(C1029lT2.class, c1029lT2);
    }

    public static C1029lT2 l() {
        return zzb;
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", C0843iT2.a});
        }
        if (i2 == 3) {
            return new C1029lT2();
        }
        if (i2 == 4) {
            return new C0583eT2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
