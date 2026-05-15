package defpackage;

import android.os.Parcel;
import com.google.android.gms.cast.zzah;
import com.google.android.gms.common.api.Api;
import com.google.android.gms.common.api.GoogleApiClient;

/* JADX INFO: renamed from: sV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1452sV2 extends yy {
    public final /* synthetic */ String a;
    public final /* synthetic */ String b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public C1452sV2(GoogleApiClient googleApiClient, String str, String str2) {
        super(googleApiClient);
        this.a = str;
        this.b = str2;
    }

    @Override // com.google.android.gms.common.api.internal.BaseImplementation.ApiMethodImpl
    public final void doExecute(Api.AnyClient anyClient) {
        OJ2 oj2 = (OJ2) anyClient;
        try {
            String str = this.a;
            String str2 = this.b;
            oj2.f(this);
            zzah zzahVar = new zzah(0);
            C1836zL2 c1836zL2 = (C1836zL2) oj2.getService();
            if (oj2.k()) {
                Parcel parcelW0 = c1836zL2.W0();
                parcelW0.writeString(str);
                parcelW0.writeString(str2);
                QK2.c(parcelW0, zzahVar);
                c1836zL2.Z0(14, parcelW0);
            } else {
                oj2.m(2016);
            }
        } catch (IllegalStateException unused) {
            a();
        }
    }
}
