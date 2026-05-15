package defpackage;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import androidx.appcompat.view.menu.ListMenuItemView;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class eQ0 extends BaseAdapter {
    public final MenuC0775hQ0 t;
    public int u = -1;
    public boolean v;
    public final boolean w;
    public final LayoutInflater x;
    public final int y;

    public eQ0(MenuC0775hQ0 menuC0775hQ0, LayoutInflater layoutInflater, boolean z, int i) {
        this.w = z;
        this.x = layoutInflater;
        this.t = menuC0775hQ0;
        this.y = i;
        a();
    }

    public final void a() {
        MenuC0775hQ0 menuC0775hQ0 = this.t;
        DQ0 dq0 = menuC0775hQ0.v;
        if (dq0 != null) {
            menuC0775hQ0.i();
            ArrayList arrayList = menuC0775hQ0.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((DQ0) arrayList.get(i)) == dq0) {
                    this.u = i;
                    return;
                }
            }
        }
        this.u = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final DQ0 getItem(int i) {
        ArrayList arrayListL;
        MenuC0775hQ0 menuC0775hQ0 = this.t;
        if (this.w) {
            menuC0775hQ0.i();
            arrayListL = menuC0775hQ0.j;
        } else {
            arrayListL = menuC0775hQ0.l();
        }
        int i2 = this.u;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (DQ0) arrayListL.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        ArrayList arrayListL;
        MenuC0775hQ0 menuC0775hQ0 = this.t;
        if (this.w) {
            menuC0775hQ0.i();
            arrayListL = menuC0775hQ0.j;
        } else {
            arrayListL = menuC0775hQ0.l();
        }
        return this.u < 0 ? arrayListL.size() : arrayListL.size() - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            view = this.x.inflate(this.y, viewGroup, false);
        }
        int i2 = getItem(i).b;
        int i3 = i - 1;
        ListMenuItemView listMenuItemView = (ListMenuItemView) view;
        boolean z = this.t.m() && i2 != (i3 >= 0 ? getItem(i3).b : i2);
        ImageView imageView = listMenuItemView.A;
        if (imageView != null) {
            imageView.setVisibility((listMenuItemView.H || !z) ? 8 : 0);
        }
        VQ0 vq0 = (VQ0) view;
        if (this.v) {
            listMenuItemView.f8J = true;
            listMenuItemView.F = true;
        }
        vq0.d(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
