package defpackage;

import android.os.Message;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.HashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class gP0 {
    public final XO0 a;
    public final int b;
    public final boolean c;
    public final C0838iP0 d;
    public final C0838iP0 e;
    public final C0838iP0 f;
    public final ArrayList g;
    public final WeakReference h;
    public boolean i = false;
    public boolean j = false;

    public gP0(bm0 bm0Var, C0838iP0 c0838iP0, XO0 xo0, int i, boolean z, C0838iP0 c0838iP02, ArrayList arrayList) {
        this.h = new WeakReference(bm0Var);
        this.e = c0838iP0;
        this.a = xo0;
        this.b = i;
        this.c = z;
        this.d = bm0Var.c;
        this.f = c0838iP02;
        this.g = arrayList == null ? null : new ArrayList(arrayList);
        bm0Var.a.postDelayed(new Runnable() { // from class: fP0
            @Override // java.lang.Runnable
            public final void run() {
                this.t.a();
            }
        }, 15000L);
    }

    public final void a() {
        C1087mP0.b();
        if (this.i || this.j) {
            return;
        }
        WeakReference weakReference = this.h;
        bm0 bm0Var = (bm0) weakReference.get();
        XO0 xo0 = this.a;
        if (bm0Var == null || bm0Var.e != this) {
            if (this.i || this.j) {
                return;
            }
            this.j = true;
            if (xo0 != null) {
                xo0.h(0);
                xo0.d();
                return;
            }
            return;
        }
        this.i = true;
        bm0Var.e = null;
        bm0 bm0Var2 = (bm0) weakReference.get();
        int i = this.b;
        C0838iP0 c0838iP0 = this.d;
        if (bm0Var2 != null && bm0Var2.c == c0838iP0) {
            Message messageObtainMessage = bm0Var2.a.obtainMessage(263, c0838iP0);
            messageObtainMessage.arg1 = i;
            messageObtainMessage.sendToTarget();
            XO0 xo02 = bm0Var2.d;
            if (xo02 != null) {
                xo02.h(i);
                bm0Var2.d.d();
            }
            HashMap map = bm0Var2.b;
            if (!map.isEmpty()) {
                for (XO0 xo03 : map.values()) {
                    xo03.h(i);
                    xo03.d();
                }
                map.clear();
            }
            bm0Var2.d = null;
        }
        bm0 bm0Var3 = (bm0) weakReference.get();
        if (bm0Var3 == null) {
            return;
        }
        C0838iP0 c0838iP02 = this.e;
        bm0Var3.c = c0838iP02;
        bm0Var3.d = xo0;
        boolean z = this.c;
        Wl0 wl0 = bm0Var3.a;
        C0838iP0 c0838iP03 = this.f;
        if (c0838iP03 == null) {
            wl0.getClass();
            Message messageObtainMessage2 = wl0.obtainMessage(262, new am0(c0838iP0, c0838iP02, z));
            messageObtainMessage2.arg1 = i;
            messageObtainMessage2.sendToTarget();
        } else {
            wl0.getClass();
            Message messageObtainMessage3 = wl0.obtainMessage(264, new am0(c0838iP03, c0838iP02, z));
            messageObtainMessage3.arg1 = i;
            messageObtainMessage3.sendToTarget();
        }
        bm0Var3.b.clear();
        bm0Var3.f();
        bm0Var3.j();
        ArrayList arrayList = this.g;
        if (arrayList != null) {
            bm0Var3.c.l(arrayList);
        }
    }
}
