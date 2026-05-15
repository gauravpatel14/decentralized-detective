package androidx.fragment.app;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import defpackage.Ii0;
import defpackage.mm;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class BackStackRecordState implements Parcelable {
    public static final Parcelable.Creator CREATOR = new mm();
    public final int A;
    public final CharSequence B;
    public final int C;
    public final CharSequence D;
    public final ArrayList E;
    public final ArrayList F;
    public final boolean G;
    public final int[] t;
    public final ArrayList u;
    public final int[] v;
    public final int[] w;
    public final int x;
    public final String y;
    public final int z;

    public BackStackRecordState(a aVar) {
        int size = aVar.a.size();
        this.t = new int[size * 6];
        if (!aVar.g) {
            throw new IllegalStateException("Not on back stack");
        }
        this.u = new ArrayList(size);
        this.v = new int[size];
        this.w = new int[size];
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            Ii0 ii0 = (Ii0) aVar.a.get(i2);
            int i3 = i + 1;
            this.t[i] = ii0.a;
            ArrayList arrayList = this.u;
            n nVar = ii0.b;
            arrayList.add(nVar != null ? nVar.mWho : null);
            int[] iArr = this.t;
            iArr[i3] = ii0.c ? 1 : 0;
            iArr[i + 2] = ii0.d;
            iArr[i + 3] = ii0.e;
            int i4 = i + 5;
            iArr[i + 4] = ii0.f;
            i += 6;
            iArr[i4] = ii0.g;
            this.v[i2] = ii0.h.ordinal();
            this.w[i2] = ii0.i.ordinal();
        }
        this.x = aVar.f;
        this.y = aVar.i;
        this.z = aVar.t;
        this.A = aVar.j;
        this.B = aVar.k;
        this.C = aVar.l;
        this.D = aVar.m;
        this.E = aVar.n;
        this.F = aVar.o;
        this.G = aVar.p;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeIntArray(this.t);
        parcel.writeStringList(this.u);
        parcel.writeIntArray(this.v);
        parcel.writeIntArray(this.w);
        parcel.writeInt(this.x);
        parcel.writeString(this.y);
        parcel.writeInt(this.z);
        parcel.writeInt(this.A);
        TextUtils.writeToParcel(this.B, parcel, 0);
        parcel.writeInt(this.C);
        TextUtils.writeToParcel(this.D, parcel, 0);
        parcel.writeStringList(this.E);
        parcel.writeStringList(this.F);
        parcel.writeInt(this.G ? 1 : 0);
    }

    public BackStackRecordState(Parcel parcel) {
        this.t = parcel.createIntArray();
        this.u = parcel.createStringArrayList();
        this.v = parcel.createIntArray();
        this.w = parcel.createIntArray();
        this.x = parcel.readInt();
        this.y = parcel.readString();
        this.z = parcel.readInt();
        this.A = parcel.readInt();
        Parcelable.Creator creator = TextUtils.CHAR_SEQUENCE_CREATOR;
        this.B = (CharSequence) creator.createFromParcel(parcel);
        this.C = parcel.readInt();
        this.D = (CharSequence) creator.createFromParcel(parcel);
        this.E = parcel.createStringArrayList();
        this.F = parcel.createStringArrayList();
        this.G = parcel.readInt() != 0;
    }
}
