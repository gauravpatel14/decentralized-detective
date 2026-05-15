package defpackage;

import androidx.recyclerview.widget.RecyclerView;
import java.util.ArrayList;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class is1 extends AbstractC0212Rr1 {
    public final /* synthetic */ RecyclerView a;

    public is1(RecyclerView recyclerView) {
        this.a = recyclerView;
    }

    @Override // defpackage.AbstractC0212Rr1
    public final void a() {
        RecyclerView recyclerView = this.a;
        recyclerView.l(null);
        recyclerView.B0.f = true;
        recyclerView.f0(true);
        if (recyclerView.x.g()) {
            return;
        }
        recyclerView.requestLayout();
    }

    @Override // defpackage.AbstractC0212Rr1
    public final void c(int i, int i2, Object obj) {
        RecyclerView recyclerView = this.a;
        recyclerView.l(null);
        T4 t4 = recyclerView.x;
        if (i2 < 1) {
            t4.getClass();
            return;
        }
        ArrayList arrayList = t4.b;
        arrayList.add(t4.h(4, i, i2, obj));
        t4.f |= 4;
        if (arrayList.size() == 1) {
            g();
        }
    }

    @Override // defpackage.AbstractC0212Rr1
    public final void d(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.l(null);
        T4 t4 = recyclerView.x;
        if (i2 < 1) {
            t4.getClass();
            return;
        }
        ArrayList arrayList = t4.b;
        arrayList.add(t4.h(1, i, i2, null));
        t4.f |= 1;
        if (arrayList.size() == 1) {
            g();
        }
    }

    @Override // defpackage.AbstractC0212Rr1
    public final void e(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.l(null);
        T4 t4 = recyclerView.x;
        t4.getClass();
        if (i == i2) {
            return;
        }
        ArrayList arrayList = t4.b;
        arrayList.add(t4.h(8, i, i2, null));
        t4.f |= 8;
        if (arrayList.size() == 1) {
            g();
        }
    }

    @Override // defpackage.AbstractC0212Rr1
    public final void f(int i, int i2) {
        RecyclerView recyclerView = this.a;
        recyclerView.l(null);
        T4 t4 = recyclerView.x;
        if (i2 < 1) {
            t4.getClass();
            return;
        }
        ArrayList arrayList = t4.b;
        arrayList.add(t4.h(2, i, i2, null));
        t4.f |= 2;
        if (arrayList.size() == 1) {
            g();
        }
    }

    public final void g() {
        RecyclerView recyclerView = this.a;
        if (recyclerView.N && recyclerView.M) {
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            recyclerView.postOnAnimation(recyclerView.B);
        } else {
            recyclerView.U = true;
            recyclerView.requestLayout();
        }
    }
}
