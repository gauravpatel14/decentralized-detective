package defpackage;

import androidx.concurrent.futures.CallbackToFutureAdapter$FutureGarbageCollectedException;

/* JADX INFO: renamed from: bx, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0440bx {
    public Object a;
    public C0611ex b;
    public Wu1 c;
    public boolean d;

    public final void a(Object obj) {
        this.d = true;
        C0611ex c0611ex = this.b;
        if (c0611ex != null) {
            dx dxVar = c0611ex.u;
            dxVar.getClass();
            if (obj == null) {
                obj = N.y;
            }
            if (N.x.b(dxVar, null, obj)) {
                N.c(dxVar);
                this.a = null;
                this.b = null;
                this.c = null;
            }
        }
    }

    public final void finalize() {
        Wu1 wu1;
        C0611ex c0611ex = this.b;
        if (c0611ex != null) {
            dx dxVar = c0611ex.u;
            if (!dxVar.isDone()) {
                dxVar.h(new CallbackToFutureAdapter$FutureGarbageCollectedException("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.a));
            }
        }
        if (this.d || (wu1 = this.c) == null) {
            return;
        }
        wu1.i(null);
    }
}
