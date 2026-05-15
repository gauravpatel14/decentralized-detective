package defpackage;

import java.util.ArrayList;
import java.util.concurrent.Executor;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class UO0 extends XO0 {
    public final Object a = new Object();
    public Executor b;
    public Vl0 c;
    public OO0 d;
    public ArrayList e;

    public final void j(OO0 oo0, ArrayList arrayList) {
        if (oo0 == null) {
            throw new NullPointerException("groupRoute must not be null");
        }
        synchronized (this.a) {
            try {
                Executor executor = this.b;
                if (executor != null) {
                    executor.execute(new SO0(this, this.c, oo0, arrayList, 1));
                } else {
                    this.d = oo0;
                    this.e = new ArrayList(arrayList);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
