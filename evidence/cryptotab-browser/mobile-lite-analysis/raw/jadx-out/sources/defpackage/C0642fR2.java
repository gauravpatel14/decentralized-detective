package defpackage;

/* JADX INFO: renamed from: fR2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0642fR2 extends AbstractC1852zW2 {
    private static final C0642fR2 zza;
    private int zze;
    private int zzf = 1;
    private LW2 zzg = C0591eY2.w;

    static {
        C0642fR2 c0642fR2 = new C0642fR2();
        zza = c0642fR2;
        AbstractC1852zW2.j(C0642fR2.class, c0642fR2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b", new Object[]{"zze", "zzf", C0354aR2.a, "zzg", C0707gQ2.class});
        }
        if (i2 == 3) {
            return new C0642fR2();
        }
        if (i2 == 4) {
            return new ZQ2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
