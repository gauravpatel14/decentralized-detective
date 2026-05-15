package defpackage;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class P13 extends AbstractC1655wB2 {
    public final Zr0 W0(ObjectWrapper objectWrapper, String str, int i, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        UH2.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        UH2.d(parcelZza, objectWrapper2);
        Parcel parcelZzB = zzB(2, parcelZza);
        Zr0 zr0W0 = ObjectWrapper.W0(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return zr0W0;
    }

    public final Zr0 X0(ObjectWrapper objectWrapper, String str, int i, ObjectWrapper objectWrapper2) {
        Parcel parcelZza = zza();
        UH2.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        UH2.d(parcelZza, objectWrapper2);
        Parcel parcelZzB = zzB(3, parcelZza);
        Zr0 zr0W0 = ObjectWrapper.W0(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return zr0W0;
    }
}
