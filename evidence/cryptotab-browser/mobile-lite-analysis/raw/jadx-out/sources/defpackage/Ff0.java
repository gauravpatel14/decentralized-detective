package defpackage;

import android.content.Intent;
import com.google.android.gms.common.internal.Preconditions;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Ff0 {
    public final String a = Preconditions.checkNotEmpty("MESSAGE_DELIVERED", "evenType must be non-null");
    public final Intent b;

    public Ff0(Intent intent) {
        this.b = (Intent) Preconditions.checkNotNull(intent, "intent must be non-null");
    }
}
