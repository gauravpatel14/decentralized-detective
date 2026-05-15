package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OR2 extends AbstractC1852zW2 {
    private static final OR2 zza;
    private int zze;
    private LW2 zzf = C0591eY2.w;
    private AR2 zzg;

    static {
        OR2 or2 = new OR2();
        zza = or2;
        AbstractC1852zW2.j(OR2.class, or2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0001\u0000\u0001\u001b\u0002ဉ\u0000", new Object[]{"zze", "zzf", eS2.class, "zzg"});
        }
        if (i2 == 3) {
            return new OR2();
        }
        if (i2 == 4) {
            return new KR2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final AR2 l() {
        AR2 ar2 = this.zzg;
        return ar2 == null ? AR2.m() : ar2;
    }

    public final LW2 m() {
        return this.zzf;
    }
}
