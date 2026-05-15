package defpackage;

import J.N;
import java.util.concurrent.atomic.AtomicBoolean;
import org.chromium.base.TraceEvent;
import org.chromium.base.task.PostTask;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class RE0 {
    public static final AtomicBoolean a = new AtomicBoolean();

    public static void a() {
        N._V(3);
        final boolean zCompareAndSet = a.compareAndSet(false, true);
        if (zCompareAndSet && CH.c().e("log-native-library-residency")) {
            new Thread(new PE0()).start();
        } else {
            PostTask.c(4, new Runnable() { // from class: QE0
                @Override // java.lang.Runnable
                public final void run() {
                    int i_I = N._I(1);
                    TraceEvent traceEventJ = TraceEvent.j("LibraryPrefetcher.asyncPrefetchLibrariesToMemory", Integer.toString(i_I));
                    if (zCompareAndSet && i_I < 90) {
                        try {
                            N._V(6);
                        } catch (Throwable th) {
                            if (traceEventJ != null) {
                                try {
                                    traceEventJ.close();
                                } catch (Throwable unused) {
                                }
                            }
                            throw th;
                        }
                    }
                    if (traceEventJ != null) {
                        traceEventJ.close();
                    }
                    AbstractC1440sM.a.edit().remove("dont_prefetch_libraries").apply();
                }
            });
        }
    }
}
