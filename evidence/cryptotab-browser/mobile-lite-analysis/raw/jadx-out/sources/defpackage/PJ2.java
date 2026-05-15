package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.location.LocationResult;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class PJ2 implements ListenerHolder.Notifier {
    public final /* synthetic */ LocationResult a;

    public PJ2(LocationResult locationResult) {
        this.a = locationResult;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* synthetic */ void notifyListener(Object obj) {
        ((vI0) obj).a(this.a);
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
