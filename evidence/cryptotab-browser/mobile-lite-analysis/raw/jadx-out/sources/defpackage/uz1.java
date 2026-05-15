package defpackage;

import android.os.Bundle;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class uz1 {
    public final vz1 a;
    public final tz1 b = new tz1();
    public boolean c;

    public uz1(vz1 vz1Var) {
        this.a = vz1Var;
    }

    public final void a() {
        vz1 vz1Var = this.a;
        AbstractC0514dF0 lifecycle = vz1Var.getLifecycle();
        if (((C0886jF0) lifecycle).c != cF0.u) {
            throw new IllegalStateException("Restarter must be created only during owner's initialization stage");
        }
        lifecycle.a(new Jr1(vz1Var));
        final tz1 tz1Var = this.b;
        if (tz1Var.b) {
            throw new IllegalStateException("SavedStateRegistry was already attached.");
        }
        lifecycle.a(new InterfaceC0564eF0() { // from class: qz1
            @Override // defpackage.InterfaceC0564eF0
            public final void c(InterfaceC0762hF0 interfaceC0762hF0, bF0 bf0) {
                bF0 bf02 = bF0.ON_START;
                tz1 tz1Var2 = tz1Var;
                if (bf0 == bf02) {
                    tz1Var2.f = true;
                } else if (bf0 == bF0.ON_STOP) {
                    tz1Var2.f = false;
                }
            }
        });
        tz1Var.b = true;
        this.c = true;
    }

    public final void b(Bundle bundle) {
        if (!this.c) {
            a();
        }
        C0886jF0 c0886jF0 = (C0886jF0) this.a.getLifecycle();
        if (c0886jF0.c.a(cF0.w)) {
            throw new IllegalStateException(("performRestore cannot be called when owner is " + c0886jF0.c).toString());
        }
        tz1 tz1Var = this.b;
        if (!tz1Var.b) {
            throw new IllegalStateException("You must call performAttach() before calling performRestore(Bundle).");
        }
        if (tz1Var.d) {
            throw new IllegalStateException("SavedStateRegistry was already restored.");
        }
        tz1Var.c = bundle != null ? bundle.getBundle("androidx.lifecycle.BundlableSavedStateRegistry.key") : null;
        tz1Var.d = true;
    }

    public final void c(Bundle bundle) {
        tz1 tz1Var = this.b;
        tz1Var.getClass();
        Bundle bundle2 = new Bundle();
        Bundle bundle3 = tz1Var.c;
        if (bundle3 != null) {
            bundle2.putAll(bundle3);
        }
        Ux1 ux1 = tz1Var.a;
        ux1.getClass();
        Sx1 sx1 = new Sx1(ux1);
        ux1.v.put(sx1, Boolean.FALSE);
        while (sx1.hasNext()) {
            Map.Entry entry = (Map.Entry) sx1.next();
            bundle2.putBundle((String) entry.getKey(), ((sz1) entry.getValue()).a());
        }
        if (bundle2.isEmpty()) {
            return;
        }
        bundle.putBundle("androidx.lifecycle.BundlableSavedStateRegistry.key", bundle2);
    }
}
