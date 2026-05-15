package defpackage;

/* JADX INFO: renamed from: nO2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1148nO2 extends AbstractC1852zW2 {
    private static final C1148nO2 zza;
    private int zze;
    private int zzf;
    private boolean zzg;
    private String zzh = "";
    private String zzi = "";
    private String zzj = "";

    static {
        C1148nO2 c1148nO2 = new C1148nO2();
        zza = c1148nO2;
        AbstractC1852zW2.j(C1148nO2.class, c1148nO2);
    }

    public static C1148nO2 l() {
        return zza;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဈ\u0002\u0004ဈ\u0003\u0005ဈ\u0004", new Object[]{"zze", "zzf", C0705gO2.a, "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new C1148nO2();
        }
        if (i2 == 4) {
            return new C0527dO2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final String m() {
        return this.zzh;
    }

    public final String n() {
        return this.zzj;
    }

    public final String o() {
        return this.zzi;
    }

    public final boolean p() {
        return (this.zze & 1) != 0;
    }

    public final boolean q() {
        return (this.zze & 4) != 0;
    }

    public final boolean r() {
        return (this.zze & 16) != 0;
    }

    public final boolean s() {
        return (this.zze & 8) != 0;
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
