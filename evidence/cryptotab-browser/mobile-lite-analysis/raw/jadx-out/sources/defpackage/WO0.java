package defpackage;

import android.content.ComponentName;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class WO0 {
    public final ComponentName a;

    public WO0(ComponentName componentName) {
        this.a = componentName;
    }

    public final String toString() {
        return "ProviderMetadata{ componentName=" + this.a.flattenToShortString() + " }";
    }
}
