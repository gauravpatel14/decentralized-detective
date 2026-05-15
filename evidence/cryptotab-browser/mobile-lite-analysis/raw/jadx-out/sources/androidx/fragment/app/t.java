package androidx.fragment.app;

import defpackage.AbstractC1867zo2;
import defpackage.C0094Ho2;
import defpackage.C1404ri0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class t extends AbstractC1867zo2 {
    public static final C1404ri0 h = new C1404ri0();
    public final boolean e;
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public final HashMap d = new HashMap();
    public boolean f = false;
    public boolean g = false;

    public t(boolean z) {
        this.e = z;
    }

    @Override // defpackage.AbstractC1867zo2
    public final void b() {
        this.f = true;
    }

    public final void c(String str, boolean z) {
        HashMap map = this.c;
        t tVar = (t) map.get(str);
        if (tVar != null) {
            if (z) {
                ArrayList arrayList = new ArrayList();
                arrayList.addAll(tVar.c.keySet());
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    tVar.c((String) it.next(), true);
                }
            }
            tVar.f = true;
            map.remove(str);
        }
        HashMap map2 = this.d;
        C0094Ho2 c0094Ho2 = (C0094Ho2) map2.get(str);
        if (c0094Ho2 != null) {
            c0094Ho2.a();
            map2.remove(str);
        }
    }

    public final void d(n nVar) {
        if (this.g) {
            return;
        }
        this.b.remove(nVar.mWho);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || t.class != obj.getClass()) {
            return false;
        }
        t tVar = (t) obj;
        return this.b.equals(tVar.b) && this.c.equals(tVar.c) && this.d.equals(tVar.d);
    }

    public final int hashCode() {
        return this.d.hashCode() + ((this.c.hashCode() + (this.b.hashCode() * 31)) * 31);
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("FragmentManagerViewModel{");
        sb.append(Integer.toHexString(System.identityHashCode(this)));
        sb.append("} Fragments (");
        Iterator it = this.b.values().iterator();
        while (it.hasNext()) {
            sb.append(it.next());
            if (it.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") Child Non Config (");
        Iterator it2 = this.c.keySet().iterator();
        while (it2.hasNext()) {
            sb.append((String) it2.next());
            if (it2.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(") ViewModelStores (");
        Iterator it3 = this.d.keySet().iterator();
        while (it3.hasNext()) {
            sb.append((String) it3.next());
            if (it3.hasNext()) {
                sb.append(", ");
            }
        }
        sb.append(')');
        return sb.toString();
    }
}
