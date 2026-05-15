package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.fragment.app.BackStackRecordState;
import androidx.fragment.app.BackStackState;
import androidx.fragment.app.FragmentManager$LaunchedFragmentInfo;
import androidx.fragment.app.FragmentManagerState;
import java.util.ArrayList;

/* JADX INFO: renamed from: qi0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class C1347qi0 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        FragmentManagerState fragmentManagerState = new FragmentManagerState();
        fragmentManagerState.x = null;
        fragmentManagerState.y = new ArrayList();
        fragmentManagerState.z = new ArrayList();
        fragmentManagerState.t = parcel.createStringArrayList();
        fragmentManagerState.u = parcel.createStringArrayList();
        fragmentManagerState.v = (BackStackRecordState[]) parcel.createTypedArray(BackStackRecordState.CREATOR);
        fragmentManagerState.w = parcel.readInt();
        fragmentManagerState.x = parcel.readString();
        fragmentManagerState.y = parcel.createStringArrayList();
        fragmentManagerState.z = parcel.createTypedArrayList(BackStackState.CREATOR);
        fragmentManagerState.A = parcel.createTypedArrayList(FragmentManager$LaunchedFragmentInfo.CREATOR);
        return fragmentManagerState;
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new FragmentManagerState[i];
    }
}
