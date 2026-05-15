package defpackage;

/* JADX INFO: renamed from: pU2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1277pU2 extends AbstractC1153nU2 {
    public final Object t;

    public C1277pU2(Object obj) {
        this.t = obj;
    }

    @Override // defpackage.AbstractC1153nU2
    public final Object a() {
        return this.t;
    }

    @Override // defpackage.AbstractC1153nU2
    public final boolean b() {
        return true;
    }

    public final boolean equals(Object obj) {
        if (obj instanceof C1277pU2) {
            return this.t.equals(((C1277pU2) obj).t);
        }
        return false;
    }

    public final int hashCode() {
        return this.t.hashCode() + 1502476572;
    }

    public final String toString() {
        return "Optional.of(" + this.t + ")";
    }
}
