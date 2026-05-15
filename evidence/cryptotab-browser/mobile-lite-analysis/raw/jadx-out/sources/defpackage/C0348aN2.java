package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* JADX INFO: renamed from: aN2, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C0348aN2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        Barcode.PersonName personName = null;
        String strCreateString = null;
        String strCreateString2 = null;
        Barcode.Phone[] phoneArr = null;
        Barcode.Email[] emailArr = null;
        String[] strArrCreateStringArray = null;
        Barcode.Address[] addressArr = null;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    personName = (Barcode.PersonName) SafeParcelReader.createParcelable(parcel, header, Barcode.PersonName.CREATOR);
                    break;
                case 3:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    break;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    break;
                case 5:
                    phoneArr = (Barcode.Phone[]) SafeParcelReader.createTypedArray(parcel, header, Barcode.Phone.CREATOR);
                    break;
                case 6:
                    emailArr = (Barcode.Email[]) SafeParcelReader.createTypedArray(parcel, header, Barcode.Email.CREATOR);
                    break;
                case 7:
                    strArrCreateStringArray = SafeParcelReader.createStringArray(parcel, header);
                    break;
                case 8:
                    addressArr = (Barcode.Address[]) SafeParcelReader.createTypedArray(parcel, header, Barcode.Address.CREATOR);
                    break;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    break;
            }
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        Barcode.ContactInfo contactInfo = new Barcode.ContactInfo();
        contactInfo.t = personName;
        contactInfo.u = strCreateString;
        contactInfo.v = strCreateString2;
        contactInfo.w = phoneArr;
        contactInfo.x = emailArr;
        contactInfo.y = strArrCreateStringArray;
        contactInfo.z = addressArr;
        return contactInfo;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Barcode.ContactInfo[i];
    }
}
