package defpackage;

import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gP2 extends AbstractC1852zW2 {
    private static final gP2 zza;
    private int zze;
    private long zzf;
    private String zzg = "";
    private int zzh;
    private LW2 zzi;
    private LW2 zzj;
    private LW2 zzk;
    private String zzl;
    private boolean zzm;
    private LW2 zzn;
    private LW2 zzo;
    private String zzp;

    static {
        gP2 gp2 = new gP2();
        zza = gp2;
        AbstractC1852zW2.j(gP2.class, gp2);
    }

    public gP2() {
        C0591eY2 c0591eY2 = C0591eY2.w;
        this.zzi = c0591eY2;
        this.zzj = c0591eY2;
        this.zzk = c0591eY2;
        this.zzl = "";
        this.zzn = c0591eY2;
        this.zzo = c0591eY2;
        this.zzp = "";
    }

    public static C0528dP2 p() {
        return (C0528dP2) zza.d();
    }

    public static gP2 q() {
        return zza;
    }

    public static void x(gP2 gp2, int i, C0469cP2 c0469cP2) {
        LW2 lw2 = gp2.zzj;
        if (!((EU2) lw2).t) {
            gp2.zzj = AbstractC1852zW2.h(lw2);
        }
        gp2.zzj.set(i, c0469cP2);
    }

    public static void y(gP2 gp2) {
        gp2.zzk = C0591eY2.w;
    }

    public final boolean A() {
        return (this.zze & 2) != 0;
    }

    public final boolean B() {
        return (this.zze & 1) != 0;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u000b\u0000\u0001\u0001\u000b\u000b\u0000\u0005\u0000\u0001ဂ\u0000\u0002ဈ\u0001\u0003င\u0002\u0004\u001b\u0005\u001b\u0006\u001b\u0007ဈ\u0003\bဇ\u0004\t\u001b\n\u001b\u000bဈ\u0005", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi", C1505tP2.class, "zzj", C0469cP2.class, "zzk", KN2.class, "zzl", "zzm", "zzn", OR2.class, "zzo", VO2.class, "zzp"});
        }
        if (i2 == 3) {
            return new gP2();
        }
        if (i2 == 4) {
            return new C0528dP2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzn.size();
    }

    public final int m() {
        return this.zzj.size();
    }

    public final long n() {
        return this.zzf;
    }

    public final C0469cP2 o(int i) {
        return (C0469cP2) this.zzj.get(i);
    }

    public final String r() {
        return this.zzg;
    }

    public final String s() {
        return this.zzp;
    }

    public final LW2 t() {
        return this.zzk;
    }

    public final List u() {
        return this.zzo;
    }

    public final LW2 v() {
        return this.zzn;
    }

    public final List w() {
        return this.zzi;
    }

    public final boolean z() {
        return this.zzm;
    }
}
