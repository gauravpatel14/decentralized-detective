package defpackage;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.c;
import com.google.android.gms.common.api.internal.zaaw;
import com.google.android.gms.common.internal.BaseGmsClient;
import com.google.android.gms.common.internal.zal;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: renamed from: Qy2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0202Qy2 extends AbstractRunnableC0253Uy2 {
    public final HashMap u;
    public final /* synthetic */ zaaw v;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0202Qy2(zaaw zaawVar, HashMap map) {
        super(zaawVar);
        this.v = zaawVar;
        this.u = map;
    }

    @Override // defpackage.AbstractRunnableC0253Uy2
    public final void a() {
        zaaw zaawVar = this.v;
        zal zalVar = new zal(zaawVar.zad);
        ArrayList arrayList = new ArrayList();
        ArrayList arrayList2 = new ArrayList();
        HashMap map = this.u;
        for (Api.Client client : map.keySet()) {
            if (!client.requiresGooglePlayServices() || ((c) map.get(client)).c) {
                arrayList2.add(client);
            } else {
                arrayList.add(client);
            }
        }
        int i = 0;
        int iZab = -1;
        if (!arrayList.isEmpty()) {
            int size = arrayList.size();
            while (i < size) {
                iZab = zalVar.zab(zaawVar.zac, (Api.Client) arrayList.get(i));
                i++;
                if (iZab != 0) {
                    break;
                }
            }
        } else {
            int size2 = arrayList2.size();
            while (i < size2) {
                iZab = zalVar.zab(zaawVar.zac, (Api.Client) arrayList2.get(i));
                i++;
                if (iZab == 0) {
                    break;
                }
            }
        }
        if (iZab != 0) {
            zaawVar.zaa.zal(new C0182Oy2(this, zaawVar, new ConnectionResult(iZab, null)));
            return;
        }
        if (zaawVar.zam && zaawVar.zak != null) {
            zaawVar.zak.zab();
        }
        for (Api.Client client2 : map.keySet()) {
            BaseGmsClient.ConnectionProgressReportCallbacks connectionProgressReportCallbacks = (BaseGmsClient.ConnectionProgressReportCallbacks) map.get(client2);
            if (!client2.requiresGooglePlayServices() || zalVar.zab(zaawVar.zac, client2) == 0) {
                client2.connect(connectionProgressReportCallbacks);
            } else {
                zaawVar.zaa.zal(new C0193Py2(zaawVar, connectionProgressReportCallbacks));
            }
        }
    }
}
