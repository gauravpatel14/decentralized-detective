package defpackage;

import com.google.android.gms.internal.play_billing.zzdc;
import com.google.android.gms.internal.play_billing.zzfe;
import java.io.IOException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OQ2 extends LJ2 {
    private static final OQ2 zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;
    private qR2 zzh;

    static {
        OQ2 oq2 = new OQ2();
        zzb = oq2;
        LJ2.g(OQ2.class, oq2);
    }

    public static OQ2 l(byte[] bArr, HI2 hi2) throws zzdc {
        LJ2 lj2 = zzb;
        int length = bArr.length;
        if (length != 0) {
            lj2 = (LJ2) lj2.k(4);
            try {
                InterfaceC0773hO2 interfaceC0773hO2A = ZN2.c.a(lj2.getClass());
                C0628fG2 c0628fG2 = new C0628fG2();
                hi2.getClass();
                interfaceC0773hO2A.j(lj2, bArr, 0, length, c0628fG2);
                interfaceC0773hO2A.b(lj2);
            } catch (zzdc e) {
                throw e;
            } catch (zzfe e2) {
                throw new zzdc(e2.getMessage());
            } catch (IOException e3) {
                if (e3.getCause() instanceof zzdc) {
                    throw ((zzdc) e3.getCause());
                }
                throw new zzdc(e3.getMessage(), e3);
            } catch (IndexOutOfBoundsException unused) {
                throw zzdc.d();
            }
        }
        if (lj2 == null || LJ2.i(lj2, true)) {
            return (OQ2) lj2;
        }
        throw new zzdc(new zzfe().getMessage());
    }

    public static /* synthetic */ void m(OQ2 oq2, qR2 qr2) {
        oq2.zzh = qr2;
        oq2.zzd |= 2;
    }

    public static /* synthetic */ void n(OQ2 oq2, JS2 js2) {
        oq2.zzf = js2;
        oq2.zze = 4;
    }

    public static /* synthetic */ void o(OQ2 oq2, int i) {
        oq2.zzg = i - 1;
        oq2.zzd |= 1;
    }

    public static xQ2 p() {
        return (xQ2) zzb.c();
    }

    @Override // defpackage.LJ2
    public final Object k(int i) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new C0640fO2(zzb, "\u0001\u0003\u0001\u0001\u0001\u0004\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002ဉ\u0001\u0004<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", SQ2.a, "zzh", JS2.class});
        }
        if (i2 == 3) {
            return new OQ2();
        }
        if (i2 == 4) {
            return new xQ2(zzb);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
