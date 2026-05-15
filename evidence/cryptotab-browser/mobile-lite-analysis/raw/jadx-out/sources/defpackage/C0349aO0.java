package defpackage;

import android.media.MediaRouter2;
import android.media.MediaRouter2$ControllerCallback;

/* JADX INFO: renamed from: aO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0349aO0 extends MediaRouter2$ControllerCallback {
    public final /* synthetic */ C0772hO0 a;

    public C0349aO0(C0772hO0 c0772hO0) {
        this.a = c0772hO0;
    }

    public final void onControllerUpdated(MediaRouter2.RoutingController routingController) {
        this.a.h(routingController);
    }
}
