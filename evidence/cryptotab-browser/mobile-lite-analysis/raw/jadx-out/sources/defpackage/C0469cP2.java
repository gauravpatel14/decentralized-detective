package defpackage;

/* JADX INFO: renamed from: cP2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0469cP2 extends AbstractC1852zW2 {
    private static final C0469cP2 zza;
    private int zze;
    private String zzf = "";
    private boolean zzg;
    private boolean zzh;
    private int zzi;

    static {
        C0469cP2 c0469cP2 = new C0469cP2();
        zza = c0469cP2;
        AbstractC1852zW2.j(C0469cP2.class, c0469cP2);
    }

    public static /* synthetic */ void n(C0469cP2 c0469cP2, String str) {
        str.getClass();
        c0469cP2.zze |= 1;
        c0469cP2.zzf = str;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဇ\u0001\u0003ဇ\u0002\u0004င\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new C0469cP2();
        }
        if (i2 == 4) {
            return new YO2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzi;
    }

    public final String m() {
        return this.zzf;
    }

    public final boolean o() {
        return this.zzg;
    }

    public final boolean p() {
        return this.zzh;
    }

    public final boolean q() {
        return (this.zze & 2) != 0;
    }

    public final boolean r() {
        return (this.zze & 4) != 0;
    }

    public final boolean s() {
        return (this.zze & 8) != 0;
    }
}
