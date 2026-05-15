package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BE2 implements Iterator {
    public int t = 0;
    public final /* synthetic */ OE2 u;

    public BE2(OE2 oe2) {
        this.u = oe2;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t < this.u.t.length();
    }

    @Override // java.util.Iterator
    public final /* bridge */ /* synthetic */ Object next() {
        int i = this.t;
        if (i >= this.u.t.length()) {
            throw new NoSuchElementException();
        }
        this.t = i + 1;
        return new OE2(String.valueOf(i));
    }
}
