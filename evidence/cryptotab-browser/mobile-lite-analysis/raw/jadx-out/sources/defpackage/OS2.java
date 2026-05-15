package defpackage;

import android.database.ContentObserver;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class OS2 extends ContentObserver {
    public final /* synthetic */ SS2 a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public OS2(SS2 ss2) {
        super(null);
        this.a = ss2;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        SS2 ss2 = this.a;
        synchronized (ss2.d) {
            ss2.e = null;
            LT2.h.incrementAndGet();
        }
        synchronized (ss2) {
            try {
                Iterator it = ss2.f.iterator();
                if (it.hasNext()) {
                    if (it.next() != null) {
                        throw new ClassCastException();
                    }
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
