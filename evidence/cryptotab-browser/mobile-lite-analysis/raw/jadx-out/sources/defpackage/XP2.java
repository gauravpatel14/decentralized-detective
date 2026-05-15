package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XP2 extends AbstractC1852zW2 {
    private static final XP2 zza;
    private int zze;
    private int zzf;
    private long zzg;

    static {
        XP2 xp2 = new XP2();
        zza = xp2;
        AbstractC1852zW2.j(XP2.class, xp2);
    }

    public static RP2 n() {
        return (RP2) zza.d();
    }

    public static /* synthetic */ void o(XP2 xp2, int i) {
        xp2.zze |= 1;
        xp2.zzf = i;
    }

    public static /* synthetic */ void p(XP2 xp2, long j) {
        xp2.zze |= 2;
        xp2.zzg = j;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဂ\u0001", new Object[]{"zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new XP2();
        }
        if (i2 == 4) {
            return new RP2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzf;
    }

    public final long m() {
        return this.zzg;
    }

    public final boolean q() {
        return (this.zze & 2) != 0;
    }

    public final boolean r() {
        return (this.zze & 1) != 0;
    }
}
