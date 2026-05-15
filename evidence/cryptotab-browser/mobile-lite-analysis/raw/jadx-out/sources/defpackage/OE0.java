package defpackage;

import J.N;
import android.content.pm.ApplicationInfo;
import android.os.SystemClock;
import android.util.Log;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.atomic.AtomicReference;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import org.chromium.base.TraceEvent;
import org.chromium.base.library_loader.ProcessInitException;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OE0 {
    public static final OE0 h = new OE0();
    public static PM1 i;
    public volatile boolean a;
    public volatile int b;
    public int c;
    public final NE0 d = new NE0(this);
    public final Object e = new Object();
    public boolean f;
    public boolean g;

    public OE0() {
        int i2 = AbstractC1872zv.a;
    }

    public final void a() {
        if (d()) {
            return;
        }
        b();
        this.b = 2;
    }

    public final void b() {
        synchronized (this.e) {
            e(AbstractC1499tM.a.getApplicationInfo(), false);
            c();
        }
    }

    public final void c() {
        int andSet;
        HashMap map;
        String[] strArr;
        if (this.a) {
            return;
        }
        int i2 = 0;
        if (this.c == 1) {
            LP1 lp1C = LP1.c();
            try {
                boolean z = AbstractC1440sM.a.getBoolean("background_thread_pool_enabled", false);
                lp1C.close();
                if (z) {
                    CH.c().a("enable-background-thread-pool");
                }
            } catch (Throwable th) {
                try {
                    lp1C.close();
                } catch (Throwable unused) {
                }
                throw th;
            }
        }
        if (!this.g) {
            AtomicReference atomicReference = CH.a;
            AH ah = (AH) atomicReference.get();
            if (ah == null) {
                strArr = new String[0];
            } else {
                ArrayList arrayList = ah.c;
                strArr = (String[]) arrayList.toArray(new String[arrayList.size()]);
            }
            N._V_O(2, strArr);
            atomicReference.set(new BH());
            int i3 = AbstractC1872zv.a;
            this.g = true;
        }
        if (!N._Z_I(0, this.c)) {
            Log.e("cr_LibraryLoader", "error calling LibraryLoaderJni.get().libraryLoaded");
            throw new ProcessInitException(1);
        }
        Log.i("cr_LibraryLoader", "Successfully loaded native library");
        if (Aj2.b) {
            VW0 vw0 = new VW0();
            C0076Fw c0076Fw = Aj2.a;
            ReentrantReadWriteLock reentrantReadWriteLock = c0076Fw.a;
            reentrantReadWriteLock.writeLock().lock();
            try {
                c0076Fw.f = vw0;
                int i4 = AbstractC1872zv.a;
                ArrayList arrayList2 = null;
                if (c0076Fw.b.isEmpty()) {
                    andSet = 0;
                    map = null;
                } else {
                    map = c0076Fw.b;
                    c0076Fw.b = new HashMap();
                    andSet = c0076Fw.c.getAndSet(0);
                }
                if (!c0076Fw.d.isEmpty()) {
                    arrayList2 = c0076Fw.d;
                    c0076Fw.d = new ArrayList();
                    int i5 = c0076Fw.e;
                    c0076Fw.e = 0;
                    i2 = i5;
                }
                reentrantReadWriteLock.readLock().lock();
                reentrantReadWriteLock.writeLock().unlock();
                if (map != null) {
                    try {
                        c0076Fw.b(map, andSet);
                    } catch (Throwable th2) {
                        reentrantReadWriteLock.readLock().unlock();
                        throw th2;
                    }
                }
                if (arrayList2 != null) {
                    c0076Fw.c(i2, arrayList2);
                }
                reentrantReadWriteLock.readLock().unlock();
            } catch (Throwable th3) {
                reentrantReadWriteLock.writeLock().unlock();
                throw th3;
            }
        }
        N._V(5);
        this.a = true;
    }

    public final boolean d() {
        return this.a && this.b == 2;
    }

    public final void e(ApplicationInfo applicationInfo, boolean z) {
        if (this.b >= 1) {
            return;
        }
        try {
            TraceEvent traceEventJ = TraceEvent.j("LibraryLoader.loadMainDexAlreadyLocked", null);
            try {
                long jUptimeMillis = SystemClock.uptimeMillis();
                long jCurrentThreadTimeMillis = SystemClock.currentThreadTimeMillis();
                String[] strArr = GW0.a;
                int i2 = AbstractC1872zv.a;
                String str = applicationInfo.packageName;
                TraceEvent traceEventJ2 = TraceEvent.j("LibraryLoader.preloadAlreadyLocked", null);
                if (traceEventJ2 != null) {
                    traceEventJ2.close();
                }
                System.loadLibrary(strArr[0]);
                long jUptimeMillis2 = SystemClock.uptimeMillis() - jUptimeMillis;
                this.b = 1;
                int i3 = this.d.b;
                Gr1.n(jUptimeMillis2, "ChromiumAndroidLinker." + (i3 != 0 ? i3 != 1 ? i3 != 2 ? "" : "Child" : "Zygote" : "Browser") + "LoadTime2");
                NE0 ne0 = this.d;
                long jCurrentThreadTimeMillis2 = SystemClock.currentThreadTimeMillis() - jCurrentThreadTimeMillis;
                int i4 = ne0.b;
                Gr1.n(jCurrentThreadTimeMillis2, "ChromiumAndroidLinker." + (i4 != 0 ? i4 != 1 ? i4 != 2 ? "" : "Child" : "Zygote" : "Browser") + "ThreadLoadTime");
                if (traceEventJ != null) {
                    traceEventJ.close();
                }
            } catch (Throwable th) {
                if (traceEventJ != null) {
                    try {
                        traceEventJ.close();
                    } catch (Throwable unused) {
                    }
                }
                throw th;
            }
        } catch (UnsatisfiedLinkError e) {
            PM1 pm1 = i;
            if (pm1 == null) {
                throw new ProcessInitException(2, e);
            }
            pm1.a0(e);
            throw null;
        }
    }

    public final void f(int i2) {
        int i3 = this.c;
        if (i2 == i3) {
            return;
        }
        if (i3 != 0) {
            throw new IllegalStateException(String.format("Trying to change the LibraryProcessType from %d to %d", Integer.valueOf(this.c), Integer.valueOf(i2)));
        }
        this.c = i2;
    }
}
