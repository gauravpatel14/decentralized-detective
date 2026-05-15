package defpackage;

import android.os.Build;
import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import android.view.SurfaceControl;
import org.chromium.content.common.SurfaceWrapper;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class vS1 implements Parcelable.Creator {
    @Override // android.os.Parcelable.Creator
    public final Object createFromParcel(Parcel parcel) {
        if (parcel.readInt() == 1) {
            return new SurfaceWrapper((Surface) Surface.CREATOR.createFromParcel(parcel), parcel.readInt() == 1);
        }
        if (Build.VERSION.SDK_INT >= 29) {
            return new SurfaceWrapper(uS1.b(SurfaceControl.CREATOR.createFromParcel(parcel)));
        }
        throw new RuntimeException("not reached");
    }

    @Override // android.os.Parcelable.Creator
    public final Object[] newArray(int i) {
        return new SurfaceWrapper[i];
    }
}
