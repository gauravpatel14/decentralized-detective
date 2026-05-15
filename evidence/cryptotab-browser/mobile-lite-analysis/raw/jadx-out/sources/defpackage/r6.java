package defpackage;

import android.R;
import android.content.Context;
import android.content.DialogInterface;
import android.graphics.drawable.Drawable;
import android.view.ContextThemeWrapper;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.appcompat.app.AlertController$RecycleListView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class r6 {
    public final n6 a;
    public final int b;

    public r6(Context context) {
        this(s6.i(0, context), context);
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r13v2, types: [android.widget.ListAdapter] */
    /* JADX WARN: Type inference failed for: r13v4 */
    /* JADX WARN: Type inference failed for: r13v5 */
    /* JADX WARN: Type inference failed for: r13v6 */
    public s6 a() {
        ?? p6Var;
        n6 n6Var = this.a;
        s6 s6Var = new s6(this.b, n6Var.a);
        View view = n6Var.e;
        q6 q6Var = s6Var.y;
        if (view != null) {
            q6Var.w = view;
        } else {
            CharSequence charSequence = n6Var.d;
            if (charSequence != null) {
                q6Var.d = charSequence;
                TextView textView = q6Var.u;
                if (textView != null) {
                    textView.setText(charSequence);
                }
                q6Var.c.setTitle(charSequence);
            }
            Drawable drawable = n6Var.c;
            if (drawable != null) {
                q6Var.s = drawable;
                ImageView imageView = q6Var.t;
                if (imageView != null) {
                    imageView.setVisibility(0);
                    q6Var.t.setImageDrawable(drawable);
                }
            }
        }
        CharSequence charSequence2 = n6Var.f;
        if (charSequence2 != null) {
            q6Var.e = charSequence2;
            TextView textView2 = q6Var.v;
            if (textView2 != null) {
                textView2.setText(charSequence2);
            }
        }
        CharSequence charSequence3 = n6Var.g;
        if (charSequence3 != null) {
            q6Var.c(-1, charSequence3, n6Var.h);
        }
        CharSequence charSequence4 = n6Var.i;
        if (charSequence4 != null) {
            q6Var.c(-2, charSequence4, n6Var.j);
        }
        if (n6Var.n != null || n6Var.o != null) {
            AlertController$RecycleListView alertController$RecycleListView = (AlertController$RecycleListView) n6Var.b.inflate(q6Var.A, (ViewGroup) null);
            boolean z = n6Var.s;
            ContextThemeWrapper contextThemeWrapper = n6Var.a;
            if (z) {
                p6Var = new k6(n6Var, contextThemeWrapper, q6Var.B, n6Var.n, alertController$RecycleListView);
            } else {
                int i = n6Var.t ? q6Var.C : q6Var.D;
                Object obj = n6Var.o;
                p6Var = obj;
                if (obj == null) {
                    p6Var = new p6(contextThemeWrapper, i, R.id.text1, n6Var.n);
                }
            }
            q6Var.x = p6Var;
            q6Var.y = n6Var.u;
            if (n6Var.p != null) {
                alertController$RecycleListView.setOnItemClickListener(new l6(n6Var, q6Var));
            } else if (n6Var.v != null) {
                alertController$RecycleListView.setOnItemClickListener(new m6(n6Var, alertController$RecycleListView, q6Var));
            }
            if (n6Var.t) {
                alertController$RecycleListView.setChoiceMode(1);
            } else if (n6Var.s) {
                alertController$RecycleListView.setChoiceMode(2);
            }
            q6Var.f = alertController$RecycleListView;
        }
        View view2 = n6Var.q;
        if (view2 != null) {
            q6Var.g = view2;
            q6Var.h = false;
        }
        s6Var.setCancelable(n6Var.k);
        if (n6Var.k) {
            s6Var.setCanceledOnTouchOutside(true);
        }
        s6Var.setOnCancelListener(n6Var.l);
        s6Var.setOnDismissListener(null);
        DialogInterfaceOnKeyListenerC1843zQ0 dialogInterfaceOnKeyListenerC1843zQ0 = n6Var.m;
        if (dialogInterfaceOnKeyListenerC1843zQ0 != null) {
            s6Var.setOnKeyListener(dialogInterfaceOnKeyListenerC1843zQ0);
        }
        return s6Var;
    }

    public final void b(int i) {
        n6 n6Var = this.a;
        n6Var.f = n6Var.a.getText(i);
    }

    public final void c(int i, DialogInterface.OnClickListener onClickListener) {
        n6 n6Var = this.a;
        n6Var.i = n6Var.a.getText(i);
        n6Var.j = onClickListener;
    }

    public final void d(int i, DialogInterface.OnClickListener onClickListener) {
        n6 n6Var = this.a;
        n6Var.g = n6Var.a.getText(i);
        n6Var.h = onClickListener;
    }

    public final void e(int i) {
        n6 n6Var = this.a;
        n6Var.d = n6Var.a.getText(i);
    }

    public final s6 f() {
        s6 s6VarA = a();
        s6VarA.show();
        return s6VarA;
    }

    public r6(int i, Context context) {
        this.a = new n6(new ContextThemeWrapper(context, s6.i(i, context)));
        this.b = i;
    }
}
