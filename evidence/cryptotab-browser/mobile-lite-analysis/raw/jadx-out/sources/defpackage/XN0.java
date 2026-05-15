package defpackage;

import com.google.android.gms.cast.MediaInfo;
import com.google.android.gms.cast.MediaQueueItem;
import org.json.JSONObject;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class XN0 {
    public final MediaQueueItem a;

    public XN0(MediaInfo mediaInfo) {
        MediaQueueItem mediaQueueItem = new MediaQueueItem(mediaInfo, 0, true, Double.NaN, Double.POSITIVE_INFINITY, 0.0d, null, null);
        if (mediaInfo == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        this.a = mediaQueueItem;
    }

    public final MediaQueueItem a() {
        MediaQueueItem mediaQueueItem = this.a;
        if (mediaQueueItem.t == null) {
            throw new IllegalArgumentException("media cannot be null.");
        }
        if (!Double.isNaN(mediaQueueItem.w) && mediaQueueItem.w < 0.0d) {
            throw new IllegalArgumentException("startTime cannot be negative or NaN.");
        }
        if (Double.isNaN(mediaQueueItem.x)) {
            throw new IllegalArgumentException("playbackDuration cannot be NaN.");
        }
        if (Double.isNaN(mediaQueueItem.y) || mediaQueueItem.y < 0.0d) {
            throw new IllegalArgumentException("preloadTime cannot be negative or Nan.");
        }
        return mediaQueueItem;
    }

    public XN0(JSONObject jSONObject) {
        this.a = new MediaQueueItem(jSONObject);
    }
}
