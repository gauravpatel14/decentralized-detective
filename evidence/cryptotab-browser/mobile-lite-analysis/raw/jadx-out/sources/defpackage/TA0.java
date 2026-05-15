package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class TA0 extends YA0 {
    public final boolean u;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public TA0(RA0 ra0) {
        super(true);
        boolean z = true;
        A(ra0);
        Oz ozW = w();
        Pz pz = ozW instanceof Pz ? (Pz) ozW : null;
        if (pz == null) {
            z = false;
            break;
        }
        YA0 ya0W = pz.w();
        while (!ya0W.t()) {
            Oz ozW2 = ya0W.w();
            Pz pz2 = ozW2 instanceof Pz ? (Pz) ozW2 : null;
            if (pz2 == null) {
                z = false;
                break;
            }
            ya0W = pz2.w();
        }
        this.u = z;
    }

    @Override // defpackage.YA0
    public final boolean t() {
        return this.u;
    }

    @Override // defpackage.YA0
    public final boolean u() {
        return true;
    }
}
