package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: Cg0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0032Cg0 implements Iterable {
    public final /* synthetic */ Iterable[] t;

    public C0032Cg0(Iterable[] iterableArr) {
        this.t = iterableArr;
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        C0015Bg0 c0015Bg0 = new C0015Bg0(this, this.t.length);
        C1310qA0 c1310qA0 = new C1310qA0();
        c1310qA0.u = C1253pA0.w;
        c1310qA0.v = c0015Bg0;
        return c1310qA0;
    }

    public final String toString() {
        Iterator it = iterator();
        StringBuilder sb = new StringBuilder("[");
        boolean z = true;
        while (true) {
            C1310qA0 c1310qA0 = (C1310qA0) it;
            if (!c1310qA0.hasNext()) {
                sb.append(']');
                return sb.toString();
            }
            if (!z) {
                sb.append(", ");
            }
            sb.append(c1310qA0.next());
            z = false;
        }
    }
}
