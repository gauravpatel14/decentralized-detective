package defpackage;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class oz1 implements sz1 {
    public final tz1 a;
    public boolean b;
    public Bundle c;
    public final C0646fU1 d;

    public oz1(tz1 tz1Var, InterfaceC0105Io2 interfaceC0105Io2) {
        this.a = tz1Var;
        this.d = new C0646fU1(new nz1(interfaceC0105Io2));
    }

    @Override // defpackage.sz1
    public final Bundle a() {
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        for (Map.Entry entry : ((pz1) this.d.getValue()).b.entrySet()) {
            String str = (String) entry.getKey();
            Bundle bundleA = ((hz1) entry.getValue()).e.a();
            if (!lz0.a(bundleA, Bundle.EMPTY)) {
                bundle.putBundle(str, bundleA);
            }
        }
        this.b = false;
        return bundle;
    }

    public final void b() {
        if (this.b) {
            return;
        }
        Bundle bundleA = this.a.a("androidx.lifecycle.internal.SavedStateHandlesProvider");
        Bundle bundle = new Bundle();
        Bundle bundle2 = this.c;
        if (bundle2 != null) {
            bundle.putAll(bundle2);
        }
        if (bundleA != null) {
            bundle.putAll(bundleA);
        }
        this.c = bundle;
        this.b = true;
    }
}
