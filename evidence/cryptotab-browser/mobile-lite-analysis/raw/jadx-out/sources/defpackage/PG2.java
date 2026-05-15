package defpackage;

import com.google.android.play.core.splitinstall.internal.zzbl;
import java.lang.reflect.Field;

/* JADX INFO: compiled from: chromium-ChromePublic.aab-stable-260119 */
/* JADX INFO: loaded from: classes.dex */
public class PG2 {
    public final Object a;
    public final Field b;
    public final Class c;

    public PG2(Object obj, Field field, Class cls) {
        this.a = obj;
        this.b = field;
        this.c = cls;
    }

    public final Object a() {
        Object obj = this.a;
        Field field = this.b;
        Class cls = this.c;
        try {
            return cls.cast(field.get(obj));
        } catch (Exception e) {
            throw new zzbl("Failed to get value of field " + field.getName() + " of type " + obj.getClass().getName() + " on object of type " + cls.getName(), e);
        }
    }

    public final void b(Object obj) {
        Object obj2 = this.a;
        Field field = this.b;
        try {
            field.set(obj2, obj);
        } catch (Exception e) {
            throw new zzbl("Failed to set value of field " + field.getName() + " of type " + obj2.getClass().getName() + " on object of type " + this.c.getName(), e);
        }
    }
}
