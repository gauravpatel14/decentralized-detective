package defpackage;

import android.os.Parcel;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.signin.internal.zak;

/* JADX INFO: renamed from: Oz2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractBinderC0183Oz2 extends AbstractBinderC0441bz2 implements InterfaceC0266Vz2 {
    @Override // defpackage.AbstractBinderC0441bz2
    public final boolean zaa(int i, Parcel parcel, Parcel parcel2, int i2) {
        switch (i) {
            case 3:
                AbstractC1646vz2.b(parcel);
                break;
            case 4:
                AbstractC1646vz2.b(parcel);
                break;
            case 5:
            default:
                return false;
            case 6:
                AbstractC1646vz2.b(parcel);
                break;
            case 7:
                AbstractC1646vz2.b(parcel);
                break;
            case 8:
                zak zakVar = (zak) AbstractC1646vz2.a(parcel, zak.CREATOR);
                AbstractC1646vz2.b(parcel);
                zab(zakVar);
                break;
            case ConnectionResult.SERVICE_INVALID /* 9 */:
                AbstractC1646vz2.b(parcel);
                break;
        }
        parcel2.writeNoException();
        return true;
    }
}
