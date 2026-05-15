package defpackage;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import java.util.ArrayList;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class IG0 extends BaseAdapter {
    public int t = -1;
    public final /* synthetic */ JG0 u;

    public IG0(JG0 jg0) {
        this.u = jg0;
        a();
    }

    public final void a() {
        MenuC0775hQ0 menuC0775hQ0 = this.u.v;
        DQ0 dq0 = menuC0775hQ0.v;
        if (dq0 != null) {
            menuC0775hQ0.i();
            ArrayList arrayList = menuC0775hQ0.j;
            int size = arrayList.size();
            for (int i = 0; i < size; i++) {
                if (((DQ0) arrayList.get(i)) == dq0) {
                    this.t = i;
                    return;
                }
            }
        }
        this.t = -1;
    }

    @Override // android.widget.Adapter
    /* JADX INFO: renamed from: b, reason: merged with bridge method [inline-methods] */
    public final DQ0 getItem(int i) {
        JG0 jg0 = this.u;
        MenuC0775hQ0 menuC0775hQ0 = jg0.v;
        menuC0775hQ0.i();
        ArrayList arrayList = menuC0775hQ0.j;
        jg0.getClass();
        int i2 = this.t;
        if (i2 >= 0 && i >= i2) {
            i++;
        }
        return (DQ0) arrayList.get(i);
    }

    @Override // android.widget.Adapter
    public final int getCount() {
        JG0 jg0 = this.u;
        MenuC0775hQ0 menuC0775hQ0 = jg0.v;
        menuC0775hQ0.i();
        int size = menuC0775hQ0.j.size();
        jg0.getClass();
        return this.t < 0 ? size : size - 1;
    }

    @Override // android.widget.Adapter
    public final long getItemId(int i) {
        return i;
    }

    @Override // android.widget.Adapter
    public final View getView(int i, View view, ViewGroup viewGroup) {
        if (view == null) {
            JG0 jg0 = this.u;
            view = jg0.u.inflate(jg0.x, viewGroup, false);
        }
        ((VQ0) view).d(getItem(i));
        return view;
    }

    @Override // android.widget.BaseAdapter
    public final void notifyDataSetChanged() {
        a();
        super.notifyDataSetChanged();
    }
}
