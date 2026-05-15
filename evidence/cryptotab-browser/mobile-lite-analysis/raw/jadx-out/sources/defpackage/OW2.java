package defpackage;

import android.app.Service;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OW2 {
    public final Service a;

    public OW2(Service service) {
        Preconditions.checkNotNull(service);
        this.a = service;
    }

    public final WO2 a() {
        WO2 wo2 = C1391rR2.r(this.a, null, null).i;
        C1391rR2.k(wo2);
        return wo2;
    }
}
