package defpackage;

import android.os.Parcel;
import com.google.android.gms.dynamic.ObjectWrapper;

/* JADX INFO: renamed from: m13, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1061m13 extends AbstractC1655wB2 {
    public final Zr0 W0(ObjectWrapper objectWrapper, String str, int i) {
        Parcel parcelZza = zza();
        UH2.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
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
        Parcel parcelZzB = zzB(8, parcelZza);
        Zr0 zr0W0 = ObjectWrapper.W0(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return zr0W0;
    }

    public final Zr0 Y0(ObjectWrapper objectWrapper, String str, int i) {
        Parcel parcelZza = zza();
        UH2.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(i);
        Parcel parcelZzB = zzB(4, parcelZza);
        Zr0 zr0W0 = ObjectWrapper.W0(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return zr0W0;
    }

    public final Zr0 Z0(ObjectWrapper objectWrapper, String str, boolean z, long j) {
        Parcel parcelZza = zza();
        UH2.d(parcelZza, objectWrapper);
        parcelZza.writeString(str);
        parcelZza.writeInt(z ? 1 : 0);
        parcelZza.writeLong(j);
        Parcel parcelZzB = zzB(7, parcelZza);
        Zr0 zr0W0 = ObjectWrapper.W0(parcelZzB.readStrongBinder());
        parcelZzB.recycle();
        return zr0W0;
    }
}
