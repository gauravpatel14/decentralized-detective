package defpackage;

import android.location.Location;
import android.os.Parcel;

/* JADX INFO: renamed from: tK2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class BinderC1496tK2 extends AbstractBinderC1547uF2 implements J23 {
    public static final /* synthetic */ int u = 0;
    public final kH2 t;

    public BinderC1496tK2(kH2 kh2) {
        super("com.google.android.gms.location.ILocationListener");
        this.t = kh2;
    }

    @Override // defpackage.AbstractBinderC1547uF2
    public final boolean W0(int i, Parcel parcel) {
        if (i == 1) {
            Location location = (Location) WH2.a(parcel, Location.CREATOR);
            WH2.b(parcel);
            this.t.a().notifyListener(new C0832iK2(location));
        } else {
            if (i != 2) {
                return false;
            }
            a();
        }
        return true;
    }

    public final void a() {
        this.t.a().notifyListener(new C1141nK2(this));
    }
}
