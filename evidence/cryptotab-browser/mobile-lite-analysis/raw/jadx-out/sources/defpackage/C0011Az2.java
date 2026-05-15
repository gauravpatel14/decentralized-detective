package defpackage;

import com.google.android.gms.common.Feature;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.internal.ListenerHolder;
import com.google.android.gms.common.api.internal.RegisterListenerMethod;
import com.google.android.gms.common.api.internal.RegistrationMethods;

/* JADX INFO: renamed from: Az2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0011Az2 extends RegisterListenerMethod {
    public final /* synthetic */ RegistrationMethods.Builder a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C0011Az2(RegistrationMethods.Builder builder, ListenerHolder listenerHolder, Feature[] featureArr, boolean z, int i) {
        super(listenerHolder, featureArr, z, i);
        this.a = builder;
    }

    @Override // com.google.android.gms.common.api.internal.RegisterListenerMethod
    public final void registerListener(Api.AnyClient anyClient, H62 h62) {
        this.a.zaa.accept(anyClient, h62);
    }
}
