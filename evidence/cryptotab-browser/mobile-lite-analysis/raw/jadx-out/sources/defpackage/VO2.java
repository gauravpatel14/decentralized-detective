package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VO2 extends AbstractC1852zW2 {
    private static final VO2 zza;
    private int zze;
    private String zzf = "";
    private LW2 zzg = C0591eY2.w;
    private boolean zzh;

    static {
        VO2 vo2 = new VO2();
        zza = vo2;
        AbstractC1852zW2.j(VO2.class, vo2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zze", "zzf", "zzg", C1212oP2.class, "zzh"});
        }
        if (i2 == 3) {
            return new VO2();
        }
        if (i2 == 4) {
            return new EO2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final String l() {
        return this.zzf;
    }
}
