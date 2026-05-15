package defpackage;

import android.location.Location;
import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: renamed from: iK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0832iK2 implements ListenerHolder.Notifier {
    public final /* synthetic */ Location a;

    public C0832iK2(Location location) {
        this.a = location;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        ((xI0) obj).onLocationChanged(this.a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
