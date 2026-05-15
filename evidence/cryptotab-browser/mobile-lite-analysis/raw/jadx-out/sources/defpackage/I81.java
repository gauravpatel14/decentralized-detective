package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class I81 implements Serializable {
    public final Object t;
    public final Object u;

    public I81(Object obj, Object obj2) {
        this.t = obj;
        this.u = obj2;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (!(obj instanceof I81)) {
            return false;
        }
        I81 i81 = (I81) obj;
        return lz0.a(this.t, i81.t) && lz0.a(this.u, i81.u);
    }

    public final int hashCode() {
        Object obj = this.t;
        int iHashCode = (obj == null ? 0 : obj.hashCode()) * 31;
        Object obj2 = this.u;
        return iHashCode + (obj2 != null ? obj2.hashCode() : 0);
    }

    public final String toString() {
        return "(" + this.t + ", " + this.u + ')';
    }
}
