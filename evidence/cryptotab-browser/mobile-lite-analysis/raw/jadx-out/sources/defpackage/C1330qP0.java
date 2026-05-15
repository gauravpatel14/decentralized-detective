package defpackage;

import android.media.MediaRouter;

/* JADX INFO: renamed from: qP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1330qP0 extends MediaRouter.VolumeCallback {
    public final Xg1 a;

    public C1330qP0(Xg1 xg1) {
        this.a = xg1;
    }

    @Override // android.media.MediaRouter.VolumeCallback
    public final void onVolumeSetRequest(MediaRouter.RouteInfo routeInfo, int i) {
        this.a.getClass();
        C0370ah1 c0370ah1L = Xg1.l(routeInfo);
        if (c0370ah1L != null) {
            c0370ah1L.a.h(i);
        }
    }

    @Override // android.media.MediaRouter.VolumeCallback
    public final void onVolumeUpdateRequest(MediaRouter.RouteInfo routeInfo, int i) {
        this.a.getClass();
        C0370ah1 c0370ah1L = Xg1.l(routeInfo);
        if (c0370ah1L != null) {
            c0370ah1L.a.i(i);
        }
    }
}
