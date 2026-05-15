package defpackage;

import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RemoteCall;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class kH2 implements RemoteCall {
    public final InterfaceC0696gH2 a;
    public ListenerHolder b;
    public boolean c = true;
    public final /* synthetic */ C1139nH2 d;

    public kH2(C1139nH2 c1139nH2, ListenerHolder listenerHolder, InterfaceC0696gH2 interfaceC0696gH2) {
        this.d = c1139nH2;
        this.b = listenerHolder;
        this.a = interfaceC0696gH2;
    }

    public final synchronized ListenerHolder a() {
        return this.b;
    }

    @Override // com.google.android.gms.common.api.internal.RemoteCall
    public final /* bridge */ /* synthetic */ void accept(Object obj, Object obj2) {
        ListenerHolder.ListenerKey listenerKey;
        boolean z;
        UK2 uk2 = (UK2) obj;
        H62 h62 = (H62) obj2;
        synchronized (this) {
            listenerKey = this.b.getListenerKey();
            z = this.c;
            this.b.clear();
        }
        if (listenerKey == null) {
            h62.b(Boolean.FALSE);
        } else {
            this.a.a(uk2, listenerKey, z, h62);
        }
    }

    public final void b() {
        ListenerHolder.ListenerKey listenerKey;
        synchronized (this) {
            this.c = false;
            listenerKey = this.b.getListenerKey();
        }
        if (listenerKey != null) {
            this.d.doUnregisterEventListener(listenerKey, 2441);
        }
    }
}
