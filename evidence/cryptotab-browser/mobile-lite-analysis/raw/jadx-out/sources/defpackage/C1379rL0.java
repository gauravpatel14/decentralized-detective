package defpackage;

import java.util.Map;

/* JADX INFO: renamed from: rL0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1379rL0 implements Map.Entry, BB0 {
    public final C1438sL0 t;
    public final int u;

    public C1379rL0(C1438sL0 c1438sL0, int i) {
        this.t = c1438sL0;
        this.u = i;
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            if (lz0.a(entry.getKey(), getKey()) && lz0.a(entry.getValue(), getValue())) {
                return true;
            }
        }
        return false;
    }

    @Override // java.util.Map.Entry
    public final Object getKey() {
        return this.t.t[this.u];
    }

    @Override // java.util.Map.Entry
    public final Object getValue() {
        return this.t.u[this.u];
    }

    @Override // java.util.Map.Entry
    public final int hashCode() {
        Object key = getKey();
        int iHashCode = key != null ? key.hashCode() : 0;
        Object value = getValue();
        return iHashCode ^ (value != null ? value.hashCode() : 0);
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        C1438sL0 c1438sL0 = this.t;
        c1438sL0.b();
        Object[] objArr = c1438sL0.u;
        if (objArr == null) {
            int length = c1438sL0.t.length;
            if (length < 0) {
                throw new IllegalArgumentException("capacity must be non-negative.");
            }
            objArr = new Object[length];
            c1438sL0.u = objArr;
        }
        int i = this.u;
        Object obj2 = objArr[i];
        objArr[i] = obj;
        return obj2;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getKey());
        sb.append('=');
        sb.append(getValue());
        return sb.toString();
    }
}
