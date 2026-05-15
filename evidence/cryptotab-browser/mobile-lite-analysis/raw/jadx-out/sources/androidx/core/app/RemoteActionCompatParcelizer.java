package androidx.core.app;

import android.app.PendingIntent;
import android.os.Parcel;
import android.text.TextUtils;
import androidx.core.graphics.drawable.IconCompat;
import defpackage.AbstractC1581un2;
import defpackage.C1637vn2;
import defpackage.InterfaceC1694wn2;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class RemoteActionCompatParcelizer {
    public static RemoteActionCompat read(AbstractC1581un2 abstractC1581un2) {
        RemoteActionCompat remoteActionCompat = new RemoteActionCompat();
        InterfaceC1694wn2 interfaceC1694wn2H = remoteActionCompat.a;
        if (abstractC1581un2.e(1)) {
            interfaceC1694wn2H = abstractC1581un2.h();
        }
        remoteActionCompat.a = (IconCompat) interfaceC1694wn2H;
        CharSequence charSequence = remoteActionCompat.b;
        if (abstractC1581un2.e(2)) {
            charSequence = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C1637vn2) abstractC1581un2).e);
        }
        remoteActionCompat.b = charSequence;
        CharSequence charSequence2 = remoteActionCompat.c;
        if (abstractC1581un2.e(3)) {
            charSequence2 = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(((C1637vn2) abstractC1581un2).e);
        }
        remoteActionCompat.c = charSequence2;
        remoteActionCompat.d = (PendingIntent) abstractC1581un2.g(remoteActionCompat.d, 4);
        boolean z = remoteActionCompat.e;
        if (abstractC1581un2.e(5)) {
            z = ((C1637vn2) abstractC1581un2).e.readInt() != 0;
        }
        remoteActionCompat.e = z;
        boolean z2 = remoteActionCompat.f;
        if (abstractC1581un2.e(6)) {
            z2 = ((C1637vn2) abstractC1581un2).e.readInt() != 0;
        }
        remoteActionCompat.f = z2;
        return remoteActionCompat;
    }

    public static void write(RemoteActionCompat remoteActionCompat, AbstractC1581un2 abstractC1581un2) {
        abstractC1581un2.getClass();
        IconCompat iconCompat = remoteActionCompat.a;
        abstractC1581un2.i(1);
        abstractC1581un2.l(iconCompat);
        CharSequence charSequence = remoteActionCompat.b;
        abstractC1581un2.i(2);
        Parcel parcel = ((C1637vn2) abstractC1581un2).e;
        TextUtils.writeToParcel(charSequence, parcel, 0);
        CharSequence charSequence2 = remoteActionCompat.c;
        abstractC1581un2.i(3);
        TextUtils.writeToParcel(charSequence2, parcel, 0);
        abstractC1581un2.k(remoteActionCompat.d, 4);
        boolean z = remoteActionCompat.e;
        abstractC1581un2.i(5);
        parcel.writeInt(z ? 1 : 0);
        boolean z2 = remoteActionCompat.f;
        abstractC1581un2.i(6);
        parcel.writeInt(z2 ? 1 : 0);
    }
}
