package androidx.fragment.app;

import android.os.Bundle;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class v {
    public final ArrayList a = new ArrayList();
    public final HashMap b = new HashMap();
    public final HashMap c = new HashMap();
    public t d;

    public final void a(n nVar) {
        if (this.a.contains(nVar)) {
            throw new IllegalStateException("Fragment already added: " + nVar);
        }
        synchronized (this.a) {
            this.a.add(nVar);
        }
        nVar.mAdded = true;
    }

    public final n b(String str) {
        u uVar = (u) this.b.get(str);
        if (uVar != null) {
            return uVar.c;
        }
        return null;
    }

    public final n c(String str) {
        n nVarFindFragmentByWho;
        for (u uVar : this.b.values()) {
            if (uVar != null && (nVarFindFragmentByWho = uVar.c.findFragmentByWho(str)) != null) {
                return nVarFindFragmentByWho;
            }
        }
        return null;
    }

    public final ArrayList d() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                arrayList.add(uVar);
            }
        }
        return arrayList;
    }

    public final ArrayList e() {
        ArrayList arrayList = new ArrayList();
        for (u uVar : this.b.values()) {
            if (uVar != null) {
                arrayList.add(uVar.c);
            } else {
                arrayList.add(null);
            }
        }
        return arrayList;
    }

    public final List f() {
        ArrayList arrayList;
        if (this.a.isEmpty()) {
            return Collections.emptyList();
        }
        synchronized (this.a) {
            arrayList = new ArrayList(this.a);
        }
        return arrayList;
    }

    public final void g(u uVar) {
        n nVar = uVar.c;
        String str = nVar.mWho;
        HashMap map = this.b;
        if (map.get(str) != null) {
            return;
        }
        map.put(nVar.mWho, uVar);
        if (nVar.mRetainInstanceChangedWhileDetached) {
            if (nVar.mRetainInstance) {
                t tVar = this.d;
                if (!tVar.g) {
                    HashMap map2 = tVar.b;
                    if (!map2.containsKey(nVar.mWho)) {
                        map2.put(nVar.mWho, nVar);
                    }
                }
            } else {
                this.d.d(nVar);
            }
            nVar.mRetainInstanceChangedWhileDetached = false;
        }
    }

    public final void h(u uVar) {
        n nVar = uVar.c;
        if (nVar.mRetainInstance) {
            this.d.d(nVar);
        }
        HashMap map = this.b;
        if (map.get(nVar.mWho) != uVar) {
            return;
        }
    }

    public final Bundle i(String str, Bundle bundle) {
        HashMap map = this.c;
        return bundle != null ? (Bundle) map.put(str, bundle) : (Bundle) map.remove(str);
    }
}
