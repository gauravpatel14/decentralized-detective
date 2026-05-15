package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import android.util.Log;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.images.WebImage;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import java.net.InetAddress;
import java.net.UnknownHostException;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class YY2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        String str;
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        String strCreateString = null;
        String strCreateString2 = null;
        String strCreateString3 = null;
        ArrayList arrayList = null;
        String strCreateString4 = null;
        String strCreateString5 = null;
        String strCreateString6 = null;
        String strCreateString7 = null;
        byte[] bArrCreateByteArray = null;
        int i = 0;
        int i2 = 0;
        int i3 = 0;
        int i4 = -1;
        String strCreateString8 = null;
        String strCreateString9 = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 3:
                    strCreateString8 = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString9 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 6:
                    strCreateString3 = SafeParcelReader.createString(parcel, header);
                    break;
                case 7:
                    i = SafeParcelReader.readInt(parcel, header);
                    break;
                case 8:
                    arrayList = SafeParcelReader.createTypedList(parcel, header, WebImage.CREATOR);
                    break;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 10:
                    i4 = SafeParcelReader.readInt(parcel, header);
                    break;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    strCreateString4 = SafeParcelReader.createString(parcel, header);
                    break;
                case 12:
                    strCreateString5 = SafeParcelReader.createString(parcel, header);
                    break;
                case 13:
                    i3 = SafeParcelReader.readInt(parcel, header);
                    break;
                case 14:
                    strCreateString6 = SafeParcelReader.createString(parcel, header);
                    break;
                case 15:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    break;
                case 16:
                    strCreateString7 = SafeParcelReader.createString(parcel, header);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        CastDevice castDevice = new CastDevice();
        if (strCreateString == null) {
            strCreateString = "";
        }
        castDevice.t = strCreateString;
        if (strCreateString8 == null) {
            strCreateString8 = "";
        }
        castDevice.u = strCreateString8;
        if (TextUtils.isEmpty(strCreateString8)) {
            str = "";
        } else {
            try {
                castDevice.v = InetAddress.getByName(strCreateString8);
                str = "";
            } catch (UnknownHostException e) {
                String str2 = castDevice.u;
                String message = e.getMessage();
                str = "";
                StringBuilder sb = new StringBuilder(String.valueOf(message).length() + String.valueOf(str2).length() + 48);
                sb.append("Unable to convert host address (");
                sb.append(str2);
                sb.append(") to ipaddress: ");
                sb.append(message);
                Log.i("CastDevice", sb.toString());
            }
        }
        if (strCreateString9 == null) {
            strCreateString9 = str;
        }
        castDevice.w = strCreateString9;
        if (strCreateString2 == null) {
            strCreateString2 = str;
        }
        castDevice.x = strCreateString2;
        if (strCreateString3 == null) {
            strCreateString3 = str;
        }
        castDevice.y = strCreateString3;
        castDevice.z = i;
        if (arrayList == null) {
            arrayList = new ArrayList();
        }
        castDevice.A = arrayList;
        castDevice.B = i2;
        castDevice.C = i4;
        if (strCreateString4 == null) {
            strCreateString4 = str;
        }
        castDevice.D = strCreateString4;
        castDevice.E = strCreateString5;
        castDevice.F = i3;
        castDevice.G = strCreateString6;
        castDevice.H = bArrCreateByteArray;
        castDevice.I = strCreateString7;
        return castDevice;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new CastDevice[i];
    }
}
