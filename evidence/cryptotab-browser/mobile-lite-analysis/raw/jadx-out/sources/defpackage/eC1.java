package defpackage;

import android.content.res.Resources;
import android.graphics.Rect;
import android.view.View;
import androidx.appcompat.widget.SearchView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class eC1 implements View.OnLayoutChangeListener {
    public final /* synthetic */ SearchView t;

    public eC1(SearchView searchView) {
        this.t = searchView;
    }

    @Override // android.view.View.OnLayoutChangeListener
    public final void onLayoutChange(View view, int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8) {
        SearchView searchView = this.t;
        View view2 = searchView.Q;
        if (view2.getWidth() > 1) {
            Resources resources = searchView.getContext().getResources();
            int paddingLeft = searchView.K.getPaddingLeft();
            Rect rect = new Rect();
            boolean z = Jp2.a;
            boolean z2 = searchView.getLayoutDirection() == 1;
            int dimensionPixelSize = searchView.f0 ? resources.getDimensionPixelSize(Hp1.abc_dropdownitem_text_padding_left) + resources.getDimensionPixelSize(Hp1.abc_dropdownitem_icon_width) : 0;
            SearchView.SearchAutoComplete searchAutoComplete = searchView.I;
            searchAutoComplete.getDropDownBackground().getPadding(rect);
            searchAutoComplete.setDropDownHorizontalOffset(z2 ? -rect.left : paddingLeft - (rect.left + dimensionPixelSize));
            searchAutoComplete.setDropDownWidth((((view2.getWidth() + rect.left) + rect.right) + dimensionPixelSize) - paddingLeft);
        }
    }
}
