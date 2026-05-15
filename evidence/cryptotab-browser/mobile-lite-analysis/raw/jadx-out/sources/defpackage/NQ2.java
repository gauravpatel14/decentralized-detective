package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NQ2 extends AbstractC1852zW2 {
    private static final NQ2 zza;
    private LW2 zze = C0591eY2.w;

    static {
        NQ2 nq2 = new NQ2();
        zza = nq2;
        AbstractC1852zW2.j(NQ2.class, nq2);
    }

    public static C1673wQ2 l() {
        return (C1673wQ2) zza.d();
    }

    public static void n(NQ2 nq2, VQ2 vq2) {
        LW2 lw2 = nq2.zze;
        if (!((EU2) lw2).t) {
            nq2.zze = AbstractC1852zW2.h(lw2);
        }
        nq2.zze.add(vq2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zze", VQ2.class});
        }
        if (i2 == 3) {
            return new NQ2();
        }
        if (i2 == 4) {
            return new C1673wQ2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final VQ2 m() {
        return (VQ2) this.zze.get(0);
    }
}
