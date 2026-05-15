package com.google.android.gms.common.internal.safeparcel;

import android.content.Intent;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import com.google.android.gms.common.annotation.KeepForSdk;
import com.google.android.gms.common.internal.Preconditions;
import com.google.android.gms.common.util.Base64Utils;
import defpackage.AbstractC0760hD2;
import java.util.ArrayList;
import java.util.Iterator;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@KeepForSdk
public final class SafeParcelableSerializer {
    private SafeParcelableSerializer() {
    }

    @KeepForSdk
    public static SafeParcelable deserializeFromBytes(byte[] bArr, Parcelable.Creator creator) {
        Preconditions.checkNotNull(creator);
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        SafeParcelable safeParcelable = (SafeParcelable) creator.createFromParcel(parcelObtain);
        parcelObtain.recycle();
        return safeParcelable;
    }

    @KeepForSdk
    public static SafeParcelable deserializeFromIntentExtra(Intent intent, String str, Parcelable.Creator creator) {
        byte[] byteArrayExtra = intent.getByteArrayExtra(str);
        if (byteArrayExtra == null) {
            return null;
        }
        return deserializeFromBytes(byteArrayExtra, creator);
    }

    @KeepForSdk
    public static SafeParcelable deserializeFromString(String str, Parcelable.Creator creator) {
        return deserializeFromBytes(Base64Utils.decodeUrlSafe(str), creator);
    }

    @Deprecated
    public static ArrayList deserializeIterableFromBundle(Bundle bundle, String str, Parcelable.Creator creator) {
        ArrayList arrayList = (ArrayList) bundle.getSerializable(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
        }
        return arrayList2;
    }

    @KeepForSdk
    public static ArrayList deserializeIterableFromBundleSafe(Bundle bundle, String str, Parcelable.Creator creator) {
        return deserializeIterableFromBytes(bundle.getByteArray(str), creator);
    }

    public static ArrayList deserializeIterableFromBytes(byte[] bArr, Parcelable.Creator creator) {
        if (bArr == null) {
            return null;
        }
        Parcel parcelObtain = Parcel.obtain();
        parcelObtain.unmarshall(bArr, 0, bArr.length);
        parcelObtain.setDataPosition(0);
        try {
            ArrayList arrayList = new ArrayList();
            parcelObtain.readTypedList(arrayList, creator);
            return arrayList;
        } finally {
            parcelObtain.recycle();
        }
    }

    @KeepForSdk
    @Deprecated
    public static ArrayList deserializeIterableFromIntentExtra(Intent intent, String str, Parcelable.Creator creator) {
        ArrayList arrayList = (ArrayList) intent.getSerializableExtra(str);
        if (arrayList == null) {
            return null;
        }
        ArrayList arrayList2 = new ArrayList(arrayList.size());
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            arrayList2.add(deserializeFromBytes((byte[]) arrayList.get(i), creator));
        }
        return arrayList2;
    }

    @KeepForSdk
    public static ArrayList deserializeIterableFromIntentExtraSafe(Intent intent, String str, Parcelable.Creator creator) {
        return deserializeIterableFromBytes(intent.getByteArrayExtra(str), creator);
    }

    @Deprecated
    public static void serializeIterableToBundle(Iterable iterable, Bundle bundle, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes((SafeParcelable) it.next()));
        }
        bundle.putSerializable(str, arrayList);
    }

    public static void serializeIterableToBundleSafe(Iterable iterable, Bundle bundle, String str) {
        bundle.putByteArray(str, zza(iterable));
    }

    @KeepForSdk
    @Deprecated
    public static void serializeIterableToIntentExtra(Iterable iterable, Intent intent, String str) {
        ArrayList arrayList = new ArrayList();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            arrayList.add(serializeToBytes((SafeParcelable) it.next()));
        }
        intent.putExtra(str, arrayList);
    }

    @KeepForSdk
    public static void serializeIterableToIntentExtraSafe(Iterable iterable, Intent intent, String str) {
        intent.putExtra(str, zza(iterable));
    }

    @KeepForSdk
    public static byte[] serializeToBytes(SafeParcelable safeParcelable) {
        Parcel parcelObtain = Parcel.obtain();
        safeParcelable.writeToParcel(parcelObtain, 0);
        byte[] bArrMarshall = parcelObtain.marshall();
        parcelObtain.recycle();
        return bArrMarshall;
    }

    @KeepForSdk
    public static void serializeToIntentExtra(SafeParcelable safeParcelable, Intent intent, String str) {
        intent.putExtra(str, serializeToBytes(safeParcelable));
    }

    @KeepForSdk
    public static String serializeToString(SafeParcelable safeParcelable) {
        return Base64Utils.encodeUrlSafe(serializeToBytes(safeParcelable));
    }

    private static byte[] zza(Iterable iterable) {
        Parcel parcelObtain = Parcel.obtain();
        try {
            parcelObtain.writeTypedList(AbstractC0760hD2.u(iterable));
            return parcelObtain.marshall();
        } finally {
            parcelObtain.recycle();
        }
    }
}
