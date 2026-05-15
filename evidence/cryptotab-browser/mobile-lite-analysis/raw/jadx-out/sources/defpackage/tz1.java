package defpackage;

import android.os.Bundle;
import java.util.Iterator;
import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class tz1 {
    public boolean b;
    public Bundle c;
    public boolean d;
    public Ir1 e;
    public final Ux1 a = new Ux1();
    public boolean f = true;

    public final Bundle a(String str) {
        if (!this.d) {
            throw new IllegalStateException("You can consumeRestoredStateForKey only after super.onCreate of corresponding component");
        }
        Bundle bundle = this.c;
        if (bundle == null) {
            return null;
        }
        Bundle bundle2 = bundle.getBundle(str);
        Bundle bundle3 = this.c;
        if (bundle3 != null) {
            bundle3.remove(str);
        }
        Bundle bundle4 = this.c;
        if (bundle4 == null || bundle4.isEmpty()) {
            this.c = null;
        }
        return bundle2;
    }

    public final sz1 b() {
        String str;
        sz1 sz1Var;
        Iterator it = this.a.iterator();
        do {
            Qx1 qx1 = (Qx1) it;
            if (!qx1.hasNext()) {
                return null;
            }
            Map.Entry entry = (Map.Entry) qx1.next();
            str = (String) entry.getKey();
            sz1Var = (sz1) entry.getValue();
        } while (!lz0.a(str, "androidx.lifecycle.internal.SavedStateHandlesProvider"));
        return sz1Var;
    }

    public final void c(String str, sz1 sz1Var) {
        Object obj;
        Ux1 ux1 = this.a;
        Rx1 rx1E = ux1.e(str);
        if (rx1E != null) {
            obj = rx1E.u;
        } else {
            Rx1 rx1 = new Rx1(str, sz1Var);
            ux1.w++;
            Rx1 rx12 = ux1.u;
            if (rx12 == null) {
                ux1.t = rx1;
                ux1.u = rx1;
            } else {
                rx12.v = rx1;
                rx1.w = rx12;
                ux1.u = rx1;
            }
            obj = null;
        }
        if (((sz1) obj) != null) {
            throw new IllegalArgumentException("SavedStateProvider with the given key is already registered");
        }
    }

    public final void d() {
        if (!this.f) {
            throw new IllegalStateException("Can not perform this action after onSaveInstanceState");
        }
        Ir1 ir1 = this.e;
        if (ir1 == null) {
            ir1 = new Ir1(this);
        }
        this.e = ir1;
        try {
            C1824zE0.class.getDeclaredConstructor(null);
            Ir1 ir12 = this.e;
            if (ir12 != null) {
                ir12.a.add(C1824zE0.class.getName());
            }
        } catch (NoSuchMethodException e) {
            throw new IllegalArgumentException("Class " + C1824zE0.class.getSimpleName() + " must have default constructor in order to be automatically recreated", e);
        }
    }
}
