package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class K60 implements Vv0 {
    public final boolean t;

    public K60(boolean z) {
        this.t = z;
    }

    @Override // defpackage.Vv0
    public final boolean a() {
        return this.t;
    }

    @Override // defpackage.Vv0
    public final m01 k() {
        return null;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("Empty{");
        sb.append(this.t ? "Active" : "New");
        sb.append('}');
        return sb.toString();
    }
}
