package defpackage;

import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class oA0 extends AbstractC0494ck2 {
    public boolean t;
    public final /* synthetic */ Object u;

    public oA0(Object obj) {
        this.u = obj;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return !this.t;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.t) {
            throw new NoSuchElementException();
        }
        this.t = true;
        return this.u;
    }
}
