package com.google.android.gms.vision.barcode;

import android.graphics.Point;
import android.os.Parcel;
import android.os.Parcelable;
import androidx.annotation.RecentlyNonNull;
import com.google.android.gms.common.internal.safeparcel.AbstractSafeParcelable;
import com.google.android.gms.common.internal.safeparcel.SafeParcelWriter;
import com.google.android.gms.common.internal.safeparcel.SafeParcelable;
import defpackage.C0348aN2;
import defpackage.C0648fV2;
import defpackage.C0781hW2;
import defpackage.C1033lX2;
import defpackage.C1035lY2;
import defpackage.CF2;
import defpackage.CK2;
import defpackage.FB2;
import defpackage.GO2;
import defpackage.KQ2;
import defpackage.QT2;
import defpackage.SY2;
import defpackage.rS2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SafeParcelable.Class(creator = "BarcodeCreator")
@SafeParcelable.Reserved({1})
public class Barcode extends AbstractSafeParcelable {

    @RecentlyNonNull
    public static final Parcelable.Creator CREATOR = new CF2();
    public Sms A;
    public WiFi B;
    public UrlBookmark C;
    public GeoPoint D;
    public CalendarEvent E;
    public ContactInfo F;
    public DriverLicense G;
    public byte[] H;
    public boolean I;
    public int t;
    public String u;
    public String v;
    public int w;
    public Point[] x;
    public Email y;
    public Phone z;

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "AddressCreator")
    @SafeParcelable.Reserved({1})
    public class Address extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new FB2();
        public int t;
        public String[] u;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 2, this.t);
            SafeParcelWriter.writeStringArray(parcel, 3, this.u, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "CalendarDateTimeCreator")
    @SafeParcelable.Reserved({1})
    public class CalendarDateTime extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new CK2();
        public String A;
        public int t;
        public int u;
        public int v;
        public int w;
        public int x;
        public int y;
        public boolean z;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 2, this.t);
            SafeParcelWriter.writeInt(parcel, 3, this.u);
            SafeParcelWriter.writeInt(parcel, 4, this.v);
            SafeParcelWriter.writeInt(parcel, 5, this.w);
            SafeParcelWriter.writeInt(parcel, 6, this.x);
            SafeParcelWriter.writeInt(parcel, 7, this.y);
            SafeParcelWriter.writeBoolean(parcel, 8, this.z);
            SafeParcelWriter.writeString(parcel, 9, this.A, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "CalendarEventCreator")
    @SafeParcelable.Reserved({1})
    public class CalendarEvent extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new GO2();
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public CalendarDateTime y;
        public CalendarDateTime z;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.t, false);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.writeString(parcel, 4, this.v, false);
            SafeParcelWriter.writeString(parcel, 5, this.w, false);
            SafeParcelWriter.writeString(parcel, 6, this.x, false);
            SafeParcelWriter.writeParcelable(parcel, 7, this.y, i, false);
            SafeParcelWriter.writeParcelable(parcel, 8, this.z, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "ContactInfoCreator")
    @SafeParcelable.Reserved({1})
    public class ContactInfo extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new C0348aN2();
        public PersonName t;
        public String u;
        public String v;
        public Phone[] w;
        public Email[] x;
        public String[] y;
        public Address[] z;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeParcelable(parcel, 2, this.t, i, false);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.writeString(parcel, 4, this.v, false);
            SafeParcelWriter.writeTypedArray(parcel, 5, this.w, i, false);
            SafeParcelWriter.writeTypedArray(parcel, 6, this.x, i, false);
            SafeParcelWriter.writeStringArray(parcel, 7, this.y, false);
            SafeParcelWriter.writeTypedArray(parcel, 8, this.z, i, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "DriverLicenseCreator")
    @SafeParcelable.Reserved({1})
    public class DriverLicense extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new rS2();
        public String A;
        public String B;
        public String C;
        public String D;
        public String E;
        public String F;
        public String G;
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.t, false);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.writeString(parcel, 4, this.v, false);
            SafeParcelWriter.writeString(parcel, 5, this.w, false);
            SafeParcelWriter.writeString(parcel, 6, this.x, false);
            SafeParcelWriter.writeString(parcel, 7, this.y, false);
            SafeParcelWriter.writeString(parcel, 8, this.z, false);
            SafeParcelWriter.writeString(parcel, 9, this.A, false);
            SafeParcelWriter.writeString(parcel, 10, this.B, false);
            SafeParcelWriter.writeString(parcel, 11, this.C, false);
            SafeParcelWriter.writeString(parcel, 12, this.D, false);
            SafeParcelWriter.writeString(parcel, 13, this.E, false);
            SafeParcelWriter.writeString(parcel, 14, this.F, false);
            SafeParcelWriter.writeString(parcel, 15, this.G, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "EmailCreator")
    @SafeParcelable.Reserved({1})
    public class Email extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new KQ2();
        public int t;
        public String u;
        public String v;
        public String w;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 2, this.t);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.writeString(parcel, 4, this.v, false);
            SafeParcelWriter.writeString(parcel, 5, this.w, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "GeoPointCreator")
    @SafeParcelable.Reserved({1})
    public class GeoPoint extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new C0648fV2();
        public double t;
        public double u;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeDouble(parcel, 2, this.t);
            SafeParcelWriter.writeDouble(parcel, 3, this.u);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "PersonNameCreator")
    @SafeParcelable.Reserved({1})
    public class PersonName extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new QT2();
        public String t;
        public String u;
        public String v;
        public String w;
        public String x;
        public String y;
        public String z;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.t, false);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.writeString(parcel, 4, this.v, false);
            SafeParcelWriter.writeString(parcel, 5, this.w, false);
            SafeParcelWriter.writeString(parcel, 6, this.x, false);
            SafeParcelWriter.writeString(parcel, 7, this.y, false);
            SafeParcelWriter.writeString(parcel, 8, this.z, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "PhoneCreator")
    @SafeParcelable.Reserved({1})
    public class Phone extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new C1033lX2();
        public int t;
        public String u;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeInt(parcel, 2, this.t);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "SmsCreator")
    @SafeParcelable.Reserved({1})
    public class Sms extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new C0781hW2();
        public String t;
        public String u;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.t, false);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "UrlBookmarkCreator")
    @SafeParcelable.Reserved({1})
    public class UrlBookmark extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new SY2();
        public String t;
        public String u;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.t, false);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    @SafeParcelable.Class(creator = "WiFiCreator")
    @SafeParcelable.Reserved({1})
    public class WiFi extends AbstractSafeParcelable {

        @RecentlyNonNull
        public static final Parcelable.Creator CREATOR = new C1035lY2();
        public String t;
        public String u;
        public int v;

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
            SafeParcelWriter.writeString(parcel, 2, this.t, false);
            SafeParcelWriter.writeString(parcel, 3, this.u, false);
            SafeParcelWriter.writeInt(parcel, 4, this.v);
            SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
        }
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        int iBeginObjectHeader = SafeParcelWriter.beginObjectHeader(parcel);
        SafeParcelWriter.writeInt(parcel, 2, this.t);
        SafeParcelWriter.writeString(parcel, 3, this.u, false);
        SafeParcelWriter.writeString(parcel, 4, this.v, false);
        SafeParcelWriter.writeInt(parcel, 5, this.w);
        SafeParcelWriter.writeTypedArray(parcel, 6, this.x, i, false);
        SafeParcelWriter.writeParcelable(parcel, 7, this.y, i, false);
        SafeParcelWriter.writeParcelable(parcel, 8, this.z, i, false);
        SafeParcelWriter.writeParcelable(parcel, 9, this.A, i, false);
        SafeParcelWriter.writeParcelable(parcel, 10, this.B, i, false);
        SafeParcelWriter.writeParcelable(parcel, 11, this.C, i, false);
        SafeParcelWriter.writeParcelable(parcel, 12, this.D, i, false);
        SafeParcelWriter.writeParcelable(parcel, 13, this.E, i, false);
        SafeParcelWriter.writeParcelable(parcel, 14, this.F, i, false);
        SafeParcelWriter.writeParcelable(parcel, 15, this.G, i, false);
        SafeParcelWriter.writeByteArray(parcel, 16, this.H, false);
        SafeParcelWriter.writeBoolean(parcel, 17, this.I);
        SafeParcelWriter.finishObjectHeader(parcel, iBeginObjectHeader);
    }
}
