package defpackage;

/* JADX INFO: renamed from: lg0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1042lg0 {
    public boolean b = false;
    public int a = 0;

    public final void a(int i) {
        if (this.b) {
            throw new UnsupportedOperationException("Flags is immutable.");
        }
        this.a = i | this.a;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return obj != null && getClass() == obj.getClass() && this.a == ((AbstractC1042lg0) obj).a;
    }

    public final int hashCode() {
        return this.a;
    }
}
