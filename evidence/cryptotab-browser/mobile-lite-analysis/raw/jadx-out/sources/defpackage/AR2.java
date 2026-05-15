package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class AR2 extends AbstractC1852zW2 {
    private static final AR2 zza;
    private LW2 zze = C0591eY2.w;

    static {
        AR2 ar2 = new AR2();
        zza = ar2;
        AbstractC1852zW2.j(AR2.class, ar2);
    }

    public static AR2 m() {
        return zza;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", JR2.class});
        }
        if (i2 == 3) {
            return new AR2();
        }
        if (i2 == 4) {
            return new C1844zR2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zze.size();
    }

    public final LW2 n() {
        return this.zze;
    }
}
