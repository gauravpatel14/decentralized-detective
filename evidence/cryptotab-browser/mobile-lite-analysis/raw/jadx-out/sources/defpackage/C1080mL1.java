package defpackage;

import java.util.Map;

/* JADX INFO: renamed from: mL1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1080mL1 implements Map.Entry, Comparable {
    public final Comparable t;
    public Object u;
    public final /* synthetic */ iL1 v;

    public C1080mL1(iL1 il1, Comparable comparable, Object obj) {
        this.v = il1;
        this.t = comparable;
        this.u = obj;
    }

    @Override // java.lang.Comparable
    public final int compareTo(Object obj) {
        return this.t.compareTo(((C1080mL1) obj).t);
    }

    @Override // java.util.Map.Entry
    public final boolean equals(Object obj) {
        if (obj == this) {
            return true;
        }
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Comparable comparable = this.t;
        if (comparable == null ? key == null : comparable.equals(key)) {
            Object obj2 = this.u;
            Object value = entry.getValue();
            if (obj2 == null ? value == null : obj2.equals(value)) {
                return true;
            }
        }
        return false;
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
        Comparable comparable = this.t;
        int iHashCode = comparable == null ? 0 : comparable.hashCode();
        Object obj = this.u;
        return (obj != null ? obj.hashCode() : 0) ^ iHashCode;
    }

    @Override // java.util.Map.Entry
    public final Object setValue(Object obj) {
        this.v.b();
        Object obj2 = this.u;
        this.u = obj;
        return obj2;
    }

    public final String toString() {
        return this.t + "=" + this.u;
    }
}
