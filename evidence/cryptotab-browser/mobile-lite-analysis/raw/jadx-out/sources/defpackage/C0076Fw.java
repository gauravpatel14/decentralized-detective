package defpackage;

import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: renamed from: Fw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0076Fw {
    public final ReentrantReadWriteLock a = new ReentrantReadWriteLock(false);
    public HashMap b = new HashMap();
    public final AtomicInteger c = new AtomicInteger();
    public ArrayList d = new ArrayList();
    public int e;
    public VW0 f;

    /* JADX WARN: Removed duplicated region for block: B:23:0x0068 A[Catch: all -> 0x0095, TRY_LEAVE, TryCatch #0 {all -> 0x0095, blocks: (B:13:0x0036, B:15:0x003a, B:17:0x0044, B:19:0x004e, B:20:0x0052, B:21:0x0062, B:23:0x0068, B:26:0x0073), top: B:44:0x0036 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct add '--show-bad-code' argument
    */
    public final void a(int r10, java.lang.String r11, int r12, int r13, int r14, int r15) {
        /*
            r9 = this;
            java.util.concurrent.locks.ReentrantReadWriteLock r0 = r9.a
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            r1.lock()
            VW0 r1 = r9.f     // Catch: java.lang.Throwable -> L19
            if (r1 == 0) goto L1c
            r9.d(r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> L19
        L10:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r10 = r0.readLock()
            r10.unlock()
            goto La9
        L19:
            r10 = move-exception
            goto Laa
        L1c:
            java.util.HashMap r1 = r9.b     // Catch: java.lang.Throwable -> L19
            java.lang.Object r1 = r1.get(r11)     // Catch: java.lang.Throwable -> L19
            Dw r1 = (defpackage.C0051Dw) r1     // Catch: java.lang.Throwable -> L19
            java.util.concurrent.atomic.AtomicInteger r2 = r9.c
            if (r1 != 0) goto L9e
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()
            r1.unlock()
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r0.writeLock()
            r1.lock()
            VW0 r1 = r9.f     // Catch: java.lang.Throwable -> L95
            if (r1 != 0) goto L73
            java.util.HashMap r1 = r9.b     // Catch: java.lang.Throwable -> L95
            java.lang.Object r1 = r1.get(r11)     // Catch: java.lang.Throwable -> L95
            Dw r1 = (defpackage.C0051Dw) r1     // Catch: java.lang.Throwable -> L95
            if (r1 != 0) goto L62
            java.util.HashMap r1 = r9.b     // Catch: java.lang.Throwable -> L95
            int r1 = r1.size()     // Catch: java.lang.Throwable -> L95
            r3 = 256(0x100, float:3.59E-43)
            if (r1 < r3) goto L52
            r2.incrementAndGet()     // Catch: java.lang.Throwable -> L95
            goto L6b
        L52:
            Dw r1 = new Dw     // Catch: java.lang.Throwable -> L95
            r3 = r1
            r4 = r10
            r5 = r13
            r6 = r14
            r7 = r15
            r8 = r11
            r3.<init>(r4, r5, r6, r7, r8)     // Catch: java.lang.Throwable -> L95
            java.util.HashMap r10 = r9.b     // Catch: java.lang.Throwable -> L95
            r10.put(r11, r1)     // Catch: java.lang.Throwable -> L95
        L62:
            boolean r10 = r1.a(r12)     // Catch: java.lang.Throwable -> L95
            if (r10 != 0) goto L6b
            r2.incrementAndGet()     // Catch: java.lang.Throwable -> L95
        L6b:
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r10 = r0.writeLock()
            r10.unlock()
            return
        L73:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r1 = r0.readLock()     // Catch: java.lang.Throwable -> L95
            r1.lock()     // Catch: java.lang.Throwable -> L95
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r1 = r0.writeLock()
            r1.unlock()
            r9.d(r10, r11, r12, r13, r14, r15)     // Catch: java.lang.Throwable -> L8c
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r10 = r0.readLock()
            r10.unlock()
            return
        L8c:
            r10 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r11 = r0.readLock()
            r11.unlock()
            throw r10
        L95:
            r10 = move-exception
            java.util.concurrent.locks.ReentrantReadWriteLock$WriteLock r11 = r0.writeLock()
            r11.unlock()
            throw r10
        L9e:
            boolean r10 = r1.a(r12)     // Catch: java.lang.Throwable -> L19
            if (r10 != 0) goto L10
            r2.incrementAndGet()     // Catch: java.lang.Throwable -> L19
            goto L10
        La9:
            return
        Laa:
            java.util.concurrent.locks.ReentrantReadWriteLock$ReadLock r11 = r0.readLock()
            r11.unlock()
            throw r10
        */
        throw new UnsupportedOperationException("Method not decompiled: defpackage.C0076Fw.a(int, java.lang.String, int, int, int, int):void");
    }

    public final void b(Map map, int i) {
        int size;
        int size2 = map.size();
        int i2 = 0;
        for (C0051Dw c0051Dw : map.values()) {
            VW0 vw0 = this.f;
            synchronized (c0051Dw) {
                try {
                    int i3 = c0051Dw.a;
                    if (i3 == 1) {
                        for (int i4 = 0; i4 < c0051Dw.f.size(); i4++) {
                            vw0.c(c0051Dw.b, ((Integer) c0051Dw.f.get(i4)).intValue() != 0);
                        }
                    } else if (i3 == 2) {
                        for (int i5 = 0; i5 < c0051Dw.f.size(); i5++) {
                            vw0.d(((Integer) c0051Dw.f.get(i5)).intValue(), c0051Dw.c, c0051Dw.d, c0051Dw.e, c0051Dw.b);
                        }
                    } else if (i3 == 3) {
                        for (int i6 = 0; i6 < c0051Dw.f.size(); i6++) {
                            vw0.e(((Integer) c0051Dw.f.get(i6)).intValue(), c0051Dw.c, c0051Dw.d, c0051Dw.e, c0051Dw.b);
                        }
                    } else if (i3 == 4) {
                        for (int i7 = 0; i7 < c0051Dw.f.size(); i7++) {
                            vw0.f(((Integer) c0051Dw.f.get(i7)).intValue(), c0051Dw.b);
                        }
                    }
                    size = c0051Dw.f.size();
                    c0051Dw.f.clear();
                } catch (Throwable th) {
                    throw th;
                }
            }
            i2 += size;
        }
        Log.i("cr_CachingUmaRecorder", "Flushed " + i2 + " samples from " + size2 + " histograms, " + i + " samples were dropped.");
    }

    public final void c(int i, List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            Ew ew = (Ew) it.next();
            this.f.g(ew.b, ew.a);
        }
        Log.i("cr_CachingUmaRecorder", "Flushed " + list.size() + " user action samples, " + i + " samples were dropped.");
    }

    public final void d(int i, String str, int i2, int i3, int i4, int i5) {
        if (i == 1) {
            this.f.c(str, i2 != 0);
            return;
        }
        if (i == 2) {
            this.f.d(i2, i3, i4, i5, str);
        } else if (i == 3) {
            this.f.e(i2, i3, i4, i5, str);
        } else {
            if (i != 4) {
                throw new UnsupportedOperationException(AbstractC1214oR1.a(i, "Unknown histogram type "));
            }
            this.f.f(i2, str);
        }
    }
}
