package defpackage;

import android.content.Context;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Mf extends LayoutInflater {
    public static final String[] a = {"android.widget.", "android.webkit.", "android.app."};

    public Mf(Context context) {
        super(context);
    }

    @Override // android.view.LayoutInflater
    public final LayoutInflater cloneInContext(Context context) {
        return new Mf(context);
    }

    @Override // android.view.LayoutInflater
    public final View onCreateView(String str, AttributeSet attributeSet) {
        View viewCreateView;
        String[] strArr = a;
        for (int i = 0; i < 3; i++) {
            try {
                viewCreateView = createView(str, strArr[i], attributeSet);
            } catch (ClassNotFoundException unused) {
            }
            if (viewCreateView != null) {
                return viewCreateView;
            }
        }
        return super.onCreateView(str, attributeSet);
    }
}
