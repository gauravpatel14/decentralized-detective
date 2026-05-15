package defpackage;

/* JADX INFO: renamed from: bT2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0414bT2 extends LJ2 {
    private static final C0414bT2 zzb;
    private int zzd;
    private int zzf;
    private InterfaceC1606vK2 zze = C0407bO2.w;
    private String zzg = "";

    static {
        C0414bT2 c0414bT2 = new C0414bT2();
        zzb = c0414bT2;
        LJ2.g(C0414bT2.class, c0414bT2);
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001\u001a\u0002င\u0000\u0003ဈ\u0001", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new C0414bT2();
        }
        if (i2 == 4) {
            return new XS2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
