package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class eS2 extends AbstractC1852zW2 {
    private static final eS2 zza;
    private int zze;
    private int zzf;
    private LW2 zzg = C0591eY2.w;
    private String zzh = "";
    private String zzi = "";
    private boolean zzj;
    private double zzk;

    static {
        eS2 es2 = new eS2();
        zza = es2;
        AbstractC1852zW2.j(eS2.class, es2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001ဌ\u0000\u0002\u001b\u0003ဈ\u0001\u0004ဈ\u0002\u0005ဇ\u0003\u0006က\u0004", new Object[]{"zze", "zzf", YR2.a, "zzg", eS2.class, "zzh", "zzi", "zzj", "zzk"});
        }
        if (i2 == 3) {
            return new eS2();
        }
        if (i2 == 4) {
            return new RR2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final double l() {
        return this.zzk;
    }

    public final String m() {
        return this.zzh;
    }

    public final String n() {
        return this.zzi;
    }

    public final LW2 o() {
        return this.zzg;
    }

    public final boolean p() {
        return this.zzj;
    }

    public final boolean q() {
        return (this.zze & 8) != 0;
    }

    public final boolean r() {
        return (this.zze & 16) != 0;
    }

    public final boolean s() {
        return (this.zze & 4) != 0;
    }

    public final int t() {
        int i;
        int i2 = this.zzf;
        if (i2 != 0) {
            i = 2;
            if (i2 != 1) {
                if (i2 != 2) {
                    i = 4;
                    if (i2 != 3) {
                        i = i2 != 4 ? 0 : 5;
                    }
                } else {
                    i = 3;
                }
            }
        } else {
            i = 1;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
