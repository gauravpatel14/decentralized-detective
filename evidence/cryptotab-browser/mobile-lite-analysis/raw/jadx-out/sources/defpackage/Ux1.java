package defpackage;

import java.util.Iterator;
import java.util.Map;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Ux1 implements Iterable {
    public Rx1 t;
    public Rx1 u;
    public final WeakHashMap v = new WeakHashMap();
    public int w = 0;

    public Rx1 e(Object obj) {
        Rx1 rx1 = this.t;
        while (rx1 != null && !rx1.t.equals(obj)) {
            rx1 = rx1.v;
        }
        return rx1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:24:0x0048, code lost:
    
        if (r3.hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0050, code lost:
    
        if (((defpackage.Qx1) r7).hasNext() != false) goto L28;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0054, code lost:
    
        return false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:?, code lost:
    
        return true;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final boolean equals(java.lang.Object r7) {
        /*
            r6 = this;
            r0 = 1
            if (r7 != r6) goto L4
            return r0
        L4:
            boolean r1 = r7 instanceof defpackage.Ux1
            r2 = 0
            if (r1 != 0) goto La
            return r2
        La:
            Ux1 r7 = (defpackage.Ux1) r7
            int r1 = r6.w
            int r3 = r7.w
            if (r1 == r3) goto L13
            return r2
        L13:
            java.util.Iterator r1 = r6.iterator()
            java.util.Iterator r7 = r7.iterator()
        L1b:
            r3 = r1
            Qx1 r3 = (defpackage.Qx1) r3
            boolean r4 = r3.hasNext()
            if (r4 == 0) goto L44
            r4 = r7
            Qx1 r4 = (defpackage.Qx1) r4
            boolean r5 = r4.hasNext()
            if (r5 == 0) goto L44
            java.lang.Object r3 = r3.next()
            java.util.Map$Entry r3 = (java.util.Map.Entry) r3
            java.lang.Object r4 = r4.next()
            if (r3 != 0) goto L3b
            if (r4 != 0) goto L43
        L3b:
            if (r3 == 0) goto L1b
            boolean r3 = r3.equals(r4)
            if (r3 != 0) goto L1b
        L43:
            return r2
        L44:
            boolean r1 = r3.hasNext()
            if (r1 != 0) goto L53
            Qx1 r7 = (defpackage.Qx1) r7
            boolean r7 = r7.hasNext()
            if (r7 != 0) goto L53
            goto L54
        L53:
            r0 = r2
        L54:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.Ux1.equals(java.lang.Object):boolean");
    }

    public Object f(Object obj) {
        Rx1 rx1E = e(obj);
        if (rx1E == null) {
            return null;
        }
        this.w--;
        WeakHashMap weakHashMap = this.v;
        if (!weakHashMap.isEmpty()) {
            Iterator it = weakHashMap.keySet().iterator();
            while (it.hasNext()) {
                ((Tx1) it.next()).a(rx1E);
            }
        }
        Rx1 rx1 = rx1E.w;
        if (rx1 != null) {
            rx1.v = rx1E.v;
        } else {
            this.t = rx1E.v;
        }
        Rx1 rx12 = rx1E.v;
        if (rx12 != null) {
            rx12.w = rx1;
        } else {
            this.u = rx1;
        }
        rx1E.v = null;
        rx1E.w = null;
        return rx1E.u;
    }

    public final int hashCode() {
        Iterator it = iterator();
        int iHashCode = 0;
        while (true) {
            Qx1 qx1 = (Qx1) it;
            if (!qx1.hasNext()) {
                return iHashCode;
            }
            iHashCode += ((Map.Entry) qx1.next()).hashCode();
        }
    }

    @Override // java.lang.Iterable
    public final Iterator iterator() {
        Qx1 qx1 = new Qx1(this.t, this.u, 0);
        this.v.put(qx1, Boolean.FALSE);
        return qx1;
    }

    public final String toString() {
        StringBuilder sb = new StringBuilder("[");
        Iterator it = iterator();
        while (true) {
            Qx1 qx1 = (Qx1) it;
            if (!qx1.hasNext()) {
                sb.append("]");
                return sb.toString();
            }
            sb.append(((Map.Entry) qx1.next()).toString());
            if (qx1.hasNext()) {
                sb.append(", ");
            }
        }
    }
}
