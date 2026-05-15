package defpackage;

import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: renamed from: kC2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0944kC2 {
    public XB2 a;
    public XB2 b;
    public final ArrayList c;

    public C0944kC2() {
        this.a = new XB2("", 0L, null);
        this.b = new XB2("", 0L, null);
        this.c = new ArrayList();
    }

    public final /* bridge */ /* synthetic */ Object clone() {
        C0944kC2 c0944kC2 = new C0944kC2(this.a.clone());
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            c0944kC2.c.add(((XB2) it.next()).clone());
        }
        return c0944kC2;
    }

    public C0944kC2(XB2 xb2) {
        this.a = xb2;
        this.b = xb2.clone();
        this.c = new ArrayList();
    }
}
