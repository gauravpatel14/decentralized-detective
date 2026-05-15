package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegistrationMethods;
import com.google.android.gms.common.api.internal.UnregisterListenerMethod;

/* JADX INFO: renamed from: Bz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0027Bz2 extends UnregisterListenerMethod {
    public final /* synthetic */ RegistrationMethods.Builder a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0027Bz2(RegistrationMethods.Builder builder, ListenerHolder.ListenerKey listenerKey) {
        super(listenerKey);
        this.a = builder;
    }

    @Override // com.google.android.gms.common.api.internal.UnregisterListenerMethod
    public final void unregisterListener(Api.AnyClient anyClient, H62 h62) {
        this.a.zab.accept(anyClient, h62);
    }
}
