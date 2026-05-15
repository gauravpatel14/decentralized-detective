package defpackage;

import android.os.Parcel;
import com.google.android.gms.cast.LaunchOptions;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class DQ2 extends yy {
    public final /* synthetic */ String a;
    public final /* synthetic */ LaunchOptions b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public DQ2(GoogleApiClient googleApiClient, String str, LaunchOptions launchOptions) {
        super(googleApiClient);
        this.a = str;
        this.b = launchOptions;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        OJ2 oj2 = (OJ2) anyClient;
        try {
            String str = this.a;
            LaunchOptions launchOptions = this.b;
            oj2.f(this);
            C1836zL2 c1836zL2 = (C1836zL2) oj2.getService();
            if (oj2.k()) {
                Parcel parcelW0 = c1836zL2.W0();
                parcelW0.writeString(str);
                QK2.c(parcelW0, launchOptions);
                c1836zL2.Z0(13, parcelW0);
            } else {
                oj2.m(2016);
            }
        } catch (IllegalStateException unused) {
            a();
        }
    }
}
