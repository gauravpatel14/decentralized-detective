package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class EE1 implements Iterator, InterfaceC1670wN, BB0 {
    public int t;
    public Object u;
    public Iterator v;
    public InterfaceC1670wN w;

    public final RuntimeException a() {
        int i = this.t;
        if (i == 4) {
            return new NoSuchElementException();
        }
        if (i == 5) {
            return new IllegalStateException("Iterator has failed.");
        }
        return new IllegalStateException("Unexpected state of the iterator: " + this.t);
    }

    @Override // defpackage.InterfaceC1670wN
    public final void d(Object obj) throws Throwable {
        bw1.a(obj);
        this.t = 4;
    }

    @Override // defpackage.InterfaceC1670wN
    public final InterfaceC0577eO getContext() {
        return R60.t;
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        while (true) {
            int i = this.t;
            if (i != 0) {
                if (i != 1) {
                    if (i == 2 || i == 3) {
                        return true;
                    }
                    if (i == 4) {
                        return false;
                    }
                    throw a();
                }
                if (this.v.hasNext()) {
                    this.t = 2;
                    return true;
                }
                this.v = null;
            }
            this.t = 5;
            InterfaceC1670wN interfaceC1670wN = this.w;
            this.w = null;
            interfaceC1670wN.d(C0302Yj2.a);
        }
    }

    @Override // java.util.Iterator
    public final Object next() {
        int i = this.t;
        if (i == 0 || i == 1) {
            if (hasNext()) {
                return next();
            }
            throw new NoSuchElementException();
        }
        if (i == 2) {
            this.t = 1;
            return this.v.next();
        }
        if (i != 3) {
            throw a();
        }
        this.t = 0;
        Object obj = this.u;
        this.u = null;
        return obj;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
