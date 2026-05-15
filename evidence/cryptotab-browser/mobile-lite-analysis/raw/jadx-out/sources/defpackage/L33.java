package defpackage;

import android.os.Bundle;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class L33 implements Runnable {
    public final /* synthetic */ C1207oN1 t;
    public final /* synthetic */ C0392bC2 u;

    public L33(C0392bC2 c0392bC2, C1207oN1 c1207oN1) {
        this.u = c0392bC2;
        this.t = c1207oN1;
    }

    @Override // java.lang.Runnable
    public final void run() {
        C1189o33 c1189o33 = this.u.b;
        C1207oN1 c1207oN1 = this.t;
        ArrayList arrayList = c1207oN1.a;
        ArrayList arrayListH = C0392bC2.h(c1207oN1.b);
        Bundle bundle = new Bundle();
        bundle.putInt("session_id", 0);
        bundle.putInt("status", 5);
        bundle.putInt("error_code", 0);
        if (!arrayList.isEmpty()) {
            bundle.putStringArrayList("module_names", new ArrayList<>(arrayList));
        }
        if (!arrayListH.isEmpty()) {
            bundle.putStringArrayList("languages", new ArrayList<>(arrayListH));
        }
        bundle.putLong("total_bytes_to_download", 0L);
        bundle.putLong("bytes_downloaded", 0L);
        c1189o33.c(IB2.b(bundle));
    }
}
