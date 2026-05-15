package defpackage;

import org.chromium.base.Callback;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class ZJ1 implements dU0 {
    public final bU0 t;
    public Callback u;

    public ZJ1(bU0 bu0, Callback callback) {
        this.t = bu0;
        this.u = callback;
    }

    @Override // defpackage.dU0
    public final void a(int i) {
        Callback callback = this.u;
        this.u = null;
        callback.a0(Integer.valueOf(i));
    }

    @Override // defpackage.dU0
    public final void b(int i, PropertyModel propertyModel) {
        bU0 bu0 = this.t;
        if (i == 0) {
            bu0.c(1, propertyModel);
        } else {
            bu0.c(2, propertyModel);
        }
    }
}
