package defpackage;

import android.os.SystemClock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Hr1 {
    public static void a(String str) {
        C0076Fw c0076Fw = Aj2.a;
        long jElapsedRealtime = SystemClock.elapsedRealtime();
        ReentrantReadWriteLock reentrantReadWriteLock = c0076Fw.a;
        reentrantReadWriteLock.readLock().lock();
        try {
            VW0 vw0 = c0076Fw.f;
            if (vw0 != null) {
                vw0.g(jElapsedRealtime, str);
                return;
            }
            reentrantReadWriteLock.readLock().unlock();
            reentrantReadWriteLock.writeLock().lock();
            try {
                if (c0076Fw.f == null) {
                    if (c0076Fw.d.size() < 256) {
                        c0076Fw.d.add(new Ew(str, jElapsedRealtime));
                    } else {
                        c0076Fw.e++;
                    }
                    reentrantReadWriteLock.writeLock().unlock();
                    return;
                }
                reentrantReadWriteLock.readLock().lock();
                reentrantReadWriteLock.writeLock().unlock();
                try {
                    c0076Fw.f.g(jElapsedRealtime, str);
                } finally {
                }
            } catch (Throwable th) {
                reentrantReadWriteLock.writeLock().unlock();
                throw th;
            }
        } finally {
        }
    }
}
