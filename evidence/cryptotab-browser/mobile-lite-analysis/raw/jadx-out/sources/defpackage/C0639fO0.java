package defpackage;

import android.media.MediaRouter2$RouteCallback;
import java.util.List;

/* JADX INFO: renamed from: fO0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0639fO0 extends MediaRouter2$RouteCallback {
    public final /* synthetic */ int a;
    public final /* synthetic */ C0772hO0 b;

    public /* synthetic */ C0639fO0(C0772hO0 c0772hO0, int i) {
        this.a = i;
        this.b = c0772hO0;
    }

    public void onRoutesAdded(List list) {
        switch (this.a) {
            case 0:
                this.b.g();
                break;
            default:
                super.onRoutesAdded(list);
                break;
        }
    }

    public void onRoutesChanged(List list) {
        switch (this.a) {
            case 0:
                this.b.g();
                break;
            default:
                super.onRoutesChanged(list);
                break;
        }
    }

    public void onRoutesRemoved(List list) {
        switch (this.a) {
            case 0:
                this.b.g();
                break;
            default:
                super.onRoutesRemoved(list);
                break;
        }
    }

    public void onRoutesUpdated(List list) {
        switch (this.a) {
            case 1:
                this.b.g();
                break;
            default:
                super.onRoutesUpdated(list);
                break;
        }
    }
}
