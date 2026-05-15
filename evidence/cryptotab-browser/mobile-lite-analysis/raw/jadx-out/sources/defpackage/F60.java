package defpackage;

import android.text.InputFilter;
import android.text.method.TransformationMethod;
import android.widget.TextView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class F60 extends E60 {
    public final D60 a;

    public F60(TextView textView) {
        this.a = new D60(textView);
    }

    @Override // defpackage.E60
    public final boolean b() {
        return this.a.c;
    }

    @Override // defpackage.E60
    public final void d(boolean z) {
        this.a.c = z;
    }

    @Override // defpackage.E60
    public final InputFilter[] a(InputFilter[] inputFilterArr) {
        return inputFilterArr;
    }

    @Override // defpackage.E60
    public final void c(boolean z) {
    }

    @Override // defpackage.E60
    public final TransformationMethod e(TransformationMethod transformationMethod) {
        return transformationMethod;
    }
}
