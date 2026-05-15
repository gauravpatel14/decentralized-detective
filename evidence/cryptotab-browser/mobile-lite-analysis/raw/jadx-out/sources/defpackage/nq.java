package defpackage;

import J.N;
import android.graphics.Bitmap;
import android.graphics.Rect;
import java.util.Iterator;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class nq implements b50 {
    public final int t;
    public Bitmap u;
    public final Rect v = new Rect();
    public final M21 w = new M21();

    public nq(int i) {
        this.t = i;
    }

    @Override // defpackage.b50
    public final void a() {
        Bitmap bitmap;
        M21 m21 = this.w;
        if (m21.isEmpty() || (bitmap = this.u) == null) {
            return;
        }
        g50 g50Var = new g50(bitmap, this.v, N._J(26));
        Iterator it = m21.iterator();
        while (true) {
            L21 l21 = (L21) it;
            if (!l21.hasNext()) {
                this.u = null;
                return;
            }
            ((Callback) l21.next()).a0(g50Var);
        }
    }

    @Override // defpackage.b50
    public final void b(Callback callback) {
        this.w.e(callback);
    }

    @Override // defpackage.b50
    public final void c(Callback callback) {
        this.w.g(callback);
    }

    public final void d(Bitmap bitmap) {
        if (bitmap == null) {
            return;
        }
        this.u = bitmap;
        this.v.set(0, 0, bitmap.getWidth(), this.u.getHeight());
    }
}
