package defpackage;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.ConnectionResult;
import com.google.android.gms.common.internal.safeparcel.SafeParcelReader;
import com.google.android.gms.vision.barcode.Barcode;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CF2 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        Barcode.GeoPoint geoPoint;
        int iValidateObjectHeader = SafeParcelReader.validateObjectHeader(parcel);
        int i = 0;
        boolean z = false;
        String strCreateString = null;
        String strCreateString2 = null;
        Point[] pointArr = null;
        Barcode.Email email = null;
        Barcode.Phone phone = null;
        Barcode.Sms sms = null;
        Barcode.WiFi wiFi = null;
        Barcode.UrlBookmark urlBookmark = null;
        Barcode.GeoPoint geoPoint2 = null;
        byte[] bArrCreateByteArray = null;
        Barcode.DriverLicense driverLicense = null;
        Barcode.ContactInfo contactInfo = null;
        Barcode.CalendarEvent calendarEvent = null;
        int i2 = 0;
        while (parcel.dataPosition() < iValidateObjectHeader) {
            int header = SafeParcelReader.readHeader(parcel);
            switch (SafeParcelReader.getFieldId(header)) {
                case 2:
                    i = SafeParcelReader.readInt(parcel, header);
                    continue;
                case 3:
                    strCreateString = SafeParcelReader.createString(parcel, header);
                    continue;
                case 4:
                    strCreateString2 = SafeParcelReader.createString(parcel, header);
                    continue;
                case 5:
                    i2 = SafeParcelReader.readInt(parcel, header);
                    continue;
                case 6:
                    pointArr = (Point[]) SafeParcelReader.createTypedArray(parcel, header, Point.CREATOR);
                    continue;
                case 7:
                    email = (Barcode.Email) SafeParcelReader.createParcelable(parcel, header, Barcode.Email.CREATOR);
                    continue;
                case 8:
                    phone = (Barcode.Phone) SafeParcelReader.createParcelable(parcel, header, Barcode.Phone.CREATOR);
                    continue;
                case ConnectionResult.SERVICE_INVALID /* 9 */:
                    sms = (Barcode.Sms) SafeParcelReader.createParcelable(parcel, header, Barcode.Sms.CREATOR);
                    continue;
                case 10:
                    wiFi = (Barcode.WiFi) SafeParcelReader.createParcelable(parcel, header, Barcode.WiFi.CREATOR);
                    continue;
                case ConnectionResult.LICENSE_CHECK_FAILED /* 11 */:
                    urlBookmark = (Barcode.UrlBookmark) SafeParcelReader.createParcelable(parcel, header, Barcode.UrlBookmark.CREATOR);
                    continue;
                case 12:
                    geoPoint2 = (Barcode.GeoPoint) SafeParcelReader.createParcelable(parcel, header, Barcode.GeoPoint.CREATOR);
                    continue;
                case 13:
                    geoPoint = geoPoint2;
                    calendarEvent = (Barcode.CalendarEvent) SafeParcelReader.createParcelable(parcel, header, Barcode.CalendarEvent.CREATOR);
                    break;
                case 14:
                    geoPoint = geoPoint2;
                    contactInfo = (Barcode.ContactInfo) SafeParcelReader.createParcelable(parcel, header, Barcode.ContactInfo.CREATOR);
                    break;
                case 15:
                    geoPoint = geoPoint2;
                    driverLicense = (Barcode.DriverLicense) SafeParcelReader.createParcelable(parcel, header, Barcode.DriverLicense.CREATOR);
                    break;
                case 16:
                    bArrCreateByteArray = SafeParcelReader.createByteArray(parcel, header);
                    continue;
                case 17:
                    z = SafeParcelReader.readBoolean(parcel, header);
                    continue;
                default:
                    SafeParcelReader.skipUnknownField(parcel, header);
                    continue;
            }
            geoPoint2 = geoPoint;
        }
        SafeParcelReader.ensureAtEnd(parcel, iValidateObjectHeader);
        Barcode barcode = new Barcode();
        barcode.t = i;
        barcode.u = strCreateString;
        barcode.H = bArrCreateByteArray;
        barcode.v = strCreateString2;
        barcode.w = i2;
        barcode.x = pointArr;
        barcode.I = z;
        barcode.y = email;
        barcode.z = phone;
        barcode.A = sms;
        barcode.B = wiFi;
        barcode.C = urlBookmark;
        barcode.D = geoPoint2;
        barcode.E = calendarEvent;
        barcode.F = contactInfo;
        barcode.G = driverLicense;
        return barcode;
    }

    @Override // android.os.Parcelable.Creator
    public final /* synthetic */ Object[] newArray(int i) {
        return new Barcode[i];
    }
}
