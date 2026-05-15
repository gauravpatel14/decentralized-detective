package defpackage;

import java.util.Iterator;
import java.util.Set;

/* JADX INFO: renamed from: cE2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0453cE2 extends AbstractC0335aD2 implements Set {
    public transient AD2 u;

    @Override // java.util.Collection, java.util.Set
    public final boolean equals(Object obj) {
        if (obj == this || obj == this) {
            return true;
        }
        if (obj instanceof Set) {
            Set set = (Set) obj;
            try {
                if (size() == set.size()) {
                    if (containsAll(set)) {
                        return true;
                    }
                }
            } catch (ClassCastException | NullPointerException unused) {
            }
        }
        return false;
    }

    @Override // java.util.Collection, java.util.Set
    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (it.hasNext()) {
            Object next = it.next();
            iHashCode += next != null ? next.hashCode() : 0;
        }
        return iHashCode;
    }

    @Override // defpackage.AbstractC0335aD2
    public AD2 l() {
        AD2 ad2 = this.u;
        if (ad2 != null) {
            return ad2;
        }
        AD2 ad2T = t();
        this.u = ad2T;
        return ad2T;
    }

    public AD2 t() {
        Object[] array = toArray(AbstractC0335aD2.t);
        C0884jD2 c0884jD2 = AD2.u;
        int length = array.length;
        return length == 0 ? C1196oE2.x : new C1196oE2(length, array);
    }
}
