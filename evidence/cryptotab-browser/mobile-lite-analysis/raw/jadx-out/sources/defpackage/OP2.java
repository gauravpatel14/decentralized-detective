package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OP2 extends AbstractC1852zW2 {
    private static final OP2 zza;
    private int zze;
    private int zzf;
    private C0961kR2 zzg;
    private C0961kR2 zzh;
    private boolean zzi;

    static {
        OP2 op2 = new OP2();
        zza = op2;
        AbstractC1852zW2.j(OP2.class, op2);
    }

    public static KP2 l() {
        return (KP2) zza.d();
    }

    public static /* synthetic */ void n(OP2 op2, int i) {
        op2.zze |= 1;
        op2.zzf = i;
    }

    public static /* synthetic */ void o(OP2 op2, C0961kR2 c0961kR2) {
        op2.zzg = c0961kR2;
        op2.zze |= 2;
    }

    public static /* synthetic */ void p(OP2 op2, C0961kR2 c0961kR2) {
        op2.zzh = c0961kR2;
        op2.zze |= 4;
    }

    public static /* synthetic */ void q(OP2 op2, boolean z) {
        op2.zze |= 8;
        op2.zzi = z;
    }

    @Override // defpackage.AbstractC1852zW2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0718gY2(zza, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002ဉ\u0001\u0003ဉ\u0002\u0004ဇ\u0003", new Object[]{"zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new OP2();
        }
        if (i2 == 4) {
            return new KP2(zza);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }

    public final C0961kR2 m() {
        C0961kR2 c0961kR2 = this.zzg;
        return c0961kR2 == null ? C0961kR2.q() : c0961kR2;
    }
}
