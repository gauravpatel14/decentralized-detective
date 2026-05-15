package defpackage;

import java.util.Iterator;
import java.util.NoSuchElementException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class NW implements Iterator, BB0 {
    public int t = -1;
    public int u;
    public int v;
    public C1417ry0 w;
    public int x;
    public final /* synthetic */ OW y;

    public NW(OW ow) {
        this.y = ow;
        int i = ow.b;
        int length = ow.a.length();
        if (length < 0) {
            throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + length + " is less than minimum 0.");
        }
        if (i < 0) {
            i = 0;
        } else if (i > length) {
            i = length;
        }
        this.u = i;
        this.v = i;
    }

    /* JADX WARN: Removed duplicated region for block: B:9:0x001d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a() {
        /*
            r8 = this;
            int r0 = r8.v
            r1 = 0
            if (r0 >= 0) goto Lc
            r8.t = r1
            r0 = 0
            r8.w = r0
            goto L83
        Lc:
            OW r2 = r8.y
            int r3 = r2.c
            r4 = 1
            java.lang.String r5 = r2.a
            r6 = -1
            if (r3 <= 0) goto L1d
            int r7 = r8.x
            int r7 = r7 + r4
            r8.x = r7
            if (r7 >= r3) goto L23
        L1d:
            int r3 = r5.length()
            if (r0 <= r3) goto L34
        L23:
            ry0 r0 = new ry0
            int r1 = r8.u
            int r2 = r5.length()
            int r2 = r2 - r4
            r0.<init>(r1, r2, r4)
            r8.w = r0
            r8.v = r6
            goto L81
        L34:
            aQ1 r0 = r2.d
            int r2 = r8.v
            java.lang.Integer r2 = java.lang.Integer.valueOf(r2)
            java.lang.Object r0 = r0.i(r5, r2)
            I81 r0 = (defpackage.I81) r0
            if (r0 != 0) goto L55
            ry0 r0 = new ry0
            int r1 = r8.u
            int r2 = r5.length()
            int r2 = r2 - r4
            r0.<init>(r1, r2, r4)
            r8.w = r0
            r8.v = r6
            goto L81
        L55:
            java.lang.Object r2 = r0.t
            java.lang.Number r2 = (java.lang.Number) r2
            int r2 = r2.intValue()
            java.lang.Object r0 = r0.u
            java.lang.Number r0 = (java.lang.Number) r0
            int r0 = r0.intValue()
            int r3 = r8.u
            r5 = -2147483648(0xffffffff80000000, float:-0.0)
            if (r2 > r5) goto L6e
            ry0 r3 = defpackage.C1417ry0.w
            goto L76
        L6e:
            ry0 r5 = new ry0
            int r6 = r2 + (-1)
            r5.<init>(r3, r6, r4)
            r3 = r5
        L76:
            r8.w = r3
            int r2 = r2 + r0
            r8.u = r2
            if (r0 != 0) goto L7e
            r1 = r4
        L7e:
            int r2 = r2 + r1
            r8.v = r2
        L81:
            r8.t = r4
        L83:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.NW.a():void");
    }

    @Override // java.util.Iterator
    public final boolean hasNext() {
        if (this.t == -1) {
            a();
        }
        return this.t == 1;
    }

    @Override // java.util.Iterator
    public final Object next() {
        if (this.t == -1) {
            a();
        }
        if (this.t == 0) {
            throw new NoSuchElementException();
        }
        C1417ry0 c1417ry0 = this.w;
        this.w = null;
        this.t = -1;
        return c1417ry0;
    }

    @Override // java.util.Iterator
    public final void remove() {
        throw new UnsupportedOperationException("Operation is not supported for read-only collection");
    }
}
