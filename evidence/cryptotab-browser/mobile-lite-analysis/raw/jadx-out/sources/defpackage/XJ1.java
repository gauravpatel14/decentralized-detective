package defpackage;

import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XJ1 implements Iterator {
    public int t;
    public final /* synthetic */ YJ1 u;

    public XJ1(YJ1 yj1) {
        this.u = yj1;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t < this.u.size();
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.t;
        this.t = i + 1;
        return this.u.get(i);
    }
}
