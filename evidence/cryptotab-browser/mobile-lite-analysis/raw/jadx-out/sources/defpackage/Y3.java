package defpackage;

import android.R;
import android.app.Activity;
import android.view.View;
import java.lang.ref.WeakReference;
import java.util.Iterator;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class Y3 extends GC0 implements View.OnLayoutChangeListener {
    public final X3 v = new Callback() { // from class: X3
        @Override // org.chromium.base.Callback
        /* JADX INFO: renamed from: onResult */
        public final void a0(Object obj) {
            int iIntValue = ((Integer) obj).intValue();
            Y3 y3 = this.t;
            y3.getClass();
            y3.i(iIntValue > 0);
        }
    };
    public final WeakReference w;
    public C1370rE0 x;
    public boolean y;

    /* JADX WARN: Type inference failed for: r0v0, types: [X3] */
    public Y3(WeakReference weakReference) {
        this.w = weakReference;
    }

    @Override // defpackage.GC0
    public final void e() {
        Activity activity = (Activity) this.w.get();
        if (activity == null) {
            return;
        }
        View viewFindViewById = activity.findViewById(R.id.content);
        this.y = d(viewFindViewById);
        viewFindViewById.addOnLayoutChangeListener(this);
        C1370rE0 c1370rE0 = this.x;
        if (c1370rE0 == null) {
            return;
        }
        ((F21) c1370rE0.b()).k(this.v);
    }

    @Override // defpackage.GC0
    public final void h() {
        Activity activity = (Activity) this.w.get();
        if (activity == null) {
            return;
        }
        activity.findViewById(R.id.content).removeOnLayoutChangeListener(this);
        C1370rE0 c1370rE0 = this.x;
        if (c1370rE0 == null) {
            return;
        }
        ((F21) c1370rE0.b()).b(this.v);
    }

    public final void i(boolean z) {
        if (this.y == z) {
            return;
        }
        this.y = z;
        Iterator it = this.t.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                return;
            } else {
                ((FC0) l21.next()).a(z);
            }
        }
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        Activity activity = (Activity) this.w.get();
        if (activity == null) {
            return;
        }
        i(d(activity.findViewById(R.id.content)));
    }
}
