package defpackage;

import android.os.Parcel;
import android.os.Parcelable;
import androidx.recyclerview.widget.StaggeredGridLayoutManager;
import androidx.recyclerview.widget.StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class LN1 implements Parcelable.Creator {
    public final /* synthetic */ int a;

    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        switch (this.a) {
            case 0:
                StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem staggeredGridLayoutManager$LazySpanLookup$FullSpanItem = new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem();
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.t = parcel.readInt();
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.u = parcel.readInt();
                staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.w = parcel.readInt() == 1;
                int i = parcel.readInt();
                if (i > 0) {
                    int[] iArr = new int[i];
                    staggeredGridLayoutManager$LazySpanLookup$FullSpanItem.v = iArr;
                    parcel.readIntArray(iArr);
                }
                return staggeredGridLayoutManager$LazySpanLookup$FullSpanItem;
            default:
                StaggeredGridLayoutManager.SavedState savedState = new StaggeredGridLayoutManager.SavedState();
                savedState.t = parcel.readInt();
                savedState.u = parcel.readInt();
                int i2 = parcel.readInt();
                savedState.v = i2;
                if (i2 > 0) {
                    int[] iArr2 = new int[i2];
                    savedState.w = iArr2;
                    parcel.readIntArray(iArr2);
                }
                int i3 = parcel.readInt();
                savedState.x = i3;
                if (i3 > 0) {
                    int[] iArr3 = new int[i3];
                    savedState.y = iArr3;
                    parcel.readIntArray(iArr3);
                }
                savedState.A = parcel.readInt() == 1;
                savedState.B = parcel.readInt() == 1;
                savedState.C = parcel.readInt() == 1;
                savedState.z = parcel.readArrayList(StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem.class.getClassLoader());
                return savedState;
        }
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        switch (this.a) {
            case 0:
                return new StaggeredGridLayoutManager$LazySpanLookup$FullSpanItem[i];
            default:
                return new StaggeredGridLayoutManager.SavedState[i];
        }
    }
}
