package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JR2 extends AbstractC1852zW2 {
    private static final JR2 zza;
    private int zze;
    private String zzf = "";
    private LW2 zzg = C0591eY2.w;

    static {
        JR2 jr2 = new JR2();
        zza = jr2;
        AbstractC1852zW2.j(JR2.class, jr2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b", new Object[]{"zze", "zzf", "zzg", eS2.class});
        }
        if (i2 == 3) {
            return new JR2();
        }
        if (i2 == 4) {
            return new GR2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final String l() {
        return this.zzf;
    }

    public final LW2 m() {
        return this.zzg;
    }
}
