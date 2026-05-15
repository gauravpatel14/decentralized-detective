package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;

/* JADX INFO: renamed from: nK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1141nK2 implements ListenerHolder.Notifier {
    public final /* synthetic */ BinderC1496tK2 a;

    public C1141nK2(BinderC1496tK2 binderC1496tK2) {
        this.a = binderC1496tK2;
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final /* bridge */ /* synthetic */ void notifyListener(Object obj) {
        this.a.t.b();
    }

    @Override // com.google.android.gms.common.api.internal.ListenerHolder.Notifier
    public final void onNotifyListenerFailed() {
    }
}
