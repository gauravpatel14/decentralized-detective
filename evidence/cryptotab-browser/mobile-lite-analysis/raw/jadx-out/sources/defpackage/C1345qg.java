package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.ViewParent;
import org.chromium.base.Callback;
import org.chromium.base.TraceEvent;
import org.chromium.ui.AsyncViewStub;

/* JADX INFO: renamed from: qg, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1345qg implements Callback, InterfaceC1350qp2 {
    public int t;
    public View u;
    public AsyncViewStub v;

    public static C1345qg c(AsyncViewStub asyncViewStub, int i) {
        View view = asyncViewStub.u;
        if (view != null) {
            View viewFindViewById = view.findViewById(i);
            C1345qg c1345qg = new C1345qg();
            c1345qg.u = viewFindViewById;
            return c1345qg;
        }
        C1345qg c1345qg2 = new C1345qg();
        c1345qg2.t = i;
        c1345qg2.v = asyncViewStub;
        if (view != null) {
            c1345qg2.a0(view);
        } else {
            asyncViewStub.w.e(c1345qg2);
        }
        return c1345qg2;
    }

    @Override // defpackage.InterfaceC1350qp2
    public final void a(final Callback callback) {
        View view = this.u;
        if (view != null) {
            callback.a0(view);
            return;
        }
        AsyncViewStub asyncViewStub = this.v;
        Callback callback2 = new Callback() { // from class: pg
            @Override // org.chromium.base.Callback
            /* JADX INFO: renamed from: onResult */
            public final void a0(Object obj) {
                callback.a0(this.t.u);
            }
        };
        View view2 = asyncViewStub.u;
        if (view2 != null) {
            callback2.a0(view2);
        } else {
            asyncViewStub.w.e(callback2);
        }
    }

    @Override // defpackage.InterfaceC1350qp2
    public final void b() {
        AsyncViewStub asyncViewStub = this.v;
        asyncViewStub.getClass();
        TraceEvent traceEventJ = TraceEvent.j("AsyncViewStub.inflate", null);
        try {
            ViewParent parent = asyncViewStub.getParent();
            if (asyncViewStub.x) {
                asyncViewStub.v.a(asyncViewStub.t, (ViewGroup) parent, asyncViewStub);
            } else {
                asyncViewStub.a((ViewGroup) LayoutInflater.from(asyncViewStub.getContext()).inflate(asyncViewStub.t, (ViewGroup) parent, false), (ViewGroup) parent);
            }
            if (traceEventJ != null) {
                traceEventJ.close();
            }
        } catch (Throwable th) {
            if (traceEventJ != null) {
                try {
                    traceEventJ.close();
                } catch (Throwable unused) {
                }
            }
            throw th;
        }
    }

    @Override // org.chromium.base.Callback
    /* JADX INFO: renamed from: onResult */
    public final void a0(Object obj) {
        this.u = ((View) obj).findViewById(this.t);
        this.v = null;
    }
}
