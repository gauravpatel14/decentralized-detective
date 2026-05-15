package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class iE0 implements RJ0 {
    public final int a;
    public LayoutInflater b;

    public iE0(int i) {
        this.a = i;
    }

    @Override // defpackage.RJ0
    public final View a(ViewGroup viewGroup) {
        if (this.b == null) {
            this.b = LayoutInflater.from(viewGroup.getContext());
        }
        return this.b.inflate(this.a, viewGroup, false);
    }
}
