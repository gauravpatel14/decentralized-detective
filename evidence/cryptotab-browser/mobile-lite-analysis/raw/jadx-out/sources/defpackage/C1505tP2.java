package defpackage;

/* JADX INFO: renamed from: tP2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1505tP2 extends AbstractC1852zW2 {
    private static final C1505tP2 zza;
    private int zze;
    private String zzf = "";
    private String zzg = "";

    static {
        C1505tP2 c1505tP2 = new C1505tP2();
        zza = c1505tP2;
        AbstractC1852zW2.j(C1505tP2.class, c1505tP2);
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
            return new C1505tP2();
        }
        if (i2 == 4) {
            return new C1272pP2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final String l() {
        return this.zzf;
    }

    public final String m() {
        return this.zzg;
    }
}
