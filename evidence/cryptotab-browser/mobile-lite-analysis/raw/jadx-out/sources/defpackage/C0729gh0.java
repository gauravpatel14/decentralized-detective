package defpackage;

import java.util.ArrayList;

/* JADX INFO: renamed from: gh0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0729gh0 implements QK {
    public final /* synthetic */ int t;
    public final /* synthetic */ Object u;

    public /* synthetic */ C0729gh0(int i, Object obj) {
        this.t = i;
        this.u = obj;
    }

    @Override // defpackage.QK
    public final void accept(Object obj) {
        switch (this.t) {
            case 0:
                C0795hh0 c0795hh0 = (C0795hh0) obj;
                if (c0795hh0 == null) {
                    c0795hh0 = new C0795hh0(-3);
                }
                ((ix) this.u).a(c0795hh0);
                return;
            default:
                C0795hh0 c0795hh02 = (C0795hh0) obj;
                synchronized (AbstractC0861ih0.c) {
                    try {
                        UJ1 uj1 = AbstractC0861ih0.d;
                        ArrayList arrayList = (ArrayList) uj1.get((String) this.u);
                        if (arrayList == null) {
                            return;
                        }
                        uj1.remove((String) this.u);
                        for (int i = 0; i < arrayList.size(); i++) {
                            ((QK) arrayList.get(i)).accept(c0795hh02);
                        }
                        return;
                    } finally {
                    }
                }
        }
    }
}
