package defpackage;

import java.util.ArrayList;
import java.util.Iterator;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PT1 implements RR1 {
    public ArrayList t;
    public Object u;

    public PT1() {
        int i = AbstractC1872zv.a;
    }

    public final void a(Object obj) {
        int i = AbstractC1872zv.a;
        this.u = obj;
        ArrayList arrayList = this.t;
        if (arrayList == null) {
            return;
        }
        Iterator it = arrayList.iterator();
        while (it.hasNext()) {
            ((Callback) it.next()).a0(obj);
        }
        this.t = null;
    }

    @Override // java.util.function.Supplier
    public final Object get() {
        int i = AbstractC1872zv.a;
        return this.u;
    }

    public final Object p(Callback callback) {
        int i = AbstractC1872zv.a;
        Object obj = this.u;
        if (obj != null) {
            callback.a0(obj);
        } else {
            if (this.t == null) {
                this.t = new ArrayList();
            }
            this.t.add(callback);
        }
        return obj;
    }
}
