package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;

/* JADX INFO: renamed from: li0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1045li0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        FragmentManager$LaunchedFragmentInfo fragmentManager$LaunchedFragmentInfo = new FragmentManager$LaunchedFragmentInfo();
        fragmentManager$LaunchedFragmentInfo.t = parcel.readString();
        fragmentManager$LaunchedFragmentInfo.u = parcel.readInt();
        return fragmentManager$LaunchedFragmentInfo;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new FragmentManager$LaunchedFragmentInfo[i];
    }
}
