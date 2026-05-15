package defpackage;

import com.google.android.gms.common.api.internal.BackgroundDetector;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.concurrent.atomic.AtomicReference;

/* JADX INFO: renamed from: Ze0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0311Ze0 implements BackgroundDetector.BackgroundStateChangeListener {
    public static final AtomicReference a = new AtomicReference();

    @Override // com.google.android.gms.common.api.internal.BackgroundDetector.BackgroundStateChangeListener
    public final void onBackgroundStateChanged(boolean z) {
        synchronized (C0488cf0.j) {
            try {
                for (C0488cf0 c0488cf0 : new ArrayList(C0488cf0.l.values())) {
                    if (c0488cf0.e.get()) {
                        Iterator it = c0488cf0.i.iterator();
                        while (it.hasNext()) {
                            C0488cf0 c0488cf02 = ((Ye0) it.next()).a;
                            if (z) {
                                c0488cf02.getClass();
                            } else {
                                ((RV) c0488cf02.h.get()).b();
                            }
                        }
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
