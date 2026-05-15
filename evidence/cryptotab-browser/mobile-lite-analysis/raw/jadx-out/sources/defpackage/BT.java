package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BT {
    public final Class a;
    public final boolean b;

    public BT(Class cls, boolean z) {
        this.a = cls;
        this.b = z;
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof BT)) {
            return false;
        }
        BT bt = (BT) obj;
        return bt.a.equals(this.a) && bt.b == this.b;
    }

    public final int hashCode() {
        return ((this.a.hashCode() ^ 1000003) * 1000003) ^ Boolean.valueOf(this.b).hashCode();
    }
}
