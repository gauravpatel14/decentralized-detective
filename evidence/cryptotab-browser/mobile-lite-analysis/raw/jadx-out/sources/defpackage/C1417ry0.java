package defpackage;

/* JADX INFO: renamed from: ry0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1417ry0 extends py0 {
    public static final C1417ry0 w = new C1417ry0(1, 0, 1);

    @Override // defpackage.py0
    public final boolean equals(Object obj) {
        if (obj instanceof C1417ry0) {
            if (!isEmpty() || !((C1417ry0) obj).isEmpty()) {
                C1417ry0 c1417ry0 = (C1417ry0) obj;
                if (this.t == c1417ry0.t) {
                    if (this.u == c1417ry0.u) {
                    }
                }
            }
            return true;
        }
        return false;
    }

    @Override // defpackage.py0
    public final int hashCode() {
        if (isEmpty()) {
            return -1;
        }
        return (this.t * 31) + this.u;
    }

    @Override // defpackage.py0
    public final boolean isEmpty() {
        return this.t > this.u;
    }

    @Override // defpackage.py0
    public final String toString() {
        return this.t + ".." + this.u;
    }
}
