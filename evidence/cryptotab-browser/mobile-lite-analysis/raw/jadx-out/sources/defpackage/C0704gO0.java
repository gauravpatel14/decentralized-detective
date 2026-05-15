package defpackage;

import android.media.MediaRoute2Info;
import android.media.MediaRouter2;
import android.media.MediaRouter2$TransferCallback;
import android.text.TextUtils;
import android.util.Log;
import java.util.Iterator;
import java.util.List;

/* JADX INFO: renamed from: gO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0704gO0 extends MediaRouter2$TransferCallback {
    public final /* synthetic */ C0772hO0 a;

    public C0704gO0(C0772hO0 c0772hO0) {
        this.a = c0772hO0;
    }

    public final void onStop(MediaRouter2.RoutingController routingController) {
        C0838iP0 c0838iP0C;
        XO0 xo0 = (XO0) this.a.D.remove(routingController);
        if (xo0 == null) {
            Log.w("MR2Provider", "onStop: No matching routeController found. routingController=" + routingController);
        } else {
            bm0 bm0Var = this.a.C.a;
            if (xo0 != bm0Var.d || bm0Var.e() == (c0838iP0C = bm0Var.c())) {
                return;
            }
            bm0Var.h(c0838iP0C, 2, true);
        }
    }

    public final void onTransfer(MediaRouter2.RoutingController routingController, MediaRouter2.RoutingController routingController2) {
        C0838iP0 c0838iP0;
        this.a.D.remove(routingController);
        if (routingController2 == this.a.B.getSystemController()) {
            bm0 bm0Var = this.a.C.a;
            C0838iP0 c0838iP0C = bm0Var.c();
            if (bm0Var.e() != c0838iP0C) {
                bm0Var.h(c0838iP0C, 3, true);
                return;
            }
            return;
        }
        List selectedRoutes = routingController2.getSelectedRoutes();
        if (selectedRoutes.isEmpty()) {
            Log.w("MR2Provider", "Selected routes are empty. This shouldn't happen.");
            return;
        }
        String id = YN0.b(selectedRoutes.get(0)).getId();
        this.a.D.put(routingController2, new C0526dO0(this.a, routingController2, id));
        bm0 bm0Var2 = this.a.C.a;
        Iterator it = bm0Var2.h.iterator();
        while (true) {
            if (!it.hasNext()) {
                c0838iP0 = null;
                break;
            }
            c0838iP0 = (C0838iP0) it.next();
            if (c0838iP0.a() == bm0Var2.p && TextUtils.equals(id, c0838iP0.b)) {
                break;
            }
        }
        if (c0838iP0 == null) {
            Log.w("AxMediaRouter", "onSelectRoute: The target RouteInfo is not found for descriptorId=" + id);
        } else {
            bm0Var2.h(c0838iP0, 3, true);
        }
        this.a.h(routingController2);
    }

    public final void onTransferFailure(MediaRoute2Info mediaRoute2Info) {
        Log.w("MR2Provider", "Transfer failed. requestedRoute=" + mediaRoute2Info);
    }
}
