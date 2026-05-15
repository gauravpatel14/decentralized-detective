package defpackage;

import android.os.Parcel;
import com.google.android.gms.location.LocationResult;

/* JADX INFO: renamed from: cK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC0461cK2 extends AbstractBinderC1547uF2 implements C13 {
    public static final /* synthetic */ int u = 0;
    public final kH2 t;

    public BinderC0461cK2(kH2 kh2) {
        super("com.google.android.gms.location.ILocationCallback");
        this.t = kh2;
    }

    @Override // defpackage.AbstractBinderC1547uF2
    public final boolean W0(int i, Parcel parcel) {
        kH2 kh2 = this.t;
        if (i == 1) {
            LocationResult locationResult = (LocationResult) WH2.a(parcel, LocationResult.CREATOR);
            WH2.b(parcel);
            kh2.a().notifyListener(new PJ2(locationResult));
        } else if (i == 2) {
            WH2.b(parcel);
            kh2.a().notifyListener(new TJ2());
        } else {
            if (i != 3) {
                return false;
            }
            X0();
        }
        return true;
    }

    public final void X0() {
        this.t.a().notifyListener(new XJ2(this));
    }
}
