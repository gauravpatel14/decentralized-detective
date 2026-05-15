package defpackage;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class GI2 extends YG2 implements NI2 {
    public GI2(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IBundleReceiver");
    }

    @Override // defpackage.NI2
    public final void e(Bundle bundle) {
        Parcel parcelW0 = W0();
        hH2.c(parcelW0, bundle);
        Y0(1, parcelW0);
    }
}
