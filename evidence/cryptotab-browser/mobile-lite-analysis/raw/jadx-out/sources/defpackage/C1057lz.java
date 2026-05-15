package defpackage;

/* JADX INFO: renamed from: lz, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1057lz extends C1119mz {
    public final Throwable a;

    public C1057lz(Throwable th) {
        this.a = th;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1057lz) {
            if (lz0.a(this.a, ((C1057lz) obj).a)) {
                return true;
            }
        }
        return false;
    }

    public final int hashCode() {
        Throwable th = this.a;
        if (th != null) {
            return th.hashCode();
        }
        return 0;
    }

    @Override // defpackage.C1119mz
    public final String toString() {
        return "Closed(" + this.a + ')';
    }
}
