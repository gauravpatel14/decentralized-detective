package defpackage;

import android.os.Bundle;
import android.support.v4.media.MediaMetadataCompat;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class CN0 {
    public final Bundle a = new Bundle();

    public final MediaMetadataCompat a() {
        return new MediaMetadataCompat(this.a);
    }

    public final void b(String str, String str2) {
        gf gfVar = MediaMetadataCompat.w;
        if (gfVar.containsKey(str) && ((Integer) gfVar.get(str)).intValue() != 1) {
            throw new IllegalArgumentException(BN0.a("The ", str, " key cannot be used to put a String"));
        }
        this.a.putCharSequence(str, str2);
    }
}
