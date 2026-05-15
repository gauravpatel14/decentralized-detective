package defpackage;

import android.util.SparseArray;
import org.chromium.base.TraceEvent;

/* JADX INFO: renamed from: Yf, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0299Yf extends AbstractC1103mg {
    public final int h;
    public final /* synthetic */ AbstractC0369ag i;

    public C0299Yf(AbstractC0369ag abstractC0369ag, int i) {
        this.i = abstractC0369ag;
        this.h = i;
    }

    @Override // defpackage.AbstractC1103mg
    public final Object b() {
        int i = this.h;
        AbstractC0369ag abstractC0369ag = this.i;
        abstractC0369ag.getClass();
        try {
            TraceEvent.a("AsyncPreloadResourceLoader.createResource", null);
            return abstractC0369ag.d.a(i);
        } finally {
            TraceEvent.b("AsyncPreloadResourceLoader.createResource");
        }
    }

    @Override // defpackage.AbstractC1103mg
    public final void k(Object obj) {
        Zu1 zu1 = (Zu1) obj;
        AbstractC0369ag abstractC0369ag = this.i;
        SparseArray sparseArray = abstractC0369ag.c;
        int i = this.h;
        if (sparseArray.get(i) == null) {
            return;
        }
        abstractC0369ag.b(i, zu1);
        abstractC0369ag.c.remove(i);
    }
}
