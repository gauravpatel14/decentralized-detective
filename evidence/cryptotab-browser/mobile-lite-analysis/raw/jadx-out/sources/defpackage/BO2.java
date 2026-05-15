package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BO2 extends AbstractC1852zW2 {
    private static final BO2 zza;
    private int zze;
    private int zzf;
    private boolean zzh;
    private String zzg = "";
    private LW2 zzi = C0591eY2.w;

    static {
        BO2 bo2 = new BO2();
        zza = bo2;
        AbstractC1852zW2.j(BO2.class, bo2);
    }

    public static BO2 m() {
        return zza;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0001\u0000\u0001ဌ\u0000\u0002ဈ\u0001\u0003ဇ\u0002\u0004\u001a", new Object[]{"zze", "zzf", C1614vO2.a, "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new BO2();
        }
        if (i2 == 4) {
            return new C1559uO2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzi.size();
    }

    public final String n() {
        return this.zzg;
    }

    public final LW2 o() {
        return this.zzi;
    }

    public final boolean p() {
        return this.zzh;
    }

    public final boolean q() {
        return (this.zze & 2) != 0;
    }

    public final boolean r() {
        return (this.zze & 1) != 0;
    }

    public final int s() {
        int i;
        switch (this.zzf) {
            case 0:
                i = 1;
                break;
            case 1:
                i = 2;
                break;
            case 2:
                i = 3;
                break;
            case 3:
                i = 4;
                break;
            case 4:
                i = 5;
                break;
            case 5:
                i = 6;
                break;
            case 6:
                i = 7;
                break;
            default:
                i = 0;
                break;
        }
        if (i == 0) {
            return 1;
        }
        return i;
    }
}
