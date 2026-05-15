package androidx.customview.view;

import android.annotation.SuppressLint;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.C0872j;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public abstract class AbsSavedState implements Parcelable {
    public final Parcelable t;
    public static final AnonymousClass1 u = new AnonymousClass1();
    public static final Parcelable.Creator CREATOR = new C0872j();

    /* JADX INFO: renamed from: androidx.customview.view.AbsSavedState$1, reason: invalid class name */
    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public class AnonymousClass1 extends AbsSavedState {
    }

    public AbsSavedState() {
        this.t = null;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        parcel.writeParcelable(this.t, i);
    }

    public AbsSavedState(Parcelable parcelable) {
        if (parcelable != null) {
            this.t = parcelable == u ? null : parcelable;
            return;
        }
        throw new IllegalArgumentException("superState must not be null");
    }

    public AbsSavedState(Parcel parcel, ClassLoader classLoader) {
        Parcelable parcelable = parcel.readParcelable(classLoader);
        this.t = parcelable == null ? u : parcelable;
    }
}
