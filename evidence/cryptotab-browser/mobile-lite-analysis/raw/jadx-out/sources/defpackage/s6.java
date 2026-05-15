package defpackage;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.text.TextUtils;
import android.util.TypedValue;
import android.view.KeyEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListAdapter;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;
import androidx.core.widget.NestedScrollView;
import java.util.WeakHashMap;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class s6 extends AbstractDialogC0788hb implements DialogInterface {
    public final q6 y;

    public s6(int i, Context context) {
        super(i(i, context), context);
        this.y = new q6(getContext(), this, getWindow());
    }

    public static int i(int i, Context context) {
        if (((i >>> 24) & 255) >= 1) {
            return i;
        }
        TypedValue typedValue = new TypedValue();
        context.getTheme().resolveAttribute(Ep1.alertDialogTheme, typedValue, true);
        return typedValue.resourceId;
    }

    @Override // defpackage.AbstractDialogC0788hb, defpackage.lI, android.app.Dialog
    public void onCreate(Bundle bundle) {
        int i;
        int i2;
        ListAdapter listAdapter;
        View viewFindViewById;
        super.onCreate(bundle);
        q6 q6Var = this.y;
        q6Var.b.setContentView(q6Var.z);
        int i3 = AbstractC0132Lp1.parentPanel;
        Window window = q6Var.c;
        View viewFindViewById2 = window.findViewById(i3);
        View viewFindViewById3 = viewFindViewById2.findViewById(AbstractC0132Lp1.topPanel);
        View viewFindViewById4 = viewFindViewById2.findViewById(AbstractC0132Lp1.contentPanel);
        View viewFindViewById5 = viewFindViewById2.findViewById(AbstractC0132Lp1.buttonPanel);
        ViewGroup viewGroup = (ViewGroup) viewFindViewById2.findViewById(AbstractC0132Lp1.customPanel);
        View view = q6Var.g;
        if (view == null) {
            view = null;
        }
        boolean z = view != null;
        if (!z || !q6.a(view)) {
            window.setFlags(131072, 131072);
        }
        if (z) {
            FrameLayout frameLayout = (FrameLayout) window.findViewById(AbstractC0132Lp1.custom);
            frameLayout.addView(view, new ViewGroup.LayoutParams(-1, -1));
            if (q6Var.h) {
                frameLayout.setPadding(0, 0, 0, 0);
            }
            if (q6Var.f != null) {
                ((LinearLayout.LayoutParams) ((C1489tF0) viewGroup.getLayoutParams())).weight = 0.0f;
            }
        } else {
            viewGroup.setVisibility(8);
        }
        View viewFindViewById6 = viewGroup.findViewById(AbstractC0132Lp1.topPanel);
        View viewFindViewById7 = viewGroup.findViewById(AbstractC0132Lp1.contentPanel);
        View viewFindViewById8 = viewGroup.findViewById(AbstractC0132Lp1.buttonPanel);
        ViewGroup viewGroupB = q6.b(viewFindViewById6, viewFindViewById3);
        ViewGroup viewGroupB2 = q6.b(viewFindViewById7, viewFindViewById4);
        ViewGroup viewGroupB3 = q6.b(viewFindViewById8, viewFindViewById5);
        NestedScrollView nestedScrollView = (NestedScrollView) window.findViewById(AbstractC0132Lp1.scrollView);
        q6Var.r = nestedScrollView;
        nestedScrollView.setFocusable(false);
        q6Var.r.setNestedScrollingEnabled(false);
        TextView textView = (TextView) viewGroupB2.findViewById(R.id.message);
        q6Var.v = textView;
        if (textView != null) {
            CharSequence charSequence = q6Var.e;
            if (charSequence != null) {
                textView.setText(charSequence);
            } else {
                textView.setVisibility(8);
                q6Var.r.removeView(q6Var.v);
                if (q6Var.f != null) {
                    ViewGroup viewGroup2 = (ViewGroup) q6Var.r.getParent();
                    int iIndexOfChild = viewGroup2.indexOfChild(q6Var.r);
                    viewGroup2.removeViewAt(iIndexOfChild);
                    viewGroup2.addView(q6Var.f, iIndexOfChild, new ViewGroup.LayoutParams(-1, -1));
                } else {
                    viewGroupB2.setVisibility(8);
                }
            }
        }
        Button button = (Button) viewGroupB3.findViewById(R.id.button1);
        q6Var.i = button;
        j6 j6Var = q6Var.G;
        button.setOnClickListener(j6Var);
        if (TextUtils.isEmpty(q6Var.j)) {
            q6Var.i.setVisibility(8);
            i = 0;
        } else {
            q6Var.i.setText(q6Var.j);
            q6Var.i.setVisibility(0);
            i = 1;
        }
        Button button2 = (Button) viewGroupB3.findViewById(R.id.button2);
        q6Var.l = button2;
        button2.setOnClickListener(j6Var);
        if (TextUtils.isEmpty(q6Var.m)) {
            q6Var.l.setVisibility(8);
        } else {
            q6Var.l.setText(q6Var.m);
            q6Var.l.setVisibility(0);
            i |= 2;
        }
        Button button3 = (Button) viewGroupB3.findViewById(R.id.button3);
        q6Var.o = button3;
        button3.setOnClickListener(j6Var);
        if (TextUtils.isEmpty(q6Var.p)) {
            q6Var.o.setVisibility(8);
        } else {
            q6Var.o.setText(q6Var.p);
            q6Var.o.setVisibility(0);
            i |= 4;
        }
        TypedValue typedValue = new TypedValue();
        q6Var.a.getTheme().resolveAttribute(Ep1.alertDialogCenterButtons, typedValue, true);
        if (typedValue.data != 0) {
            if (i == 1) {
                Button button4 = q6Var.i;
                LinearLayout.LayoutParams layoutParams = (LinearLayout.LayoutParams) button4.getLayoutParams();
                layoutParams.gravity = 1;
                layoutParams.weight = 0.5f;
                button4.setLayoutParams(layoutParams);
            } else if (i == 2) {
                Button button5 = q6Var.l;
                LinearLayout.LayoutParams layoutParams2 = (LinearLayout.LayoutParams) button5.getLayoutParams();
                layoutParams2.gravity = 1;
                layoutParams2.weight = 0.5f;
                button5.setLayoutParams(layoutParams2);
            } else if (i == 4) {
                Button button6 = q6Var.o;
                LinearLayout.LayoutParams layoutParams3 = (LinearLayout.LayoutParams) button6.getLayoutParams();
                layoutParams3.gravity = 1;
                layoutParams3.weight = 0.5f;
                button6.setLayoutParams(layoutParams3);
            }
        }
        if (i == 0) {
            viewGroupB3.setVisibility(8);
        }
        if (q6Var.w != null) {
            viewGroupB.addView(q6Var.w, 0, new ViewGroup.LayoutParams(-1, -2));
            window.findViewById(AbstractC0132Lp1.title_template).setVisibility(8);
        } else {
            q6Var.t = (ImageView) window.findViewById(R.id.icon);
            if (TextUtils.isEmpty(q6Var.d) || !q6Var.E) {
                window.findViewById(AbstractC0132Lp1.title_template).setVisibility(8);
                q6Var.t.setVisibility(8);
                viewGroupB.setVisibility(8);
            } else {
                TextView textView2 = (TextView) window.findViewById(AbstractC0132Lp1.alertTitle);
                q6Var.u = textView2;
                textView2.setText(q6Var.d);
                Drawable drawable = q6Var.s;
                if (drawable != null) {
                    q6Var.t.setImageDrawable(drawable);
                } else {
                    q6Var.u.setPadding(q6Var.t.getPaddingLeft(), q6Var.t.getPaddingTop(), q6Var.t.getPaddingRight(), q6Var.t.getPaddingBottom());
                    q6Var.t.setVisibility(8);
                }
            }
        }
        boolean z2 = viewGroup.getVisibility() != 8;
        int i4 = (viewGroupB == null || viewGroupB.getVisibility() == 8) ? 0 : 1;
        boolean z3 = viewGroupB3.getVisibility() != 8;
        if (!z3 && (viewFindViewById = viewGroupB2.findViewById(AbstractC0132Lp1.textSpacerNoButtons)) != null) {
            viewFindViewById.setVisibility(0);
        }
        if (i4 != 0) {
            NestedScrollView nestedScrollView2 = q6Var.r;
            if (nestedScrollView2 != null) {
                nestedScrollView2.setClipToPadding(true);
            }
            View viewFindViewById9 = (q6Var.e == null && q6Var.f == null) ? null : viewGroupB.findViewById(AbstractC0132Lp1.titleDividerNoCustom);
            i2 = 0;
            if (viewFindViewById9 != null) {
                viewFindViewById9.setVisibility(0);
            }
        } else {
            i2 = 0;
            View viewFindViewById10 = viewGroupB2.findViewById(AbstractC0132Lp1.textSpacerNoTitle);
            if (viewFindViewById10 != null) {
                viewFindViewById10.setVisibility(0);
            }
        }
        AlertController$RecycleListView alertController$RecycleListView = q6Var.f;
        if (alertController$RecycleListView != null) {
            alertController$RecycleListView.getClass();
            if (!z3 || i4 == 0) {
                alertController$RecycleListView.setPadding(alertController$RecycleListView.getPaddingLeft(), i4 != 0 ? alertController$RecycleListView.getPaddingTop() : alertController$RecycleListView.t, alertController$RecycleListView.getPaddingRight(), z3 ? alertController$RecycleListView.getPaddingBottom() : alertController$RecycleListView.u);
            }
        }
        if (!z2) {
            View view2 = q6Var.f;
            if (view2 == null) {
                view2 = q6Var.r;
            }
            if (view2 != null) {
                int i5 = i4 | (z3 ? 2 : i2);
                View viewFindViewById11 = window.findViewById(AbstractC0132Lp1.scrollIndicatorUp);
                View viewFindViewById12 = window.findViewById(AbstractC0132Lp1.scrollIndicatorDown);
                WeakHashMap weakHashMap = AbstractC0604eo2.a;
                view2.setScrollIndicators(i5, 3);
                if (viewFindViewById11 != null) {
                    viewGroupB2.removeView(viewFindViewById11);
                }
                if (viewFindViewById12 != null) {
                    viewGroupB2.removeView(viewFindViewById12);
                }
            }
        }
        AlertController$RecycleListView alertController$RecycleListView2 = q6Var.f;
        if (alertController$RecycleListView2 == null || (listAdapter = q6Var.x) == null) {
            return;
        }
        alertController$RecycleListView2.setAdapter(listAdapter);
        int i6 = q6Var.y;
        if (i6 > -1) {
            alertController$RecycleListView2.setItemChecked(i6, true);
            alertController$RecycleListView2.setSelection(i6);
        }
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyDown(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.y.r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyDown(i, keyEvent);
        }
        return true;
    }

    @Override // android.app.Dialog, android.view.KeyEvent.Callback
    public boolean onKeyUp(int i, KeyEvent keyEvent) {
        NestedScrollView nestedScrollView = this.y.r;
        if (nestedScrollView == null || !nestedScrollView.i(keyEvent)) {
            return super.onKeyUp(i, keyEvent);
        }
        return true;
    }

    @Override // defpackage.AbstractDialogC0788hb, android.app.Dialog
    public final void setTitle(CharSequence charSequence) {
        super.setTitle(charSequence);
        q6 q6Var = this.y;
        q6Var.d = charSequence;
        TextView textView = q6Var.u;
        if (textView != null) {
            textView.setText(charSequence);
        }
        q6Var.c.setTitle(charSequence);
    }
}
