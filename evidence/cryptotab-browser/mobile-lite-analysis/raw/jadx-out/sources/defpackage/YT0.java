package defpackage;

import java.util.Iterator;
import org.chromium.base.Callback;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final /* synthetic */ class YT0 implements Callback {
    public final /* synthetic */ int t;
    public final /* synthetic */ bU0 u;
    public final /* synthetic */ PropertyModel v;

    public /* synthetic */ YT0(bU0 bu0, PropertyModel propertyModel, int i) {
        this.t = i;
        this.u = bu0;
        this.v = propertyModel;
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        switch (this.t) {
            case 0:
                bU0 bu0 = this.u;
                bu0.getClass();
                bu0.c(((Integer) obj).intValue(), this.v);
                break;
            default:
                lI lIVar = (lI) obj;
                Iterator it = this.u.h.iterator();
                while (true) {
                    L21 l21 = (L21) it;
                    if (l21.hasNext()) {
                        ((ZT0) l21.next()).e(this.v, lIVar);
                    }
                    break;
                }
                break;
        }
    }
}
