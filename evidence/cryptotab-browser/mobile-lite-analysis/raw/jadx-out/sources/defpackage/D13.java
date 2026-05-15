package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.api.CommonStatusCodes;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.measurement.internal.zzq;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class D13 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final /* bridge */ /* synthetic */ Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = "";
        String strCreateString2 = strCreateString;
        String strCreateString3 = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        String strCreateString8 = null;
        String strCreateString9 = null;
        Boolean booleanObject = null;
        ArrayList arrayListCreateStringList = null;
        String strCreateString10 = null;
        String strCreateString11 = null;
        long j = 0;
        long j2 = 0;
        long j3 = 0;
        long j4 = 0;
        long j5 = 0;
        boolean z = true;
        boolean z2 = true;
        boolean z3 = false;
        int i = 0;
        boolean z4 = false;
        long j6 = -2147483648L;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    j = SafeParcelReader.readLong(parcel, header);
                    break;
                case 7:
                    j2 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 8:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 10:
                    z3 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    j6 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 12:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    j3 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 14:
                    j4 = SafeParcelReader.readLong(parcel, header);
                    break;
                case 15:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 16:
                    z2 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 17:
                case 20:
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
                case ConnectionResult.SERVICE_UPDATING /* 18 */:
                    z4 = SafeParcelReader.readBoolean(parcel, header);
                    break;
                case 19:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    break;
                case CommonStatusCodes.RECONNECTION_TIMED_OUT_DURING_UPDATE /* 21 */:
                    booleanObject = SafeParcelReader.readBooleanObject(parcel, header);
                    break;
                case 22:
                    j5 = SafeParcelReader.readLong(parcel, header);
                    break;
                case ConnectionResult.API_DISABLED /* 23 */:
                    arrayListCreateStringList = SafeParcelReader.createStringList(parcel, header);
                    break;
                case ConnectionResult.API_DISABLED_FOR_CONNECTION /* 24 */:
                    strCreateString10 = SafeParcelReader.createString(parcel, header);
                    break;
                case 25:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 26:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 27:
                    strCreateString11 = SafeParcelReader.createString(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        return new zzq(strCreateString3, strCreateString4, strCreateString5, strCreateString6, j, j2, strCreateString7, z, z3, j6, strCreateString8, j3, j4, i, z2, z4, strCreateString9, booleanObject, j5, arrayListCreateStringList, strCreateString10, strCreateString, strCreateString2, strCreateString11);
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new zzq[i];
    }
}
