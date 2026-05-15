package defpackage;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class MJ0 {
    public final int a;
    public final NJ0 b;
    public final KI0 c;
    public int d;
    public int e;
    public int f;

    public MJ0(int i) {
        this.a = i;
        if (i <= 0) {
            AbstractC1588ux1.a("maxSize <= 0");
            throw null;
        }
        this.b = new NJ0();
        this.c = new KI0();
    }

    public Object a(Object obj) {
        return null;
    }

    public final Object b(Object obj) {
        Object objPut;
        synchronized (this.c) {
            Object obj2 = this.b.a.get(obj);
            if (obj2 != null) {
                this.e++;
                return obj2;
            }
            this.f++;
            Object objA = a(obj);
            if (objA == null) {
                return null;
            }
            synchronized (this.c) {
                try {
                    objPut = this.b.a.put(obj, objA);
                    if (objPut != null) {
                        this.b.a.put(obj, objPut);
                    } else {
                        this.d += e(obj, objA);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (objPut != null) {
                return objPut;
            }
            g(this.a);
            return objA;
        }
    }

    public final Object c(Object obj, Object obj2) {
        Object objPut;
        synchronized (this.c) {
            this.d += e(obj, obj2);
            objPut = this.b.a.put(obj, obj2);
            if (objPut != null) {
                this.d -= e(obj, objPut);
            }
        }
        g(this.a);
        return objPut;
    }

    public final void d(String str) {
        synchronized (this.c) {
            Object objRemove = this.b.a.remove(str);
            if (objRemove != null) {
                this.d -= e(str, objRemove);
            }
        }
    }

    public final int e(Object obj, Object obj2) {
        int iF = f(obj, obj2);
        if (iF >= 0) {
            return iF;
        }
        throw new IllegalStateException("Negative size: " + obj + '=' + obj2);
    }

    public int f(Object obj, Object obj2) {
        return 1;
    }

    /* JADX WARN: Code restructure failed: missing block: B:39:0x0079, code lost:
    
        return;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void g(int r6) {
        /*
            r5 = this;
        L0:
            KI0 r0 = r5.c
            monitor-enter(r0)
            int r1 = r5.d     // Catch: java.lang.Throwable -> L17
            r2 = 0
            if (r1 < 0) goto L1c
            NJ0 r1 = r5.b     // Catch: java.lang.Throwable -> L17
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L17
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L1a
            int r1 = r5.d     // Catch: java.lang.Throwable -> L17
            if (r1 != 0) goto L1c
            goto L1a
        L17:
            r6 = move-exception
            goto L82
        L1a:
            r1 = 1
            goto L1d
        L1c:
            r1 = r2
        L1d:
            if (r1 == 0) goto L7a
            int r1 = r5.d     // Catch: java.lang.Throwable -> L17
            if (r1 <= r6) goto L78
            NJ0 r1 = r5.b     // Catch: java.lang.Throwable -> L17
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L17
            boolean r1 = r1.isEmpty()     // Catch: java.lang.Throwable -> L17
            if (r1 == 0) goto L2e
            goto L78
        L2e:
            NJ0 r1 = r5.b     // Catch: java.lang.Throwable -> L17
            java.util.LinkedHashMap r1 = r1.a     // Catch: java.lang.Throwable -> L17
            java.util.Set r1 = r1.entrySet()     // Catch: java.lang.Throwable -> L17
            boolean r3 = r1 instanceof java.util.List     // Catch: java.lang.Throwable -> L17
            r4 = 0
            if (r3 == 0) goto L49
            java.util.List r1 = (java.util.List) r1     // Catch: java.lang.Throwable -> L17
            boolean r3 = r1.isEmpty()     // Catch: java.lang.Throwable -> L17
            if (r3 == 0) goto L44
            goto L58
        L44:
            java.lang.Object r4 = r1.get(r2)     // Catch: java.lang.Throwable -> L17
            goto L58
        L49:
            java.util.Iterator r1 = r1.iterator()     // Catch: java.lang.Throwable -> L17
            boolean r2 = r1.hasNext()     // Catch: java.lang.Throwable -> L17
            if (r2 != 0) goto L54
            goto L58
        L54:
            java.lang.Object r4 = r1.next()     // Catch: java.lang.Throwable -> L17
        L58:
            java.util.Map$Entry r4 = (java.util.Map.Entry) r4     // Catch: java.lang.Throwable -> L17
            if (r4 != 0) goto L5e
            monitor-exit(r0)
            return
        L5e:
            java.lang.Object r1 = r4.getKey()     // Catch: java.lang.Throwable -> L17
            java.lang.Object r2 = r4.getValue()     // Catch: java.lang.Throwable -> L17
            NJ0 r3 = r5.b     // Catch: java.lang.Throwable -> L17
            java.util.LinkedHashMap r3 = r3.a     // Catch: java.lang.Throwable -> L17
            r3.remove(r1)     // Catch: java.lang.Throwable -> L17
            int r3 = r5.d     // Catch: java.lang.Throwable -> L17
            int r1 = r5.e(r1, r2)     // Catch: java.lang.Throwable -> L17
            int r3 = r3 - r1
            r5.d = r3     // Catch: java.lang.Throwable -> L17
            monitor-exit(r0)
            goto L0
        L78:
            monitor-exit(r0)
            return
        L7a:
            java.lang.String r6 = "LruCache.sizeOf() is reporting inconsistent results!"
            java.lang.IllegalStateException r1 = new java.lang.IllegalStateException     // Catch: java.lang.Throwable -> L17
            r1.<init>(r6)     // Catch: java.lang.Throwable -> L17
            throw r1     // Catch: java.lang.Throwable -> L17
        L82:
            monitor-exit(r0)
            throw r6
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.MJ0.g(int):void");
    }

    public final String toString() {
        String str;
        synchronized (this.c) {
            try {
                int i = this.e;
                int i2 = this.f + i;
                str = "LruCache[maxSize=" + this.a + ",hits=" + this.e + ",misses=" + this.f + ",hitRate=" + (i2 != 0 ? (i * 100) / i2 : 0) + "%]";
            } catch (Throwable th) {
                throw th;
            }
        }
        return str;
    }
}
