package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IE2 implements Iterator {
    public int t = 0;
    public final /* synthetic */ OE2 u;

    public IE2(OE2 oe2) {
        this.u = oe2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t < this.u.t.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.t;
        OE2 oe2 = this.u;
        if (i >= oe2.t.length()) {
            throw new NoSuchElementException();
        }
        this.t = i + 1;
        return new OE2(String.valueOf(oe2.t.charAt(i)));
    }
}
