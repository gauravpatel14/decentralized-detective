package androidx.core.graphics.drawable;

import android.content.res.ColorStateList;
import android.graphics.PorterDuff;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.AbstractC1581un2;
import defpackage.C1637vn2;
import java.nio.charset.Charset;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class IconCompatParcelizer {
    /* JADX WARN: Can't fix incorrect switch cases order, some code will duplicate */
    public static IconCompat read(AbstractC1581un2 abstractC1581un2) {
        IconCompat iconCompat = new IconCompat();
        iconCompat.a = -1;
        byte[] bArr = null;
        iconCompat.c = null;
        iconCompat.d = null;
        iconCompat.e = 0;
        iconCompat.f = 0;
        iconCompat.g = null;
        iconCompat.h = IconCompat.k;
        iconCompat.i = null;
        iconCompat.a = abstractC1581un2.f(-1, 1);
        byte[] bArr2 = iconCompat.c;
        if (abstractC1581un2.e(2)) {
            Parcel parcel = ((C1637vn2) abstractC1581un2).e;
            int i = parcel.readInt();
            if (i >= 0) {
                bArr = new byte[i];
                parcel.readByteArray(bArr);
            }
            bArr2 = bArr;
        }
        iconCompat.c = bArr2;
        iconCompat.d = abstractC1581un2.g(iconCompat.d, 3);
        iconCompat.e = abstractC1581un2.f(iconCompat.e, 4);
        iconCompat.f = abstractC1581un2.f(iconCompat.f, 5);
        iconCompat.g = (ColorStateList) abstractC1581un2.g(iconCompat.g, 6);
        String string = iconCompat.i;
        if (abstractC1581un2.e(7)) {
            string = ((C1637vn2) abstractC1581un2).e.readString();
        }
        iconCompat.i = string;
        String string2 = iconCompat.j;
        if (abstractC1581un2.e(8)) {
            string2 = ((C1637vn2) abstractC1581un2).e.readString();
        }
        iconCompat.j = string2;
        iconCompat.h = PorterDuff.Mode.valueOf(iconCompat.i);
        switch (iconCompat.a) {
            case -1:
                Parcelable parcelable = iconCompat.d;
                if (parcelable == null) {
                    throw new IllegalArgumentException("Invalid icon");
                }
                iconCompat.b = parcelable;
                return iconCompat;
            case 0:
            default:
                return iconCompat;
            case 1:
            case 5:
                Parcelable parcelable2 = iconCompat.d;
                if (parcelable2 != null) {
                    iconCompat.b = parcelable2;
                } else {
                    byte[] bArr3 = iconCompat.c;
                    iconCompat.b = bArr3;
                    iconCompat.a = 3;
                    iconCompat.e = 0;
                    iconCompat.f = bArr3.length;
                }
                return iconCompat;
            case 2:
            case 4:
            case 6:
                String str = new String(iconCompat.c, Charset.forName("UTF-16"));
                iconCompat.b = str;
                if (iconCompat.a == 2 && iconCompat.j == null) {
                    iconCompat.j = str.split(":", -1)[0];
                }
                return iconCompat;
            case 3:
                iconCompat.b = iconCompat.c;
                return iconCompat;
        }
    }

    public static void write(IconCompat iconCompat, AbstractC1581un2 abstractC1581un2) {
        abstractC1581un2.getClass();
        iconCompat.i = iconCompat.h.name();
        switch (iconCompat.a) {
            case -1:
                iconCompat.d = (Parcelable) iconCompat.b;
                break;
            case 1:
            case 5:
                iconCompat.d = (Parcelable) iconCompat.b;
                break;
            case 2:
                iconCompat.c = ((String) iconCompat.b).getBytes(Charset.forName("UTF-16"));
                break;
            case 3:
                iconCompat.c = (byte[]) iconCompat.b;
                break;
            case 4:
            case 6:
                iconCompat.c = iconCompat.b.toString().getBytes(Charset.forName("UTF-16"));
                break;
        }
        int i = iconCompat.a;
        if (-1 != i) {
            abstractC1581un2.j(i, 1);
        }
        byte[] bArr = iconCompat.c;
        if (bArr != null) {
            abstractC1581un2.i(2);
            int length = bArr.length;
            Parcel parcel = ((C1637vn2) abstractC1581un2).e;
            parcel.writeInt(length);
            parcel.writeByteArray(bArr);
        }
        Parcelable parcelable = iconCompat.d;
        if (parcelable != null) {
            abstractC1581un2.k(parcelable, 3);
        }
        int i2 = iconCompat.e;
        if (i2 != 0) {
            abstractC1581un2.j(i2, 4);
        }
        int i3 = iconCompat.f;
        if (i3 != 0) {
            abstractC1581un2.j(i3, 5);
        }
        ColorStateList colorStateList = iconCompat.g;
        if (colorStateList != null) {
            abstractC1581un2.k(colorStateList, 6);
        }
        String str = iconCompat.i;
        if (str != null) {
            abstractC1581un2.i(7);
            ((C1637vn2) abstractC1581un2).e.writeString(str);
        }
        String str2 = iconCompat.j;
        if (str2 != null) {
            abstractC1581un2.i(8);
            ((C1637vn2) abstractC1581un2).e.writeString(str2);
        }
    }
}
