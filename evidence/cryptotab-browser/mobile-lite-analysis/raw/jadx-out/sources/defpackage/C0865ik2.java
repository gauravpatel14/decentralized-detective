package defpackage;

import android.os.Handler;
import android.os.Looper;
import java.lang.ref.WeakReference;
import java.util.HashMap;

/* JADX INFO: renamed from: ik2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0865ik2 {
    public final C0589eX a;
    public Handler b;
    public HashMap c;

    public C0865ik2() {
        Looper looperMyLooper = Looper.myLooper();
        if (looperMyLooper == null) {
            throw new IllegalStateException();
        }
        Handler handler = new Handler(looperMyLooper);
        int i = AbstractC1872zv.a;
        this.a = new C0589eX();
        this.c = new HashMap();
        this.b = handler;
    }

    public final InterfaceC0732gk2 a(C0927jk2 c0927jk2) {
        int i = AbstractC1872zv.a;
        this.a.getClass();
        WeakReference weakReference = (WeakReference) this.c.get(c0927jk2);
        if (weakReference == null) {
            return null;
        }
        InterfaceC0732gk2 interfaceC0732gk2 = (InterfaceC0732gk2) weakReference.get();
        if (interfaceC0732gk2 != null) {
            return (InterfaceC0732gk2) c0927jk2.a.cast(interfaceC0732gk2);
        }
        c0927jk2.c(this);
        return null;
    }
}
