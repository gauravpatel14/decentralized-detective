package defpackage;

/* JADX INFO: renamed from: tQ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1506tQ2 extends AbstractC1852zW2 {
    private static final C1506tQ2 zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private HP2 zzh;

    static {
        C1506tQ2 c1506tQ2 = new C1506tQ2();
        zza = c1506tQ2;
        AbstractC1852zW2.j(C1506tQ2.class, c1506tQ2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003ဉ\u0002", new Object[]{"zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new C1506tQ2();
        }
        if (i2 == 4) {
            return new qQ2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
