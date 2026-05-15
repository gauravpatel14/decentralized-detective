package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XJ2 implements ListenerHolder.Notifier {
    public final /* synthetic */ BinderC0461cK2 a;

    public XJ2(BinderC0461cK2 binderC0461cK2) {
        this.a = binderC0461cK2;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        this.a.t.b();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
