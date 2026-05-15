package defpackage;

import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Objects;
import org.chromium.base.Callback;

/* JADX INFO: renamed from: ax, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0384ax {
    public ArrayList a = new ArrayList();

    public final synchronized void a() {
        try {
            Objects.requireNonNull(this.a);
            Iterator it = LG.d(this.a).iterator();
            while (it.hasNext()) {
                ((Xw) it.next()).cancel();
            }
            this.a = null;
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized Yw b(Callback callback) {
        Yw yw;
        Objects.requireNonNull(this.a);
        yw = new Yw(this, callback);
        ArrayList arrayList = this.a;
        arrayList.add(new WeakReference(yw));
        if (arrayList.size() % 1024 == 0) {
            LG.d(arrayList);
        }
        return yw;
    }

    public final synchronized Zw c(Runnable runnable) {
        Zw zw;
        Objects.requireNonNull(this.a);
        zw = new Zw(this, runnable);
        ArrayList arrayList = this.a;
        arrayList.add(new WeakReference(zw));
        if (arrayList.size() % 1024 == 0) {
            LG.d(arrayList);
        }
        return zw;
    }
}
