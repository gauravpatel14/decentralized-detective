package defpackage;

/* JADX INFO: renamed from: oP2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1212oP2 extends AbstractC1852zW2 {
    private static final C1212oP2 zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        C1212oP2 c1212oP2 = new C1212oP2();
        zza = c1212oP2;
        AbstractC1852zW2.j(C1212oP2.class, c1212oP2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new C1212oP2();
        }
        if (i2 == 4) {
            return new C0898jP2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
