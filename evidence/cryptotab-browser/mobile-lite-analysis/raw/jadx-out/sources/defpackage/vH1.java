package defpackage;

import android.content.SharedPreferences;
import java.util.Set;
import org.chromium.base.shared_preferences.SharedPreferencesManager;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class vH1 implements SharedPreferences.Editor {
    public final SharedPreferences.Editor a;
    public final /* synthetic */ SharedPreferencesManager b;

    public vH1(SharedPreferencesManager sharedPreferencesManager, SharedPreferences.Editor editor) {
        this.b = sharedPreferencesManager;
        this.a = editor;
    }

    @Override // android.content.SharedPreferences.Editor
    public final void apply() {
        this.a.apply();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor clear() {
        this.a.clear();
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final boolean commit() {
        return this.a.commit();
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putBoolean(String str, boolean z) {
        SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.a;
        this.b.getClass();
        this.a.putBoolean(str, z);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putFloat(String str, float f) {
        SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.a;
        this.b.getClass();
        this.a.putFloat(str, f);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putInt(String str, int i) {
        SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.a;
        this.b.getClass();
        this.a.putInt(str, i);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putLong(String str, long j) {
        SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.a;
        this.b.getClass();
        this.a.putLong(str, j);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putString(String str, String str2) {
        SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.a;
        this.b.getClass();
        this.a.putString(str, str2);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor putStringSet(String str, Set set) {
        SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.a;
        this.b.getClass();
        this.a.putStringSet(str, set);
        return this;
    }

    @Override // android.content.SharedPreferences.Editor
    public final SharedPreferences.Editor remove(String str) {
        SharedPreferencesManager sharedPreferencesManager = SharedPreferencesManager.a;
        this.b.getClass();
        this.a.remove(str);
        return this;
    }
}
