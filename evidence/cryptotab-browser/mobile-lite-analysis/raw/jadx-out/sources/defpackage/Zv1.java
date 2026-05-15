package defpackage;

import java.io.Serializable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Zv1 implements Serializable {
    public final Throwable t;

    public Zv1(Throwable th) {
        this.t = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof Zv1) {
            if (lz0.a(this.t, ((Zv1) obj).t)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        return this.t.hashCode();
    }

    public final String toString() {
        return "Failure(" + this.t + ')';
    }
}
