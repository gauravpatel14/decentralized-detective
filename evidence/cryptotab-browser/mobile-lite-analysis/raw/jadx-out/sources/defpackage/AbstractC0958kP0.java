package defpackage;

import android.media.MediaRoute2Info;
import java.util.Set;

/* JADX INFO: renamed from: kP0, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0958kP0 {
    public static Set a(MediaRoute2Info mediaRoute2Info) {
        return mediaRoute2Info.getDeduplicationIds();
    }

    public static int b(MediaRoute2Info mediaRoute2Info) {
        return mediaRoute2Info.getType();
    }
}
