package defpackage;

import android.content.Intent;
import android.os.IBinder;

/* JADX INFO: renamed from: iN1, reason: case insensitive filesystem */
/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public abstract class AbstractC0835iN1 {
    public AbstractServiceC0894jN1 a;

    public abstract IBinder a();

    public int e(Intent intent, int i, int i2) {
        return AbstractServiceC0894jN1.a(this.a, intent, i, i2);
    }

    public boolean g(Intent intent) {
        return AbstractServiceC0894jN1.b(this.a, intent);
    }

    public void b() {
    }

    public void c() {
    }

    public void d() {
    }

    public void f() {
    }
}
