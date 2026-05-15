package defpackage;

import J.N;
import android.database.ContentObserver;
import android.os.Handler;
import org.chromium.media.AudioManagerAndroid;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Kg extends ContentObserver {
    public final /* synthetic */ AudioManagerAndroid a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public Kg(AudioManagerAndroid audioManagerAndroid, Handler handler) {
        super(handler);
        this.a = audioManagerAndroid;
    }

    @Override // android.database.ContentObserver
    public final void onChange(boolean z) {
        super.onChange(z);
        AudioManagerAndroid audioManagerAndroid = this.a;
        int streamVolume = audioManagerAndroid.a.getStreamVolume(0);
        N._V_ZJO(28, streamVolume == 0, audioManagerAndroid.b, audioManagerAndroid);
    }
}
