package defpackage;

import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class KN2 extends AbstractC1852zW2 {
    private static final KN2 zza;
    private int zze;
    private int zzf;
    private LW2 zzg;
    private LW2 zzh;
    private boolean zzi;
    private boolean zzj;

    static {
        KN2 kn2 = new KN2();
        zza = kn2;
        AbstractC1852zW2.j(KN2.class, kn2);
    }

    public KN2() {
        C0591eY2 c0591eY2 = C0591eY2.w;
        this.zzg = c0591eY2;
        this.zzh = c0591eY2;
    }

    public static void s(KN2 kn2, int i, C1446sO2 c1446sO2) {
        LW2 lw2 = kn2.zzg;
        if (!((EU2) lw2).t) {
            kn2.zzg = AbstractC1852zW2.h(lw2);
        }
        kn2.zzg.set(i, c1446sO2);
    }

    public static void t(KN2 kn2, int i, RN2 rn2) {
        LW2 lw2 = kn2.zzh;
        if (!((EU2) lw2).t) {
            kn2.zzh = AbstractC1852zW2.h(lw2);
        }
        kn2.zzh.set(i, rn2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001င\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001\u0005ဇ\u0002", new Object[]{"zze", "zzf", "zzg", C1446sO2.class, "zzh", RN2.class, "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new KN2();
        }
        if (i2 == 4) {
            return new JN2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzf;
    }

    public final int m() {
        return this.zzh.size();
    }

    public final int n() {
        return this.zzg.size();
    }

    public final RN2 o(int i) {
        return (RN2) this.zzh.get(i);
    }

    public final C1446sO2 p(int i) {
        return (C1446sO2) this.zzg.get(i);
    }

    public final List q() {
        return this.zzh;
    }

    public final LW2 r() {
        return this.zzg;
    }

    public final boolean u() {
        return (this.zze & 1) != 0;
    }
}
