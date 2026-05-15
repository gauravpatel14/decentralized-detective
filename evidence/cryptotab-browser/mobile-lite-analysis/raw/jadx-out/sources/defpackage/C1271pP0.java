package defpackage;

import android.media.MediaRouter;
import android.os.Bundle;
import android.view.Display;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;

/* JADX INFO: renamed from: pP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1271pP0 extends MediaRouter.Callback {
    public final Xg1 a;

    public C1271pP0(Xg1 xg1) {
        this.a = xg1;
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteAdded(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        Xg1 xg1 = this.a;
        if (xg1.g(routeInfo)) {
            xg1.q();
        }
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int iH;
        Xg1 xg1 = this.a;
        xg1.getClass();
        if (Xg1.l(routeInfo) != null || (iH = xg1.h(routeInfo)) < 0) {
            return;
        }
        Zg1 zg1 = (Zg1) xg1.f6J.get(iH);
        NO0 no0 = new NO0(zg1.b, xg1.k(zg1.a));
        xg1.m(zg1, no0);
        zg1.c = no0.b();
        xg1.q();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteGrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup, int i) {
        this.a.getClass();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRoutePresentationDisplayChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        Xg1 xg1 = this.a;
        int iH = xg1.h(routeInfo);
        if (iH >= 0) {
            Zg1 zg1 = (Zg1) xg1.f6J.get(iH);
            Display presentationDisplay = routeInfo.getPresentationDisplay();
            int displayId = presentationDisplay != null ? presentationDisplay.getDisplayId() : -1;
            if (displayId != zg1.c.a.getInt("presentationDisplayId", -1)) {
                OO0 oo0 = zg1.c;
                new ArrayList();
                new ArrayList();
                new HashSet();
                if (oo0 == null) {
                    throw new IllegalArgumentException("descriptor must not be null");
                }
                Bundle bundle = new Bundle(oo0.a);
                ArrayList arrayListC = oo0.c();
                ArrayList arrayListB = oo0.b();
                HashSet hashSetA = oo0.a();
                bundle.putInt("presentationDisplayId", displayId);
                bundle.putParcelableArrayList("controlFilters", new ArrayList<>(arrayListB));
                bundle.putStringArrayList("groupMemberIds", new ArrayList<>(arrayListC));
                bundle.putStringArrayList("allowedPackages", new ArrayList<>(hashSetA));
                zg1.c = new OO0(bundle);
                xg1.q();
            }
        }
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteRemoved(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int iH;
        Xg1 xg1 = this.a;
        xg1.getClass();
        if (Xg1.l(routeInfo) != null || (iH = xg1.h(routeInfo)) < 0) {
            return;
        }
        xg1.f6J.remove(iH);
        xg1.q();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteSelected(MediaRouter mediaRouter, int i, MediaRouter.RouteInfo routeInfo) {
        C0838iP0 c0838iP0;
        Xg1 xg1 = this.a;
        if (routeInfo != xg1.C.getSelectedRoute(8388611)) {
            return;
        }
        C0370ah1 c0370ah1L = Xg1.l(routeInfo);
        if (c0370ah1L != null) {
            c0370ah1L.a.j(false);
            return;
        }
        int iH = xg1.h(routeInfo);
        if (iH >= 0) {
            String str = ((Zg1) xg1.f6J.get(iH)).b;
            bm0 bm0Var = xg1.B;
            bm0Var.a.removeMessages(262);
            hP0 hp0D = bm0Var.d(bm0Var.q);
            if (hp0D != null) {
                Iterator it = hp0D.b.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        c0838iP0 = null;
                        break;
                    } else {
                        c0838iP0 = (C0838iP0) it.next();
                        if (c0838iP0.b.equals(str)) {
                            break;
                        }
                    }
                }
                if (c0838iP0 != null) {
                    c0838iP0.j(true);
                }
            }
        }
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteUngrouped(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo, MediaRouter.RouteGroup routeGroup) {
        this.a.getClass();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteUnselected(MediaRouter mediaRouter, int i, MediaRouter.RouteInfo routeInfo) {
        this.a.getClass();
    }

    @Override // android.media.MediaRouter.Callback
    public final void onRouteVolumeChanged(MediaRouter mediaRouter, MediaRouter.RouteInfo routeInfo) {
        int iH;
        Xg1 xg1 = this.a;
        xg1.getClass();
        if (Xg1.l(routeInfo) != null || (iH = xg1.h(routeInfo)) < 0) {
            return;
        }
        Zg1 zg1 = (Zg1) xg1.f6J.get(iH);
        int volume = routeInfo.getVolume();
        if (volume != zg1.c.a.getInt("volume")) {
            OO0 oo0 = zg1.c;
            new ArrayList();
            new ArrayList();
            new HashSet();
            if (oo0 == null) {
                throw new IllegalArgumentException("descriptor must not be null");
            }
            Bundle bundle = new Bundle(oo0.a);
            ArrayList arrayListC = oo0.c();
            ArrayList arrayListB = oo0.b();
            HashSet hashSetA = oo0.a();
            bundle.putInt("volume", volume);
            bundle.putParcelableArrayList("controlFilters", new ArrayList<>(arrayListB));
            bundle.putStringArrayList("groupMemberIds", new ArrayList<>(arrayListC));
            bundle.putStringArrayList("allowedPackages", new ArrayList<>(hashSetA));
            zg1.c = new OO0(bundle);
            xg1.q();
        }
    }
}
