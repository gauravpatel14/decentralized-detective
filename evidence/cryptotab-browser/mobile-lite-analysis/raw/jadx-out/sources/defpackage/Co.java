package defpackage;

import android.content.Context;
import android.content.res.ColorStateList;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListAdapter;
import android.widget.ListView;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.WeakHashMap;
import org.chromium.ui.modelutil.PropertyModel;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public final class Co implements InterfaceC1772yG0, AdapterView.OnItemClickListener {
    public final ListView t;
    public final FG0 u;
    public final View v;
    public final LinkedList w;
    public final InterfaceC1719xG0 x;

    public Co(Context context, QJ0 qj0, View view, ListView listView, InterfaceC1719xG0 interfaceC1719xG0, int i) {
        final int i2 = 1;
        final int i3 = 0;
        FG0 fg0 = new FG0(qj0);
        this.u = fg0;
        this.v = view;
        this.t = listView;
        listView.setAdapter((ListAdapter) fg0);
        listView.setDivider(null);
        listView.setOnItemClickListener(this);
        this.x = interfaceC1719xG0;
        this.w = new LinkedList();
        fg0.a(1, new iE0(AbstractC0189Pp1.list_menu_item), new InterfaceC0436bn1() { // from class: Bo
            @Override // defpackage.InterfaceC0436bn1
            public final void f(Object obj, Object obj2, Object obj3) {
                int iE;
                PropertyModel propertyModel = (PropertyModel) obj;
                View view2 = (View) obj2;
                AbstractC0197Qm1 abstractC0197Qm1 = (AbstractC0197Qm1) obj3;
                switch (i3) {
                    case 0:
                        HG0.a(propertyModel, view2, abstractC0197Qm1);
                        break;
                    default:
                        C0272Wm1 c0272Wm1 = AbstractC0951kH0.a;
                        if (abstractC0197Qm1 == c0272Wm1) {
                            int iE2 = propertyModel.e(c0272Wm1);
                            if (iE2 != 0) {
                                view2.setPadding(view2.getContext().getResources().getDimensionPixelSize(iE2), view2.getPaddingTop(), view2.getPaddingRight(), view2.getPaddingBottom());
                            }
                            break;
                        } else {
                            C0272Wm1 c0272Wm12 = AbstractC0951kH0.b;
                            if (abstractC0197Qm1 == c0272Wm12 && (iE = propertyModel.e(c0272Wm12)) != 0) {
                                view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getContext().getResources().getDimensionPixelSize(iE), view2.getPaddingBottom());
                                break;
                            }
                        }
                        break;
                }
            }
        });
        fg0.a(0, new iE0(AbstractC0189Pp1.list_section_divider), new InterfaceC0436bn1() { // from class: Bo
            @Override // defpackage.InterfaceC0436bn1
            public final void f(Object obj, Object obj2, Object obj3) {
                int iE;
                PropertyModel propertyModel = (PropertyModel) obj;
                View view2 = (View) obj2;
                AbstractC0197Qm1 abstractC0197Qm1 = (AbstractC0197Qm1) obj3;
                switch (i2) {
                    case 0:
                        HG0.a(propertyModel, view2, abstractC0197Qm1);
                        break;
                    default:
                        C0272Wm1 c0272Wm1 = AbstractC0951kH0.a;
                        if (abstractC0197Qm1 == c0272Wm1) {
                            int iE2 = propertyModel.e(c0272Wm1);
                            if (iE2 != 0) {
                                view2.setPadding(view2.getContext().getResources().getDimensionPixelSize(iE2), view2.getPaddingTop(), view2.getPaddingRight(), view2.getPaddingBottom());
                            }
                            break;
                        } else {
                            C0272Wm1 c0272Wm12 = AbstractC0951kH0.b;
                            if (abstractC0197Qm1 == c0272Wm12 && (iE = propertyModel.e(c0272Wm12)) != 0) {
                                view2.setPadding(view2.getPaddingLeft(), view2.getPaddingTop(), view2.getContext().getResources().getDimensionPixelSize(iE), view2.getPaddingBottom());
                                break;
                            }
                        }
                        break;
                }
            }
        });
        if (i != 0) {
            ColorStateList colorStateListValueOf = ColorStateList.valueOf(context.getColor(i));
            WeakHashMap weakHashMap = AbstractC0604eo2.a;
            view.setBackgroundTintList(colorStateListValueOf);
        }
    }

    @Override // defpackage.InterfaceC1772yG0
    public final void a(Runnable runnable) {
        this.w.add(runnable);
    }

    @Override // defpackage.InterfaceC1772yG0
    public final int b() {
        return AbstractC1632vj2.a(this.u, this.t)[0];
    }

    @Override // defpackage.InterfaceC1772yG0
    public final View g() {
        return this.v;
    }

    @Override // android.widget.AdapterView.OnItemClickListener
    public final void onItemClick(AdapterView adapterView, View view, int i, long j) {
        this.x.a(((PJ0) this.u.t.u.get(i)).b);
        Iterator it = this.w.iterator();
        while (it.hasNext()) {
            ((Runnable) it.next()).run();
        }
    }
}
