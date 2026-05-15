package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class rS2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        String strCreateString8 = null;
        String strCreateString9 = null;
        String strCreateString10 = null;
        String strCreateString11 = null;
        String strCreateString12 = null;
        String strCreateString13 = null;
        String strCreateString14 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 8:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                case 10:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    strCreateString10 = SafeParcelReader.createString(parcel, header);
                    break;
                case 12:
                    strCreateString11 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    strCreateString12 = SafeParcelReader.createString(parcel, header);
                    break;
                case 14:
                    strCreateString13 = SafeParcelReader.createString(parcel, header);
                    break;
                case 15:
                    strCreateString14 = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        Barcode.DriverLicense driverLicense = new Barcode.DriverLicense();
        driverLicense.t = strCreateString;
        driverLicense.u = strCreateString2;
        driverLicense.v = strCreateString3;
        driverLicense.w = strCreateString4;
        driverLicense.x = strCreateString5;
        driverLicense.y = strCreateString6;
        driverLicense.z = strCreateString7;
        driverLicense.A = strCreateString8;
        driverLicense.B = strCreateString9;
        driverLicense.C = strCreateString10;
        driverLicense.D = strCreateString11;
        driverLicense.E = strCreateString12;
        driverLicense.F = strCreateString13;
        driverLicense.G = strCreateString14;
        return driverLicense;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Barcode.DriverLicense[i];
    }
}
