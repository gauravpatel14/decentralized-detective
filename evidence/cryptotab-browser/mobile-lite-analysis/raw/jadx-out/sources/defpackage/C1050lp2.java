package defpackage;

import android.view.View;
import java.lang.ref.WeakReference;

/* JADX INFO: renamed from: lp2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1050lp2 {
    public final WeakReference a;

    public C1050lp2(View view) {
        this.a = new WeakReference(view);
    }

    public final void a(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().alpha(f);
        }
    }

    public final void b() {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().cancel();
        }
    }

    public final void c(long j) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().setDuration(j);
        }
    }

    public final void d(InterfaceC1236op2 interfaceC1236op2) {
        View view = (View) this.a.get();
        if (view != null) {
            if (interfaceC1236op2 != null) {
                view.animate().setListener(new C0990kp2(interfaceC1236op2, view));
            } else {
                view.animate().setListener(null);
            }
        }
    }

    public final void e(float f) {
        View view = (View) this.a.get();
        if (view != null) {
            view.animate().translationY(f);
        }
    }
}
