package defpackage;

/* JADX INFO: renamed from: cQ2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0471cQ2 extends AbstractC1852zW2 {
    private static final C0471cQ2 zza;
    private int zze;
    private LW2 zzf = C0591eY2.w;
    private String zzg = "";
    private long zzh;
    private long zzi;
    private int zzj;

    static {
        C0471cQ2 c0471cQ2 = new C0471cQ2();
        zza = c0471cQ2;
        AbstractC1852zW2.j(C0471cQ2.class, c0471cQ2);
    }

    public static ZP2 o() {
        return (ZP2) zza.d();
    }

    public static /* synthetic */ void s(C0471cQ2 c0471cQ2, int i, C1149nQ2 c1149nQ2) {
        c0471cQ2.B();
        c0471cQ2.zzf.set(i, c1149nQ2);
    }

    public static /* synthetic */ void t(C0471cQ2 c0471cQ2, C1149nQ2 c1149nQ2) {
        c0471cQ2.B();
        c0471cQ2.zzf.add(c1149nQ2);
    }

    public static /* synthetic */ void u(C0471cQ2 c0471cQ2, Iterable iterable) {
        c0471cQ2.B();
        CU2.a(iterable, c0471cQ2.zzf);
    }

    public static void v(C0471cQ2 c0471cQ2) {
        c0471cQ2.zzf = C0591eY2.w;
    }

    public static /* synthetic */ void w(C0471cQ2 c0471cQ2, int i) {
        c0471cQ2.B();
        c0471cQ2.zzf.remove(i);
    }

    public static /* synthetic */ void x(String str, C0471cQ2 c0471cQ2) {
        str.getClass();
        c0471cQ2.zze |= 1;
        c0471cQ2.zzg = str;
    }

    public static /* synthetic */ void y(long j, C0471cQ2 c0471cQ2) {
        c0471cQ2.zze |= 2;
        c0471cQ2.zzh = j;
    }

    public static /* synthetic */ void z(long j, C0471cQ2 c0471cQ2) {
        c0471cQ2.zze |= 4;
        c0471cQ2.zzi = j;
    }

    public final boolean A() {
        return (this.zze & 2) != 0;
    }

    public final void B() {
        LW2 lw2 = this.zzf;
        if (((EU2) lw2).t) {
            return;
        }
        this.zzf = AbstractC1852zW2.h(lw2);
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0001\u0000\u0001\u001b\u0002ဈ\u0000\u0003ဂ\u0001\u0004ဂ\u0002\u0005င\u0003", new Object[]{"zze", "zzf", C1149nQ2.class, "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new C0471cQ2();
        }
        if (i2 == 4) {
            return new ZP2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final int l() {
        return this.zzf.size();
    }

    public final long m() {
        return this.zzi;
    }

    public final long n() {
        return this.zzh;
    }

    public final C1149nQ2 p(int i) {
        return (C1149nQ2) this.zzf.get(i);
    }

    public final String q() {
        return this.zzg;
    }

    public final LW2 r() {
        return this.zzf;
    }
}
