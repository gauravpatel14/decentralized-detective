package defpackage;

import android.content.Context;
import android.util.Pair;
import com.google.android.gms.ads.identifier.AdvertisingIdClient;
import java.math.BigInteger;
import java.security.MessageDigest;
import java.util.HashMap;
import java.util.Locale;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EW2 extends AbstractC0906jX2 {
    public final HashMap d;
    public String e;
    public boolean f;
    public long g;
    public final FP2 h;
    public final FP2 i;
    public final FP2 j;
    public final FP2 k;
    public final FP2 l;

    public EW2(QX2 qx2) {
        super(qx2);
        this.d = new HashMap();
        TP2 tp2 = this.a.h;
        C1391rR2.i(tp2);
        this.h = new FP2(tp2, "last_delete_stale", 0L);
        TP2 tp22 = this.a.h;
        C1391rR2.i(tp22);
        this.i = new FP2(tp22, "backoff", 0L);
        TP2 tp23 = this.a.h;
        C1391rR2.i(tp23);
        this.j = new FP2(tp23, "last_upload", 0L);
        TP2 tp24 = this.a.h;
        C1391rR2.i(tp24);
        this.k = new FP2(tp24, "last_upload_attempt", 0L);
        TP2 tp25 = this.a.h;
        C1391rR2.i(tp25);
        this.l = new FP2(tp25, "midnight_offset", 0L);
    }

    public final Pair k(String str) {
        AdvertisingIdClient.Info advertisingIdInfo;
        DW2 dw2;
        AdvertisingIdClient.Info advertisingIdInfo2;
        g();
        C1391rR2 c1391rR2 = this.a;
        long jElapsedRealtime = c1391rR2.n.elapsedRealtime();
        C0910jZ2.b();
        C0467cO2 c0467cO2 = AbstractC0579eO2.n0;
        C1009lD2 c1009lD2 = c1391rR2.g;
        boolean zP = c1009lD2.p(null, c0467cO2);
        WO2 wo2 = c1391rR2.i;
        Context context = c1391rR2.a;
        if (zP) {
            HashMap map = this.d;
            DW2 dw22 = (DW2) map.get(str);
            if (dw22 != null && jElapsedRealtime < dw22.c) {
                return new Pair(dw22.a, Boolean.valueOf(dw22.b));
            }
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
            long jM = c1009lD2.m(str, AbstractC0579eO2.b) + jElapsedRealtime;
            try {
                advertisingIdInfo2 = AdvertisingIdClient.getAdvertisingIdInfo(context);
            } catch (Exception e) {
                C1391rR2.k(wo2);
                wo2.m.b(e, "Unable to get advertising id");
                dw2 = new DW2("", jM, false);
            }
            if (advertisingIdInfo2 == null) {
                return new Pair("", Boolean.FALSE);
            }
            String id = advertisingIdInfo2.getId();
            dw2 = id != null ? new DW2(id, jM, advertisingIdInfo2.isLimitAdTrackingEnabled()) : new DW2("", jM, advertisingIdInfo2.isLimitAdTrackingEnabled());
            map.put(str, dw2);
            AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
            return new Pair(dw2.a, Boolean.valueOf(dw2.b));
        }
        String str2 = this.e;
        if (str2 != null && jElapsedRealtime < this.g) {
            return new Pair(str2, Boolean.valueOf(this.f));
        }
        this.g = c1009lD2.m(str, AbstractC0579eO2.b) + jElapsedRealtime;
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(true);
        try {
            advertisingIdInfo = AdvertisingIdClient.getAdvertisingIdInfo(context);
        } catch (Exception e2) {
            C1391rR2.k(wo2);
            wo2.m.b(e2, "Unable to get advertising id");
            this.e = "";
        }
        if (advertisingIdInfo == null) {
            return new Pair("", Boolean.FALSE);
        }
        this.e = "";
        String id2 = advertisingIdInfo.getId();
        if (id2 != null) {
            this.e = id2;
        }
        this.f = advertisingIdInfo.isLimitAdTrackingEnabled();
        AdvertisingIdClient.setShouldSkipGmsCoreVersionCheck(false);
        return new Pair(this.e, Boolean.valueOf(this.f));
    }

    public final Pair l(String str, CD2 cd2) {
        return cd2.f(EnumC1486tD2.AD_STORAGE) ? k(str) : new Pair("", Boolean.FALSE);
    }

    public final String m(String str) {
        g();
        String str2 = (String) k(str).first;
        MessageDigest messageDigestN = C0653fY2.n();
        if (messageDigestN == null) {
            return null;
        }
        return String.format(Locale.US, "%032X", new BigInteger(1, messageDigestN.digest(str2.getBytes())));
    }

    @Override // defpackage.AbstractC0906jX2
    public final void j() {
    }
}
