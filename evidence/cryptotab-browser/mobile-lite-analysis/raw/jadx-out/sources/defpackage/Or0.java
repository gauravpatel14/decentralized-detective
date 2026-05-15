package defpackage;

import android.os.Bundle;
import android.os.IInterface;
import android.support.v4.media.MediaMetadataCompat;
import android.support.v4.media.session.ParcelableVolumeInfo;
import android.support.v4.media.session.PlaybackStateCompat;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public interface Or0 extends IInterface {
    void N0(PlaybackStateCompat playbackStateCompat);

    void U0(ParcelableVolumeInfo parcelableVolumeInfo);

    void V(Bundle bundle);

    void a0(ArrayList arrayList);

    void g(CharSequence charSequence);

    void m();

    void p(MediaMetadataCompat mediaMetadataCompat);
}
