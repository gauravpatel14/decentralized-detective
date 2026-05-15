package org.chromium.content.common;

import android.os.Parcel;
import android.os.Parcelable;
import android.view.Surface;
import android.view.SurfaceControl;
import defpackage.vS1;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class SurfaceWrapper implements Parcelable {
    public static final Parcelable.Creator CREATOR = new vS1();
    public final boolean t;
    public Surface u;
    public final boolean v;
    public SurfaceControl w;

    public SurfaceWrapper(Surface surface, boolean z) {
        this.t = true;
        this.u = surface;
        this.v = z;
        this.w = null;
    }

    public static SurfaceWrapper create(Surface surface, boolean z) {
        return new SurfaceWrapper(surface, z);
    }

    public static SurfaceWrapper createFromSurfaceControl(SurfaceControl surfaceControl) {
        return new SurfaceWrapper(surfaceControl);
    }

    public final boolean canBeUsedWithSurfaceControl() {
        return this.v;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final boolean getWrapsSurface() {
        return this.t;
    }

    public final Surface takeSurface() {
        Surface surface = this.u;
        this.u = null;
        return surface;
    }

    public final SurfaceControl takeSurfaceControl() {
        SurfaceControl surfaceControl = this.w;
        this.w = null;
        return surfaceControl;
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        boolean z = this.t;
        parcel.writeInt(z ? 1 : 0);
        if (!z) {
            this.w.writeToParcel(parcel, 0);
        } else {
            this.u.writeToParcel(parcel, 0);
            parcel.writeInt(this.v ? 1 : 0);
        }
    }

    public SurfaceWrapper(SurfaceControl surfaceControl) {
        this.t = false;
        this.u = null;
        this.v = true;
        this.w = surfaceControl;
    }
}
