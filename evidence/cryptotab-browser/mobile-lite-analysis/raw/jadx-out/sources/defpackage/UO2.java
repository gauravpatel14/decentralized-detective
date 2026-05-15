package defpackage;

import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class UO2 extends AbstractC1439sL2 {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public UO2(GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        try {
            ((OJ2) anyClient).g(this.a, this.b, this);
        } catch (IllegalArgumentException | IllegalStateException unused) {
            a();
        }
    }
}
