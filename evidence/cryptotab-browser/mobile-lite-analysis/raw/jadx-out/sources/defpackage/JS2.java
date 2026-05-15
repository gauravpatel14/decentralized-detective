package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JS2 extends LJ2 {
    private static final JS2 zzb;
    private int zzd;
    private int zze;

    static {
        JS2 js2 = new JS2();
        zzb = js2;
        LJ2.g(JS2.class, js2);
    }

    public static /* synthetic */ void l(JS2 js2, int i) {
        js2.zze = i - 1;
        js2.zzd |= 1;
    }

    public static C1090mS2 m() {
        return (C1090mS2) zzb.c();
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001᠌\u0000", new Object[]{"zzd", "zze", FS2.a});
        }
        if (i2 == 3) {
            return new JS2();
        }
        if (i2 == 4) {
            return new C1090mS2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
