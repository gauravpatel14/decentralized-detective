package defpackage;

/* JADX INFO: renamed from: gQ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0707gQ2 extends AbstractC1852zW2 {
    private static final C0707gQ2 zza;
    private int zze;
    private String zzf = "";
    private long zzg;

    static {
        C0707gQ2 c0707gQ2 = new C0707gQ2();
        zza = c0707gQ2;
        AbstractC1852zW2.j(C0707gQ2.class, c0707gQ2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new C0707gQ2();
        }
        if (i2 == 4) {
            return new C0530dQ2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
