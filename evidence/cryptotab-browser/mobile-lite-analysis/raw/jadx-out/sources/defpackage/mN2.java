package defpackage;

import android.content.SharedPreferences;
import java.util.concurrent.Callable;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class mN2 implements Callable {
    public final /* synthetic */ SharedPreferences a;
    public final /* synthetic */ String b;
    public final /* synthetic */ Integer c;

    public mN2(SharedPreferences sharedPreferences, String str, Integer num) {
        this.a = sharedPreferences;
        this.b = str;
        this.c = num;
    }

    @Override // java.util.concurrent.Callable
    public final /* synthetic */ Object call() {
        return Integer.valueOf(this.a.getInt(this.b, this.c.intValue()));
    }
}
