package com.google.android.gms.common.api.internal;

import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.AvailabilityException;
import com.google.android.gms.common.api.HasApiKey;
import defpackage.G62;
import defpackage.H62;
import defpackage.df;
import defpackage.gf;
import java.util.Iterator;
import java.util.Set;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class zal {
    private int zad;
    private final gf zab = new gf(0);
    private final H62 zac = new H62();
    private boolean zae = false;
    private final gf zaa = new gf(0);

    public zal(Iterable iterable) {
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            this.zaa.put(((HasApiKey) it.next()).getApiKey(), null);
        }
        this.zad = ((df) this.zaa.keySet()).t.v;
    }

    public final G62 zaa() {
        return this.zac.a;
    }

    public final Set zab() {
        return this.zaa.keySet();
    }

    public final void zac(ApiKey apiKey, ConnectionResult connectionResult, String str) {
        this.zaa.put(apiKey, connectionResult);
        this.zab.put(apiKey, str);
        this.zad--;
        if (!connectionResult.isSuccess()) {
            this.zae = true;
        }
        if (this.zad == 0) {
            if (!this.zae) {
                this.zac.b(this.zab);
            } else {
                this.zac.a(new AvailabilityException(this.zaa));
            }
        }
    }
}
