package defpackage;

import android.media.MediaRouter;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Yg1 extends XO0 {
    public final MediaRouter.RouteInfo a;

    public Yg1(MediaRouter.RouteInfo routeInfo) {
        this.a = routeInfo;
    }

    @Override // defpackage.XO0
    public final void f(int i) {
        this.a.requestSetVolume(i);
    }

    @Override // defpackage.XO0
    public final void i(int i) {
        this.a.requestUpdateVolume(i);
    }
}
