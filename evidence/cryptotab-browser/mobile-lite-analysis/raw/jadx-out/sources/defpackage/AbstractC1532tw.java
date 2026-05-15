package defpackage;

import org.chromium.base.shared_preferences.SharedPreferencesManager;

/* JADX INFO: renamed from: tw, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC1532tw {
    public static final HB0 a = new HB0("Chrome.Flags.CachedFlag.*");
    public static final HB0 b = new HB0("Chrome.Flags.FieldTrialParamCached.*");

    static {
        int i = AbstractC1872zv.a;
    }

    public static SharedPreferencesManager a() {
        SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.a;
        int i = AbstractC1872zv.a;
        return SharedPreferencesManager.a;
    }
}
