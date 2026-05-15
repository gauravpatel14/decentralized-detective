package defpackage;

import android.text.StaticLayout;
import android.widget.TextView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Sb extends Qb {
    @Override // defpackage.Tb
    public boolean a(TextView textView) {
        return textView.isHorizontallyScrollable();
    }

    @Override // defpackage.Qb
    public void b(StaticLayout.Builder builder, TextView textView) {
        builder.setTextDirection(textView.getTextDirectionHeuristic());
    }
}
