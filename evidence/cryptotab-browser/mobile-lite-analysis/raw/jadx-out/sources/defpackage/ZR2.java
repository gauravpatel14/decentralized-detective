package defpackage;

import android.os.Bundle;
import android.text.TextUtils;
import com.google.android.gms.internal.measurement.zzd;
import com.google.android.gms.measurement.internal.zzau;
import com.google.android.gms.measurement.internal.zzaw;
import com.google.android.gms.measurement.internal.zzq;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZR2 implements Runnable {
    public final /* synthetic */ zzaw t;
    public final /* synthetic */ zzq u;
    public final /* synthetic */ MS2 v;

    public ZR2(MS2 ms2, zzaw zzawVar, zzq zzqVar) {
        this.v = ms2;
        this.t = zzawVar;
        this.u = zzqVar;
    }

    @Override // java.lang.Runnable
    public final void run() {
        gP2 gp2;
        zzau zzauVar;
        MS2 ms2 = this.v;
        ms2.getClass();
        zzaw zzawVar = this.t;
        boolean zEquals = "_cmp".equals(zzawVar.t);
        QX2 qx2 = ms2.t;
        if (zEquals && (zzauVar = zzawVar.u) != null) {
            Bundle bundle = zzauVar.t;
            if (bundle.size() != 0) {
                String string = bundle.getString("_cis");
                if ("referrer broadcast".equals(string) || "referrer API".equals(string)) {
                    qx2.d().l.b(zzawVar.toString(), "Event has been filtered ");
                    zzawVar = new zzaw("_cmpx", zzawVar.u, zzawVar.v, zzawVar.w);
                }
            }
        }
        String str = zzawVar.t;
        TQ2 tq2 = qx2.a;
        VX2 vx2 = qx2.g;
        QX2.H(tq2);
        zzq zzqVar = this.u;
        String str2 = zzqVar.t;
        if (TextUtils.isEmpty(str2) || (gp2 = (gP2) tq2.h.get(str2)) == null || gp2.l() == 0) {
            ms2.X0(zzawVar, zzqVar);
            return;
        }
        CO2 co2 = qx2.d().n;
        String str3 = zzqVar.t;
        co2.b(str3, "EES config found for");
        TQ2 tq22 = qx2.a;
        QX2.H(tq22);
        XH2 xh2 = TextUtils.isEmpty(str3) ? null : (XH2) tq22.j.b(str3);
        if (xh2 == null) {
            qx2.d().n.b(str3, "EES not loaded for");
            ms2.X0(zzawVar, zzqVar);
            return;
        }
        try {
            C0944kC2 c0944kC2 = xh2.c;
            QX2.H(vx2);
            HashMap mapV = vx2.v(zzawVar.u.f2(), true);
            String strA = RU2.a(str, AbstractC0355aT2.c, AbstractC0355aT2.a);
            if (strA == null) {
                strA = str;
            }
            if (xh2.b(new XB2(strA, zzawVar.w, mapV))) {
                if (c0944kC2.b.equals(c0944kC2.a)) {
                    ms2.X0(zzawVar, zzqVar);
                } else {
                    qx2.d().n.b(str, "EES edited event");
                    QX2.H(vx2);
                    ms2.X0(vx2.q(c0944kC2.b), zzqVar);
                }
                if (c0944kC2.c.isEmpty()) {
                    return;
                }
                for (XB2 xb2 : c0944kC2.c) {
                    qx2.d().n.b(xb2.a, "EES logging created event");
                    QX2.H(vx2);
                    ms2.X0(vx2.q(xb2), zzqVar);
                }
                return;
            }
        } catch (zzd unused) {
            qx2.d().f.c(zzqVar.u, str, "EES error. appId, eventName");
        }
        qx2.d().n.b(str, "EES was not applied to event");
        ms2.X0(zzawVar, zzqVar);
    }
}
