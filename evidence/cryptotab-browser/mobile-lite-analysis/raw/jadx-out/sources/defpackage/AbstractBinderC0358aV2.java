package defpackage;

import android.os.Parcel;
import com.google.android.gms.internal.location.zzg;

/* JADX INFO: renamed from: aV2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0358aV2 extends AbstractBinderC1547uF2 implements InterfaceC0534dW2 {
    public AbstractBinderC0358aV2() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    @Override // defpackage.AbstractBinderC1547uF2
    public final boolean W0(int i, Parcel parcel) {
        if (i == 1) {
            zzg zzgVar = (zzg) WH2.a(parcel, zzg.CREATOR);
            WH2.b(parcel);
            B0(zzgVar);
        } else {
            if (i != 2) {
                return false;
            }
            a();
        }
        return true;
    }
}
