package defpackage;

import java.util.Map;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Rx1 implements Map.Entry {
    public final Object t;
    public final Object u;
    public Rx1 v;
    public Rx1 w;

    public Rx1(Object obj, Object obj2) {
        this.t = obj;
        this.u = obj2;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Rx1)) {
            return false;
        }
        Rx1 rx1 = (Rx1) obj;
        return this.t.equals(rx1.t) && this.u.equals(rx1.u);
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.t;
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.u;
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        return this.t.hashCode() ^ this.u.hashCode();
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        throw new UnsupportedOperationException("An entry modification is not supported");
    }

    public final String toString() {
        return this.t + "=" + this.u;
    }
}
