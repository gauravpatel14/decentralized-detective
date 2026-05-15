package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class VR2 extends LJ2 {
    private static final VR2 zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        VR2 vr2 = new VR2();
        zzb = vr2;
        LJ2.g(VR2.class, vr2);
    }

    public static /* synthetic */ void l(VR2 vr2, String str) {
        str.getClass();
        vr2.zzd |= 1;
        vr2.zze = str;
    }

    public static /* synthetic */ void m(VR2 vr2, String str) {
        str.getClass();
        vr2.zzd |= 2;
        vr2.zzf = str;
    }

    public static /* synthetic */ void n(VR2 vr2, int i) {
        vr2.zzd |= 4;
        vr2.zzg = i;
    }

    public static SR2 o() {
        return (SR2) zzb.c();
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new VR2();
        }
        if (i2 == 4) {
            return new SR2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
