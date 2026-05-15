package android.support.v4.media;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.media.MediaDescription;
import android.net.Uri;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import defpackage.CP0;
import defpackage.ZM0;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class MediaDescriptionCompat implements Parcelable {
    public static final Parcelable.Creator CREATOR = new ZM0();
    public final Uri A;
    public MediaDescription B;
    public final String t;
    public final CharSequence u;
    public final CharSequence v;
    public final CharSequence w;
    public final Bitmap x;
    public final Uri y;
    public final Bundle z;

    public MediaDescriptionCompat(String str, CharSequence charSequence, CharSequence charSequence2, CharSequence charSequence3, Bitmap bitmap, Uri uri, Bundle bundle, Uri uri2) {
        this.t = str;
        this.u = charSequence;
        this.v = charSequence2;
        this.w = charSequence3;
        this.x = bitmap;
        this.y = uri;
        this.z = bundle;
        this.A = uri2;
    }

    public static MediaDescriptionCompat a(Object obj) {
        Bundle bundle;
        if (obj == null) {
            return null;
        }
        MediaDescription mediaDescription = (MediaDescription) obj;
        String mediaId = mediaDescription.getMediaId();
        CharSequence title = mediaDescription.getTitle();
        CharSequence subtitle = mediaDescription.getSubtitle();
        CharSequence description = mediaDescription.getDescription();
        Bitmap iconBitmap = mediaDescription.getIconBitmap();
        Uri iconUri = mediaDescription.getIconUri();
        Bundle bundleD = CP0.d(mediaDescription.getExtras());
        if (bundleD != null) {
            bundleD = new Bundle(bundleD);
        }
        Uri mediaUri = bundleD != null ? (Uri) bundleD.getParcelable("android.support.v4.media.description.MEDIA_URI") : null;
        if (mediaUri == null) {
            bundle = bundleD;
        } else if (bundleD.containsKey("android.support.v4.media.description.NULL_BUNDLE_FLAG") && bundleD.size() == 2) {
            bundle = null;
        } else {
            bundleD.remove("android.support.v4.media.description.MEDIA_URI");
            bundleD.remove("android.support.v4.media.description.NULL_BUNDLE_FLAG");
            bundle = bundleD;
        }
        if (mediaUri == null) {
            mediaUri = mediaDescription.getMediaUri();
        }
        MediaDescriptionCompat mediaDescriptionCompat = new MediaDescriptionCompat(mediaId, title, subtitle, description, iconBitmap, iconUri, bundle, mediaUri);
        mediaDescriptionCompat.B = mediaDescription;
        return mediaDescriptionCompat;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return ((Object) this.u) + ", " + ((Object) this.v) + ", " + ((Object) this.w);
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        MediaDescription mediaDescriptionBuild = this.B;
        if (mediaDescriptionBuild == null) {
            MediaDescription.Builder builder = new MediaDescription.Builder();
            builder.setMediaId(this.t);
            builder.setTitle(this.u);
            builder.setSubtitle(this.v);
            builder.setDescription(this.w);
            builder.setIconBitmap(this.x);
            builder.setIconUri(this.y);
            builder.setExtras(this.z);
            builder.setMediaUri(this.A);
            mediaDescriptionBuild = builder.build();
            this.B = mediaDescriptionBuild;
        }
        mediaDescriptionBuild.writeToParcel(parcel, i);
    }
}
