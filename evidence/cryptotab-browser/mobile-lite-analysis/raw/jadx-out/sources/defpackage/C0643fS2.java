package defpackage;

/* JADX INFO: renamed from: fS2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0643fS2 extends LJ2 {
    private static final C0643fS2 zzb;
    private int zzd;
    private boolean zze;
    private boolean zzf;

    static {
        C0643fS2 c0643fS2 = new C0643fS2();
        zzb = c0643fS2;
        LJ2.g(C0643fS2.class, c0643fS2);
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဇ\u0000\u0002ဇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new C0643fS2();
        }
        if (i2 == 4) {
            return new C0413bS2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
