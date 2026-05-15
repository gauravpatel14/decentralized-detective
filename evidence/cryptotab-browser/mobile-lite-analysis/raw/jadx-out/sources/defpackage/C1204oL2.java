package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.cast.ApplicationMetadata;
import com.google.android.gms.cast.zzae;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.internal.cast.zzdb;

/* JADX INFO: renamed from: oL2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1204oL2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        double d = 0.0d;
        boolean z = false;
        int i = 0;
        int i2 = 0;
        ApplicationMetadata applicationMetadata = null;
        zzae zzaeVar = null;
        double d2 = 0.0d;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    d = SafeParcelReader.readDouble(parcel, header);
                    break;
                case 3:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 4:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 5:
                    applicationMetadata = (ApplicationMetadata) SafeParcelReader.createParcelable(parcel, header, ApplicationMetadata.CREATOR);
                    break;
                case 6:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 7:
                    zzaeVar = (zzae) SafeParcelReader.createParcelable(parcel, header, zzae.CREATOR);
                    break;
                case 8:
                    d2 = SafeParcelReader.readDouble(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        zzdb zzdbVar = new zzdb();
        zzdbVar.t = d;
        zzdbVar.u = z;
        zzdbVar.v = i;
        zzdbVar.w = applicationMetadata;
        zzdbVar.x = i2;
        zzdbVar.y = zzaeVar;
        zzdbVar.z = d2;
        return zzdbVar;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzdb[i];
    }
}
