package defpackage;

import android.content.Context;
import android.content.ContextWrapper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterView;
import androidx.appcompat.view.menu.ExpandedMenuView;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class JG0 implements TQ0, AdapterView.OnItemClickListener {
    public Context t;
    public LayoutInflater u;
    public MenuC0775hQ0 v;
    public ExpandedMenuView w;
    public final int x;
    public SQ0 y;
    public IG0 z;

    public JG0(ContextWrapper contextWrapper, int i) {
        this.x = i;
        this.t = contextWrapper;
        this.u = LayoutInflater.from(contextWrapper);
    }

    @Override // defpackage.TQ0
    public final void b(MenuC0775hQ0 menuC0775hQ0, boolean z) {
        SQ0 sq0 = this.y;
        if (sq0 != null) {
            sq0.b(menuC0775hQ0, z);
        }
    }

    @Override // defpackage.TQ0
    public final boolean c(DQ0 dq0) {
        return false;
    }

    @Override // defpackage.TQ0
    public final void d(SQ0 sq0) {
        throw null;
    }

    @Override // defpackage.TQ0
    public final boolean e(DQ0 dq0) {
        return false;
    }

    @Override // defpackage.TQ0
    public final void f() {
        IG0 ig0 = this.z;
        if (ig0 != null) {
            ig0.notifyDataSetChanged();
        }
    }

    @Override // defpackage.TQ0
    public final void h(Context context, MenuC0775hQ0 menuC0775hQ0) {
        if (this.t != null) {
            this.t = context;
            if (this.u == null) {
                this.u = LayoutInflater.from(context);
            }
        }
        this.v = menuC0775hQ0;
        IG0 ig0 = this.z;
        if (ig0 != null) {
            ig0.notifyDataSetChanged();
        }
    }

    @Override // defpackage.TQ0
    public final boolean i(SubMenuC1273pR1 subMenuC1273pR1) {
        if (!subMenuC1273pR1.hasVisibleItems()) {
            return false;
        }
        DialogInterfaceOnKeyListenerC1843zQ0 dialogInterfaceOnKeyListenerC1843zQ0 = new DialogInterfaceOnKeyListenerC1843zQ0();
        dialogInterfaceOnKeyListenerC1843zQ0.t = subMenuC1273pR1;
        Context context = subMenuC1273pR1.a;
        r6 r6Var = new r6(context);
        n6 n6Var = r6Var.a;
        JG0 jg0 = new JG0(n6Var.a, AbstractC0189Pp1.abc_list_menu_item_layout);
        dialogInterfaceOnKeyListenerC1843zQ0.v = jg0;
        jg0.y = dialogInterfaceOnKeyListenerC1843zQ0;
        subMenuC1273pR1.b(jg0, context);
        JG0 jg02 = dialogInterfaceOnKeyListenerC1843zQ0.v;
        if (jg02.z == null) {
            jg02.z = new IG0(jg02);
        }
        n6Var.o = jg02.z;
        n6Var.p = dialogInterfaceOnKeyListenerC1843zQ0;
        View view = subMenuC1273pR1.o;
        if (view != null) {
            n6Var.e = view;
        } else {
            n6Var.c = subMenuC1273pR1.n;
            n6Var.d = subMenuC1273pR1.m;
        }
        n6Var.m = dialogInterfaceOnKeyListenerC1843zQ0;
        s6 s6VarA = r6Var.a();
        dialogInterfaceOnKeyListenerC1843zQ0.u = s6VarA;
        s6VarA.setOnDismissListener(dialogInterfaceOnKeyListenerC1843zQ0);
        WindowManager.LayoutParams attributes = dialogInterfaceOnKeyListenerC1843zQ0.u.getWindow().getAttributes();
        attributes.type = 1003;
        attributes.flags |= 131072;
        dialogInterfaceOnKeyListenerC1843zQ0.u.show();
        SQ0 sq0 = this.y;
        if (sq0 == null) {
            return true;
        }
        sq0.d(subMenuC1273pR1);
        return true;
    }

    @Override // defpackage.TQ0
    public final boolean j() {
        return false;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.v.q(this.z.getItem(i), this, 0);
    }
}
