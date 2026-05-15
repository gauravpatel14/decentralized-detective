package defpackage;

import java.util.Iterator;

/* JADX INFO: renamed from: jg2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0922jg2 implements Iterator, BB0 {
    public final Iterator t;
    public final /* synthetic */ C0982kg2 u;

    public C0922jg2(C0982kg2 c0982kg2) {
        this.u = c0982kg2;
        this.t = c0982kg2.a.iterator();
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        return this.t.hasNext();
    }

    /* JADX WARN: Type inference failed for: r0v1, types: [RC0, jk0] */
    @Override // java.util.Iterator
    public final Object next() {
        return this.u.b.j(this.t.next());
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
