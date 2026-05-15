package defpackage;

import android.util.SparseArray;
import java.util.concurrent.ExecutionException;
import org.chromium.base.TraceEvent;
import org.chromium.base.task.PostTask;
import org.chromium.ui.resources.ResourceManager;

/* JADX INFO: renamed from: ag, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0369ag extends bv1 {
    public final SparseArray c;
    public final InterfaceC0314Zf d;
    public final FE1 e;

    public AbstractC0369ag(int i, ResourceManager resourceManager, InterfaceC0314Zf interfaceC0314Zf) {
        super(i, resourceManager);
        this.c = new SparseArray();
        this.e = PostTask.a(5);
        this.d = interfaceC0314Zf;
    }

    @Override // defpackage.bv1
    public final void a(int i) {
        SparseArray sparseArray = this.c;
        C0299Yf c0299Yf = (C0299Yf) sparseArray.get(i);
        if (c0299Yf != null && !c0299Yf.a(false)) {
            try {
                b(i, (Zu1) c0299Yf.g());
                sparseArray.remove(i);
                return;
            } catch (InterruptedException | ExecutionException unused) {
                return;
            }
        }
        try {
            TraceEvent.a("AsyncPreloadResourceLoader.createResource", null);
            C1841zO1 c1841zO1A = this.d.a(i);
            TraceEvent.b("AsyncPreloadResourceLoader.createResource");
            b(i, c1841zO1A);
            sparseArray.remove(i);
        } catch (Throwable th) {
            TraceEvent.b("AsyncPreloadResourceLoader.createResource");
            throw th;
        }
    }

    @Override // defpackage.bv1
    public final void c(int i) {
        SparseArray sparseArray = this.c;
        if (sparseArray.get(i) != null) {
            return;
        }
        C0299Yf c0299Yf = new C0299Yf(this, i);
        c0299Yf.d(this.e);
        sparseArray.put(i, c0299Yf);
    }
}
