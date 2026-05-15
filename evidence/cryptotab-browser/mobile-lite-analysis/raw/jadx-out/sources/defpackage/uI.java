package defpackage;

import java.util.ArrayList;
import org.chromium.base.Callback;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class uI extends Wu {
    public final boolean y = true;
    public final ArrayList w = new ArrayList();
    public final tI x = new Callback() { // from class: tI
        @Override // org.chromium.base.Callback
        /* JADX INFO: renamed from: onResult */
        public final void a0(Object obj) {
            uI uIVar = this.t;
            super/*Wu*/.d(Integer.valueOf(uIVar.r()));
        }
    };

    /* JADX WARN: Type inference failed for: r0v2, types: [tI] */
    public uI(Wu... wuArr) {
        for (Wu wu : wuArr) {
            this.w.add(wu);
            wu.k(this.x);
        }
        super.d(Integer.valueOf(r()));
    }

    @Override // defpackage.H21
    /* JADX INFO: renamed from: g, reason: merged with bridge method [inline-methods] */
    public final void d(Integer num) {
        if (this.y) {
            throw new IllegalStateException("Calling set on the composed delegate is not allowed.");
        }
        super.d(num);
    }

    public final int r() {
        int i = 0;
        boolean z = false;
        while (true) {
            ArrayList arrayList = this.w;
            if (i >= arrayList.size()) {
                return z ? 1 : 3;
            }
            Wu wu = (Wu) arrayList.get(i);
            wu.getClass();
            int i2 = AbstractC1872zv.a;
            int iIntValue = ((Integer) wu.u).intValue();
            if (iIntValue == 2) {
                return 2;
            }
            z |= iIntValue == 1;
            i++;
        }
    }
}
