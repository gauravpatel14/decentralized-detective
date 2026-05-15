package defpackage;

import J.N;
import android.util.SparseArray;
import org.chromium.base.Callback;
import org.chromium.ui.resources.ResourceManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class e50 extends bv1 {
    public final SparseArray c;

    public e50(int i, ResourceManager resourceManager) {
        super(i, resourceManager);
        this.c = new SparseArray();
    }

    @Override // defpackage.bv1
    public final void a(int i) {
        d50 d50Var = (d50) this.c.get(i);
        if (d50Var == null) {
            return;
        }
        d50Var.a.a();
    }

    /* JADX WARN: Type inference failed for: r1v0, types: [c50] */
    public final void d(final int i, b50 b50Var) {
        this.c.put(i, new d50(b50Var, new Callback() { // from class: c50
            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                this.t.b(i, (Zu1) obj);
            }
        }));
    }

    public final void e(int i) {
        SparseArray sparseArray = this.c;
        d50 d50Var = (d50) sparseArray.get(i);
        if (d50Var == null) {
            return;
        }
        sparseArray.remove(i);
        d50Var.a.c(d50Var.b);
        ResourceManager resourceManager = this.b;
        int i2 = this.a;
        if (i2 == 2 || i2 == 1) {
            long j = resourceManager.d;
            if (j == 0) {
                return;
            }
            N._V_IIJO(13, i2, i, j, resourceManager);
        }
    }

    @Override // defpackage.bv1
    public final void c(int i) {
    }
}
