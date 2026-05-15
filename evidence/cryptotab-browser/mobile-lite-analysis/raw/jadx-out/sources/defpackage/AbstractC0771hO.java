package defpackage;

/* JADX INFO: renamed from: hO, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0771hO extends AbstractC1590v implements AN {
    public AbstractC0771hO() {
        super(zN.t);
    }

    public abstract void c(InterfaceC0577eO interfaceC0577eO, Runnable runnable);

    public boolean d() {
        return !(this instanceof AbstractC0069Fj2);
    }

    public AbstractC0771hO e(int i) {
        qF0.a(i);
        return new pF0(this, i);
    }

    @Override // defpackage.AbstractC1590v, defpackage.InterfaceC0577eO
    public final InterfaceC0405bO l(InterfaceC0465cO interfaceC0465cO) {
        boolean z;
        if (!(interfaceC0465cO instanceof AbstractC1647w)) {
            if (zN.t == interfaceC0465cO) {
                return this;
            }
            return null;
        }
        AbstractC1647w abstractC1647w = (AbstractC1647w) interfaceC0465cO;
        if (this.t != abstractC1647w) {
            abstractC1647w.getClass();
            z = false;
        } else {
            abstractC1647w.getClass();
            z = true;
        }
        if (!z) {
            return null;
        }
        abstractC1647w.getClass();
        throw null;
    }

    @Override // defpackage.AbstractC1590v, defpackage.InterfaceC0577eO
    public final InterfaceC0577eO q(InterfaceC0465cO interfaceC0465cO) {
        boolean z;
        boolean z2 = interfaceC0465cO instanceof AbstractC1647w;
        R60 r60 = R60.t;
        if (z2) {
            AbstractC1647w abstractC1647w = (AbstractC1647w) interfaceC0465cO;
            if (this.t != abstractC1647w) {
                abstractC1647w.getClass();
                z = false;
            } else {
                abstractC1647w.getClass();
                z = true;
            }
            if (z) {
                abstractC1647w.getClass();
                throw null;
            }
        } else if (zN.t == interfaceC0465cO) {
            return r60;
        }
        return this;
    }

    public String toString() {
        return getClass().getSimpleName() + '@' + hV.a(this);
    }
}
