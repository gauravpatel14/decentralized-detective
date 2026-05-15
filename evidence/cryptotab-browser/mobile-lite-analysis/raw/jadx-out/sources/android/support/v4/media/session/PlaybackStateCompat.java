package android.support.v4.media.session;

import android.annotation.SuppressLint;
import android.media.session.PlaybackState;
import android.os.Bundle;
import android.os.Parcel;
import android.os.Parcelable;
import android.text.TextUtils;
import defpackage.CP0;
import defpackage.lh1;
import java.util.ArrayList;
import java.util.List;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
@SuppressLint({"BanParcelableUsage"})
public final class PlaybackStateCompat implements Parcelable {
    public static final Parcelable.Creator CREATOR = new lh1(0);
    public final long A;
    public final ArrayList B;
    public final long C;
    public final Bundle D;
    public PlaybackState E;
    public final int t;
    public final long u;
    public final long v;
    public final float w;
    public final long x;
    public final int y;
    public final CharSequence z;

    public PlaybackStateCompat(int i, long j, long j2, float f, long j3, int i2, CharSequence charSequence, long j4, ArrayList arrayList, long j5, Bundle bundle) {
        this.t = i;
        this.u = j;
        this.v = j2;
        this.w = f;
        this.x = j3;
        this.y = i2;
        this.z = charSequence;
        this.A = j4;
        this.B = new ArrayList(arrayList);
        this.C = j5;
        this.D = bundle;
    }

    public static PlaybackStateCompat a(PlaybackState playbackState) {
        ArrayList arrayList;
        CustomAction customAction;
        if (playbackState == null) {
            return null;
        }
        List<PlaybackState.CustomAction> customActions = playbackState.getCustomActions();
        if (customActions != null) {
            ArrayList arrayList2 = new ArrayList(customActions.size());
            for (PlaybackState.CustomAction customAction2 : customActions) {
                if (customAction2 != null) {
                    PlaybackState.CustomAction customAction3 = customAction2;
                    Bundle extras = customAction3.getExtras();
                    CP0.a(extras);
                    customAction = new CustomAction(customAction3.getAction(), customAction3.getName(), customAction3.getIcon(), extras);
                    customAction.x = customAction3;
                } else {
                    customAction = null;
                }
                arrayList2.add(customAction);
            }
            arrayList = arrayList2;
        } else {
            arrayList = null;
        }
        Bundle extras2 = playbackState.getExtras();
        CP0.a(extras2);
        PlaybackStateCompat playbackStateCompat = new PlaybackStateCompat(playbackState.getState(), playbackState.getPosition(), playbackState.getBufferedPosition(), playbackState.getPlaybackSpeed(), playbackState.getActions(), 0, playbackState.getErrorMessage(), playbackState.getLastPositionUpdateTime(), arrayList, playbackState.getActiveQueueItemId(), extras2);
        playbackStateCompat.E = playbackState;
        return playbackStateCompat;
    }

    @Override // android.os.Parcelable
    public final int describeContents() {
        return 0;
    }

    public final String toString() {
        return "PlaybackState {state=" + this.t + ", position=" + this.u + ", buffered position=" + this.v + ", speed=" + this.w + ", updated=" + this.A + ", actions=" + this.x + ", error code=" + this.y + ", error message=" + this.z + ", custom actions=" + this.B + ", active item id=" + this.C + "}";
    }

    @Override // android.os.Parcelable
    public final void writeToParcel(Parcel parcel, int i) {
        parcel.writeInt(this.t);
        parcel.writeLong(this.u);
        parcel.writeFloat(this.w);
        parcel.writeLong(this.A);
        parcel.writeLong(this.v);
        parcel.writeLong(this.x);
        TextUtils.writeToParcel(this.z, parcel, i);
        parcel.writeTypedList(this.B);
        parcel.writeLong(this.C);
        parcel.writeBundle(this.D);
        parcel.writeInt(this.y);
    }

    /* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
    public final class CustomAction implements Parcelable {
        public static final Parcelable.Creator CREATOR = new lh1(1);
        public final String t;
        public final CharSequence u;
        public final int v;
        public final Bundle w;
        public PlaybackState.CustomAction x;

        public CustomAction(String str, CharSequence charSequence, int i, Bundle bundle) {
            this.t = str;
            this.u = charSequence;
            this.v = i;
            this.w = bundle;
        }

        @Override // android.os.Parcelable
        public final int describeContents() {
            return 0;
        }

        public final String toString() {
            return "Action:mName='" + ((Object) this.u) + ", mIcon=" + this.v + ", mExtras=" + this.w;
        }

        @Override // android.os.Parcelable
        public final void writeToParcel(Parcel parcel, int i) {
            parcel.writeString(this.t);
            TextUtils.writeToParcel(this.u, parcel, i);
            parcel.writeInt(this.v);
            parcel.writeBundle(this.w);
        }

        public CustomAction(Parcel parcel) {
            this.t = parcel.readString();
            this.u = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
            this.v = parcel.readInt();
            this.w = parcel.readBundle(CP0.class.getClassLoader());
        }
    }

    public PlaybackStateCompat(Parcel parcel) {
        this.t = parcel.readInt();
        this.u = parcel.readLong();
        this.w = parcel.readFloat();
        this.A = parcel.readLong();
        this.v = parcel.readLong();
        this.x = parcel.readLong();
        this.z = (CharSequence) TextUtils.CHAR_SEQUENCE_CREATOR.createFromParcel(parcel);
        this.B = parcel.createTypedArrayList(CustomAction.CREATOR);
        this.C = parcel.readLong();
        this.D = parcel.readBundle(CP0.class.getClassLoader());
        this.y = parcel.readInt();
    }
}
