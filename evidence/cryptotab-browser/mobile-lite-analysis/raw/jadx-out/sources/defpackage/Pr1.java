package defpackage;

import android.os.Trace;
import android.view.ViewGroup;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class Pr1 {
    public final Qr1 t = new Qr1();
    public boolean u = false;
    public final int v = 1;

    public final ps1 a(int i, ViewGroup viewGroup) {
        try {
            if (AbstractC0368af2.a()) {
                Trace.beginSection(String.format("RV onCreateViewHolder type=0x%X", Integer.valueOf(i)));
            }
            ps1 ps1VarO = o(i, viewGroup);
            if (ps1VarO.t.getParent() != null) {
                throw new IllegalStateException("ViewHolder views must not be attached when created. Ensure that you are not passing 'true' to the attachToRoot parameter of LayoutInflater.inflate(..., boolean attachToRoot)");
            }
            ps1VarO.y = i;
            Trace.endSection();
            return ps1VarO;
        } catch (Throwable th) {
            Trace.endSection();
            throw th;
        }
    }

    public abstract int b();

    public long c(int i) {
        return -1L;
    }

    public int d(int i) {
        return 0;
    }

    public void f(int i, int i2) {
        k(i, i2);
    }

    public final void g() {
        this.t.b();
    }

    public final void i(int i, int i2) {
        this.t.e(i, i2);
    }

    public final void k(int i, int i2) {
        this.t.f(i, i2);
    }

    public abstract void m(ps1 ps1Var, int i);

    public void n(ps1 ps1Var, int i, List list) {
        m(ps1Var, i);
    }

    public abstract ps1 o(int i, ViewGroup viewGroup);

    public boolean q(ps1 ps1Var) {
        return false;
    }

    public final void t(AbstractC0212Rr1 abstractC0212Rr1) {
        this.t.registerObserver(abstractC0212Rr1);
    }

    public final void u(boolean z) {
        if (this.t.a()) {
            throw new IllegalStateException("Cannot change whether this adapter has stable IDs while the adapter has registered observers.");
        }
        this.u = z;
    }

    public final void v(AbstractC0212Rr1 abstractC0212Rr1) {
        this.t.unregisterObserver(abstractC0212Rr1);
    }

    public void l(RecyclerView recyclerView) {
    }

    public void p(RecyclerView recyclerView) {
    }

    public void r(ps1 ps1Var) {
    }

    public void s(ps1 ps1Var) {
    }
}
